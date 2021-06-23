package com.chatserverapplication.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class ThreadTime extends Thread {

	private JLabel time;

	public ThreadTime(JLabel time) {
		super();
		this.time = time;
		start();
	}

	@Override
	public void run() {

		SimpleDateFormat smp = new SimpleDateFormat("HH:ss:mm");
		while (true) {

			time.setText(smp.format(new Date()));
			try {
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
