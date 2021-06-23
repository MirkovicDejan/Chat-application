package com.chatserverapplication.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.chatserver.controller.Controller;

public class ClientThread extends Thread {
	private Socket socket;

	public ClientThread(Socket socket) {
		
		this.socket = socket;
		start();
	}

	@Override
	public void run() {
		
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String user = bf.readLine();
			Controller.getInstance().add(this);
			while (true) {
				String message = bf.readLine();
				if (message != null && !message.isEmpty()) {
					Controller.getInstance().notifyClient("\n " + user + "  : " + message + " \n ", this);
				}
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public void send(String message) {

		PrintWriter printWriter;
		try {
			printWriter = new PrintWriter(socket.getOutputStream(), true);
			printWriter.println(message);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
