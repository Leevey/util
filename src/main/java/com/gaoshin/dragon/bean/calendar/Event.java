package com.gaoshin.dragon.bean.calendar;

import java.io.Serializable;

public class Event  implements Serializable {
	public String id;
	public long created;
	public long updated;
	public String userId;
	public String title;
	public String note;
	public String courseId;
	public String parentEventId;
	public long startTime;
	public long endTime;
	public Long repeatStartTime;
	public Long repeatEndTime;
	public long firstAlert;
	public long secondAlert;
	public String repeatCronFormat;
	public String forUserId;
	
	public String country;
	public String city;
	public String address;
	public Float latitude;
	public Float longitude;
}
