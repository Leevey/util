package com.gaoshin.dragon.bean.local;

import com.gaoshin.dragon.bean.storage.MediaContent;

import java.util.List;

public class Advertising {
	public String id;
	public long created;
	public long updated;
	public String name;
	public String content;
	public List<MediaContent> resources;
	public String userId;
	public String country;
	public String state;
	public String city;
	public String address;
	public String phone;
	public String email;
	public Float latitude;
	public Float longitude;
}
