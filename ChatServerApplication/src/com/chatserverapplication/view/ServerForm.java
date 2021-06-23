package com.chatserverapplication.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.chatserverapplication.thread.ServerThread;
import com.chatserverapplication.thread.ThreadTime;

import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServerForm extends JFrame {

	private JPanel contentPane;
	private JLabel lblTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerForm frame = new ServerForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ServerForm() {
		setType(Type.POPUP);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnStartServer = new JButton("START SERVER");
		btnStartServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThreadTime tt = new ThreadTime(lblTime);
				ServerThread st = new ServerThread();

			}
		});
		btnStartServer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnStartServer.setBounds(149, 91, 153, 52);
		contentPane.add(btnStartServer);

		lblTime = new JLabel("");
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTime.setBounds(321, 10, 115, 27);
		contentPane.add(lblTime);
	}

}
