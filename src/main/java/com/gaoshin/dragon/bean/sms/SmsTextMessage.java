package com.gaoshin.dragon.bean.sms;

public class SmsTextMessage {
	public String to;
	public String msg;

	public SmsTextMessage() {
	}

	public SmsTextMessage(String to, String msg) {
		this.to = to;
		this.msg = msg;
	}
}
