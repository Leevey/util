package com.gaoshin.dragon.bean.user;

import java.io.Serializable;

public class UserFriend implements Serializable {
	public String id;
	public long created;
	public long updated;
	public String userId;
	public String friendId;
	public FriendStatus status;
	public String introductionMsg;
}
