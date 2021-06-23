package com.chatserver.controller;

import java.util.ArrayList;
import java.util.List;

import com.chatserverapplication.thread.ClientThread;
import com.chatserverapplication.view.ServerForm;

public class Controller {

	private volatile static Controller instance;
	private ServerForm serverForm;
	private static Object mutex = new Object();
	private final List<ClientThread> list = new ArrayList<ClientThread>();

	private Controller() {

	}

	public static Controller getInstance() {
		Controller result = instance;
		if (instance == null) {
			synchronized (mutex) {
				if (instance == null) {
					result = instance = new Controller();
				}
			}

		}
		return instance;
	}

	public void add(ClientThread clientThread) {
		list.add(clientThread);
	}

	public void notifyClient(String message, ClientThread clientThread) {
		for (ClientThread ck : list) {
			if (!ck.equals(clientThread)) {
				ck.send(message);
			}
		}

	}

}
