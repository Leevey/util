package com.gaoshin.dragon.bean.course;

import com.gaoshin.dragon.bean.storage.MediaContent;

import java.io.Serializable;
import java.util.List;

public class Course  implements Serializable {
	public String id;
	public long created;
	public long updated;
	public String userId;
	public String title;
	public String content;
	public String parentCourseId;
	public boolean isDir;
	public String link;
	public int ageStart;
	public int ageEnd;
	public List<MediaContent> resources;
	public int value;
	public String originalCourseId;
}
