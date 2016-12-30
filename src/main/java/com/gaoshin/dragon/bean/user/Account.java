package com.gaoshin.dragon.bean.user;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

import java.io.Serializable;

public class Account implements Serializable {
	public String id;
	public long created;
	public long updated;
	public String userId;
	public String extId;
	public String info;
	public AccountType type;
	public boolean verified;
	public String token;
	
	@Override
	public int hashCode() {
		return (int) Hashing.md5().hashString(type + "/" + extId,  Charsets.UTF_8).asLong();
	}
	
}
