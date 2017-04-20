package com.jingsky.util.load;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.jingsky.util.common.DBUtil;
import com.jingsky.util.io.CsvWriterUtil;
import com.jingsky.util.lang.ReflectUtil;
import com.jingsky.util.lang.StringUtil;
import com.jingsky.util.web.PageUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 加载数据综合类。
 * @author 朱志杰 QQ：862990787
 * Sep 16, 2013 10:51:32 AM
 */
public class LoadUtil {
	
	//sql语句
	private String sql;
	//每页显示个数
	private int pageSize;
	//当前为第几页
	private int currentPage;
	//dbutil
	private DBUtil dbUtil=null;
	//统计语句
	private String total=null;
	//二次处理的类
	private ILoadHandler loadHandler=null;
	
	/**
	 * 功能：查询出来当前页的记录，并转换为json进行返回。
	 * @author 朱志杰 QQ：862990787
	 * Sep 17, 2013 8:35:49 AM
	 * @return String json数据
	 * @throws SQLException 
	 * @throws JSONException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws NoSuchMethodException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 */
	public String queryData() throws SQLException, JSONException, SecurityException, 
		IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException{
		//进行一些统计。
		String countSql="select count(*) a ";
		//读取统计语句
		String[] totalArr=null;	//统计语句分组
		if(!StringUtil.isEmpty(total)){
			totalArr=total.split("#");
			for(int i=0 ; i<totalArr.length ; i++){
				if(i%2==1){
					countSql+=(","+totalArr[i]+" ");
				}
			}
		}
		countSql+=(sql.substring(sql.indexOf("from")));
		//System.out.println(countSql);
		List<Map<String,Object>> list=dbUtil.query(countSql);
		//总记录数
		int recordNum=Integer.parseInt(list.get(0).get("a").toString());
		
		//无数据时，直接返回无数据。
		if(recordNum==0){
			JSONArray ja=new JSONArray();
			JSONObject jo=new JSONObject();
			jo.put("pageInfo", "无符合条件数据.");
			ja.put(jo);
			return ja.toString();
		}
		
		//得到一些分页信息
		Map<String,Integer> pageInfo= PageUtil.getCurrentPageInfo(currentPage, pageSize, recordNum);
		String pageStr=PageUtil.getAjaxPageHtml("ajaxPageChange", currentPage, pageInfo.get("totalPage"), recordNum);
		
		//进行数据的查询。
		List<Map<String,Object>> dataList=dbUtil.query(sql+" limit "+(pageInfo.get("firstRecord")-1)+","+pageSize);
		//如果设置的有处理接口，对查询出来的数据库进行处理。
		if(loadHandler!=null){
			dataList=(List<Map<String,Object>>) ReflectUtil.invokeMethod(this.loadHandler, "handleData", dataList);
		}
		JSONArray ja=listToJSON(dataList);
		//将分页信息放入到json中。
		JSONObject jo=new JSONObject();
		jo.put("pageInfo", pageStr);
		ja.put(jo);
		
		//将统计信息放入到json
		String newTotal="";//计算后的统计语句
		if(totalArr!=null){
			//读取出来统计信息
			Object temp=null;	//统计的临时值变量
			for(int i=0 ; i<totalArr.length ; i++){
				if(i%2==1){
					temp=list.get(0).get(totalArr[i]);
					newTotal+=(temp==null ? 0 : temp.toString());
				}else{
					newTotal+=totalArr[i];
				}
			}
			JSONObject totalJson=new JSONObject();
			jo.put("total", newTotal);
			ja.put(totalJson);
		}
		//System.out.println(jo.toString());
		return ja.toString();
	}
	
	/**
	 * 功能：将List<Map<String,Object>>数据转换为json字符串。
	 * @author 朱志杰 QQ：862990787
	 * Sep 17, 2013 8:36:52 AM
	 * @param data 源数据
	 * @return JSONArray
	 * @throws JSONException 
	 */
	private JSONArray listToJSON(List<Map<String,Object>> data) throws JSONException{
		JSONArray ja=new JSONArray();
		for(Map<String,Object> map : data){
			JSONObject json=new JSONObject();
			for(String key : map.keySet()){
				json.put(key, map.get(key));
			}
			ja.put(json);
		}
		//System.out.println(ja.toString());
		return ja;
	}
	
	/**
	 * 功能：
	 * @author 朱志杰 QQ：862990787
	 * Sep 16, 2013 11:20:25 AM
	 * @param dbUtilStr 得到dbutil对应的类的静态方法,例如net.aa.getDbUtil
	 * @param sql sql语句
	 * @param pageSize 每页显示的个数
	 * @param currentPage 当前第几页
	 * @param total 统计语句
	 * @param loadHandlerName 二次处理的全类名
	 * @throws ClassNotFoundException 
	 */
	public LoadUtil(String dbUtilStr,String sql ,int pageSize,int currentPage,String total,String loadHandlerName) throws Exception{
		this.sql=sql;
		this.pageSize=pageSize;
		this.currentPage=currentPage;
		this.total=total;
		
		//截取出来全类名和静态方法名
		String functionName=dbUtilStr.substring(dbUtilStr.lastIndexOf(".")+1);
		String className=dbUtilStr.substring(0,dbUtilStr.lastIndexOf("."));
		//反射得到dbutil
		Class cla = Class.forName(className);
		this.dbUtil=(DBUtil)ReflectUtil.invokeStaticMethod(cla, functionName, new Object[]{});
		//如果loadHandler 不为空，反射出来对应的二次处理类一个实例。
		if(!StringUtil.isEmpty(loadHandlerName)){
			this.loadHandler=ReflectUtil.getInstance(loadHandlerName);
			//调取sql处理函数
			this.sql=ReflectUtil.invokeMethod(this.loadHandler, "handleSQL", this.sql).toString();
		}
	}

	/**
	 * 功能：导出数据到CSV。
	 * @author 朱志杰 QQ：862990787
	 * 2013-10-26 下午05:53:19
	 * @param response 输出
	 * @throws SQLException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws NoSuchMethodException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws IOException 
	 */
	public void exportData(HttpServletResponse response) throws SQLException, SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
		//进行数据的查询。
		List<Map<String,Object>> dataList=dbUtil.query(sql);
		//如果设置的有处理接口，对查询出来的数据库进行处理。
		if(loadHandler!=null){
			dataList=(List<Map<String,Object>>)ReflectUtil.invokeMethod(this.loadHandler, "handleData", dataList);
		}
		//进行导出操作。
		Charset utf=Charset.forName("UTF-8");
		CsvWriterUtil writer=new CsvWriterUtil((OutputStream)response.getOutputStream(),',',utf);
		//循环每一条写入
		String[] line=null;
//		for(Map<String,Object> map :dataList){
//			line=new String[map.size()];
//			for()
//		}
//		writer.writeRecord(values)
		
		
	}
}
