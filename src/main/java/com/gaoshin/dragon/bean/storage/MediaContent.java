package com.gaoshin.dragon.bean.storage;


public class MediaContent {
	public String path;
	public long created;
	public String contentType;
	public long length;
	public String name;
	public String url;
	
	@Override
	public boolean equals(Object obj) {
	    if(obj == null) return false;
	    if(!(obj instanceof MediaContent)) return false;
	    MediaContent mc = (MediaContent) obj;
	    if(this.path == null) return false;
	    return path.equals(mc.path);
	}
}
