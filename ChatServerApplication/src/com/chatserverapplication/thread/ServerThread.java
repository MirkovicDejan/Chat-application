package com.chatserverapplication.thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.chatsharedapplication.constants.ConnectionConstants;

public class ServerThread extends Thread {

	public ServerThread() {
		super();
		start();
	}

	@Override
	public void run() {
		
		try {
			ServerSocket serverSocket = new ServerSocket(ConnectionConstants.PORT.getPort());
			while (true) {
				Socket socket = serverSocket.accept();
				ClientThread client = new ClientThread(socket);

			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
