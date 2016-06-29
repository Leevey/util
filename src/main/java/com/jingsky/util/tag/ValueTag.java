package com.jingsky.util.tag;

import com.jingsky.util.lang.ReflectUtil;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

/**
 * 字典表JSTL自定义标签。（根据字典类，key显示对应的值）
 * @author 朱志杰
 */
public class ValueTag extends TagSupport {
	//全类名
	private String className=null;
	//要展示的内容的key
	private String key=null;

	@Override
	public int doStartTag() throws JspException {
		try {
			BaseDict dict=ReflectUtil.getInstance(className);
			Method mapM = BaseDict.class.getDeclaredMethod("getMap");
			//得到函数返回的map
			Map map=(Map)mapM.invoke(dict);
			//得到真实key
			Object realKey=null;
			for(Iterator ite = map.entrySet().iterator(); ite.hasNext();){
				Map.Entry entry = (Map.Entry) ite.next();
				if(entry.getKey() instanceof Integer){
					realKey = Integer.parseInt(key);
				}else{
					realKey=key;
				}
				break;
			}

			Method m = BaseDict.class.getDeclaredMethod("getValue", Object.class);
			//得到函数返回的map
			Object value=m.invoke(dict, realKey);
			
			JspWriter out = this.pageContext.getOut();
			out.print(value==null ? "" : value);
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


	public void setKey(String key) {
		this.key = key;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}

}
