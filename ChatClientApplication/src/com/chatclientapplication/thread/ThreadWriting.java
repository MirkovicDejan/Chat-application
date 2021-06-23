package com.chatclientapplication.thread;

import java.io.PrintWriter;

import com.chatsharedapplication.domain.Message;

public class ThreadWriting extends Thread {

	private Message message;
	private PrintWriter pw;

	public ThreadWriting(Message message, PrintWriter pw) {
		super();
		this.message = message;
		this.pw = pw;
		start();
	}

	@Override
	public void run() {
		
		super.run();
		while (true) {
			pw.println(message.getMessage());
		}
	}

}
