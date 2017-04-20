package com.jingsky.util.load;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 对加载数据进行二次处理的基类。
 * @author 朱志杰 QQ：862990787
 * Sep 21, 2013 8:34:58 PM
 */
public interface ILoadHandler {
	
	/**
	 * 功能：处理sql
	 * @author 朱志杰 QQ：862990787
	 * Sep 21, 2013 8:40:53 PM
	 * @param sql 源sql
	 * @return String
	 */
	public String handleSQL(String sql);
	
	/**
	 * 功能：处理每页数据。
	 * @author 朱志杰 QQ：862990787
	 * Sep 21, 2013 8:41:13 PM
	 * @param data 源数据
	 * @return List<Map<String,Object>>
	 */
	public List<Map<String,Object>> handleData(ArrayList<Map<String, Object>> data);
}
