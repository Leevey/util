package com.gaoshin.dragon.bean;

import java.io.Serializable;

public class GenericResponse implements Serializable {
	public String msg;
	
	public GenericResponse() {
	}
	
	public GenericResponse(String msg) {
		this.msg = msg;
	}
	
}