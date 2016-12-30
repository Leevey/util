package com.gaoshin.dragon.bean.journal;

import com.gaoshin.dragon.bean.storage.MediaContent;

import java.io.Serializable;
import java.util.List;

public class Journal  implements Serializable {
	public String id;
	public long created;
	public long updated;
	public String userId;
	public String content;
	public String link;
	public List<MediaContent> resources;
}
