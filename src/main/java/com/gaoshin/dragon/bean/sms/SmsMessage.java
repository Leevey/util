package com.gaoshin.dragon.bean.sms;

public class SmsMessage {
	public String to;
	public String template;
	public String params;

	public SmsMessage() {
	}

	public SmsMessage(String to, String template, String params) {
		this.to = to;
		this.template = template;
		this.params = params;
	}
}
