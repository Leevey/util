package com.gaoshin.dragon.bean.user;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
	public String id;
	public long created;
	public long updated;
	public UserType type;
	public UserStatus status;
	public Gender gender;
	public String imgPath;
	public String name;
	public String phone;
	public String email;
	public String country;
    public String province;
    public String city;
	public String password;
	public List<String> interestedAges;
	public Float latitude;
	public Float longitude;
}
