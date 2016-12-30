package com.gaoshin.dragon.bean.search;

import java.util.Map;

public class Document {
	public String id;
	public Long created;
	public Long updated;
	public String type;
	public String name;
	public String content;
	public Float latitude;
	public Float longitude;
	public int ranking;
	public Map<String, Object> dynamicFields;
}
