package com.chatsharedapplication.domain;

public class Message {

	private String message;

	public synchronized String getMessage() {

		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return message;
	}

	public synchronized void setMessage(String message) {
		this.message = message;
		notify();
	}

}
