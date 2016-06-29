package com.jingsky.util.tag;

import com.jingsky.util.lang.StringUtil;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 字典的基类
 * @author 朱志杰
 * @param <K>
 * @param <V>
 */
abstract public class BaseDict<K, V> {
	/**
	 * 放值的map
	 */
	protected Map<K,V> map=new LinkedHashMap<K,V>();
	
	/**
	 * 得到类型对应的字符串。
	 * 2015年6月2日下午4:15:17
	 * @author 朱志杰
	 * @param key
	 * @return
	 */
	public V getValue(Object key){
		return map.get(key);
	}
	
	public String getSelect(String id,String name,String selectedValue,String changeFunctionName){
		//输出的内容
		StringBuffer sb=new StringBuffer("<select name='"+name+"' id='"+id+"'>");
		for(Object key : map.keySet()){
			sb.append("<option value='"+key+"' ");
			if(selectedValue!=null && selectedValue.equals(key)){
				sb.append(" selected ");
			}
			//change事件
			if(!StringUtil.isEmpty(changeFunctionName)){
				sb.append(" onchange='"+changeFunctionName+"(this);' ");
			}
			sb.append(">"+map.get(key)+"</option>\n");
		}
		sb.append("</select>");
		return sb.toString();
	}

	public Map<K, V> getMap() {
		return map;
	}
	
}
