package com.jingsky.util.tag;

import com.jingsky.util.lang.ReflectUtil;
import com.jingsky.util.lang.StringUtil;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 字典表JSTL自定义标签。（根据字典类生成select）
 * @author 朱志杰
 */
public class SelectTag extends TagSupport {
	//全类名
	private String className=null;
	//select name
	private String name=null;
	//select id
	private String id=null;
	//select 选中的value
	private Object value=null;
	//额外增加一项的显示信息
	private String addShow=null;
	//额外增加一项的值
	private String addValue=null;
	//onchange方法调用的js函数名
	private String onchange=null;

	@Override
	public int doStartTag() throws JspException {
		try {
			//分类出来类名和函数名
			BaseDict dict= ReflectUtil.getInstance(className);
			Method m = BaseDict.class.getDeclaredMethod("getMap");
			//得到函数返回的map
			Map map=(Map)m.invoke(dict);
			//增加上额外项
			if(addShow!=null && addValue!=null){
				map.put(addValue, addShow);
			}
				
			JspWriter out = this.pageContext.getOut();
			//输出的内容
			StringBuffer sb=new StringBuffer("<select name='"+id+"' id='"+id+"' ");
			if(!StringUtil.isEmpty(this.onchange)){
				sb.append(" onchange='"+onchange+"(this);' ");
			}
			sb.append(">");
			for(Object key : map.keySet()){
				sb.append("<option value='"+key+"' ");
				if(value!=null && value.equals(key)){
					sb.append(" selected ");
				}
				sb.append(">"+map.get(key)+"</option>\n");
			}
			sb.append("</select>");
			out.print(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	@Override
	public void release() {
		super.release();
	}


	public void setClassName(String className) {
		this.className = className;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public void setAddShow(String addShow) {
		this.addShow = addShow;
	}

	public void setAddValue(String addValue) {
		this.addValue = addValue;
	}
}
