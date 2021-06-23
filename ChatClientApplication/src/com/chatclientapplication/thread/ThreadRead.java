package com.chatclientapplication.thread;

import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.IOException;

import javax.swing.JTextArea;

public class ThreadRead extends Thread {

	private BufferedReader bf;
	private JTextArea textArea;

	public ThreadRead(BufferedReader bf, JTextArea tectArea) {
		super();
		this.bf = bf;
		this.textArea = tectArea;
		start();
	}

	@Override
	public void run() {
		
		super.run();
		while (true) {
			try {
				String message = bf.readLine();
				textArea.append(message);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

}
