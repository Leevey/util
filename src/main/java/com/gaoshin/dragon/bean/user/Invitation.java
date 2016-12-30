package com.gaoshin.dragon.bean.user;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

import java.io.Serializable;

public class Invitation implements Serializable {
	public String id;
	public long created;
	public long updated;
	public String invitedByUserId;
	public String extId;
	public String info;
	public AccountType type;
	
	@Override
	public int hashCode() {
		return (int) Hashing.md5().hashString(type + "/" + extId,  Charsets.UTF_8).asLong();
	}
	
}
