package com.chatsharedapplication.constants;

public enum ConnectionConstants {

	IP_ADREES("127.0.0.1"), PORT(9000);

	String ipAdress;
	int port;

	private ConnectionConstants(String ipAdress) {
		this.ipAdress = ipAdress;
	}

	private ConnectionConstants(int port) {
		this.port = port;
	}

	public String getIpAdress() {
		return ipAdress;
	}

	public int getPort() {
		return port;
	}

}
