package com.se.spring.restException;

public class CustomErrorRespone {
	private int status;
	private String message;
	private long timeStamp;

	public CustomErrorRespone(int status, String message, long timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public CustomErrorRespone() {
		super();
	}

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

}
