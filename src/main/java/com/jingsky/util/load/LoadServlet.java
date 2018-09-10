package com.jingsky.util.load;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jingsky.util.lang.ExceptionUtil;
import com.jingsky.util.lang.StringUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * 加载数据的servlet，包含导出、查询等功能。
 * @author 朱志杰 QQ：862990787
 * Sep 16, 2013 11:19:44 AM
 */
public class LoadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3929169303025086145L;


	/**
	 * The doPost method of the servlet. <br>
	 * This method is called when a form has its tag value method equals to post.
	 * @param request the request send by the client to the server
	 * @param response the api send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//将要返回的json数据。
		String jsonStr=null;
		try {
			//导出
			if(StringUtil.isEmpty(request.getParameter("currentPage"))){
				LoadUtil loadUtil=new LoadUtil(request.getParameter("dbUtil"),request.getParameter("sql"),0,0,"",request.getParameter("loadHandler"));
				loadUtil.exportData(response);
			}else{
				//查询数据
				LoadUtil loadUtil=new LoadUtil(request.getParameter("dbUtil"),request.getParameter("sql"),
						Integer.parseInt(request.getParameter("pageSize")),Integer.parseInt(request.getParameter("currentPage"))
						,request.getParameter("total"),request.getParameter("loadHandler"));
				jsonStr=loadUtil.queryData();
			}
		} catch (SQLException e) {
			JSONArray ja=new JSONArray();
			JSONObject jo=new JSONObject();
			try {
				jo.put("pageInfo","sql异常："+ ExceptionUtil.getStackTrace(e));
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			ja.put(jo);
			jsonStr=ja.toString();
			e.printStackTrace();
		} catch (JSONException e) {
			JSONArray ja=new JSONArray();
			JSONObject jo=new JSONObject();
			try {
				jo.put("pageInfo","JSON异常："+ExceptionUtil.getStackTrace(e));
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			ja.put(jo);
			jsonStr=ja.toString();
			e.printStackTrace();
		}catch (Exception e) {
			JSONArray ja=new JSONArray();
			JSONObject jo=new JSONObject();
			try {
				jo.put("pageInfo","其他异常："+ExceptionUtil.getStackTrace(e));
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			ja.put(jo);
			jsonStr=ja.toString();
			e.printStackTrace();
		}
		response.getWriter().print(jsonStr);
		return ;
	}
	
	/**
	 * Constructor of the object.
	 */
	public LoadServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
	}

}
