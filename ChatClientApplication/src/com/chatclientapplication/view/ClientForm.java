package com.chatclientapplication.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.chatclientapplication.thread.ThreadRead;
import com.chatclientapplication.thread.ThreadWriting;
import com.chatsharedapplication.constants.ConnectionConstants;
import com.chatsharedapplication.domain.Message;

import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class ClientForm extends JFrame {

	private JPanel contentPane;
	private JTextField tfUser;
	private JTextField tfMessage;
	private Message message;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientForm frame = new ClientForm();
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
	public ClientForm() {
		setType(Type.POPUP);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUser = new JLabel("USER :");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUser.setBounds(10, 10, 58, 26);
		contentPane.add(lblUser);

		tfUser = new JTextField();
		tfUser.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfUser.setBounds(65, 10, 223, 31);
		contentPane.add(tfUser);
		tfUser.setColumns(10);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String user = tfUser.getText();
				if (user != null && !user.isEmpty()) {

					message = new Message();
					btnLogin.setVisible(false);
					tfUser.setVisible(false);

					try {
						Socket socket = new Socket(ConnectionConstants.IP_ADREES.getIpAdress(),
								ConnectionConstants.PORT.getPort());
						BufferedReader bufferedReader = new BufferedReader(
								new InputStreamReader(socket.getInputStream()));
						PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
						printWriter.println(user);
						ThreadRead tr = new ThreadRead(bufferedReader, textArea);
						ThreadWriting tw = new ThreadWriting(message, printWriter);

					} catch (UnknownHostException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}

		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.setBounds(298, 6, 100, 38);
		contentPane.add(btnLogin);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 388, 287);
		contentPane.add(scrollPane);

		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 12));
		scrollPane.setViewportView(textArea);

		JLabel lblMessage = new JLabel(" MESSAGE :");
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMessage.setBounds(10, 350, 100, 25);
		contentPane.add(lblMessage);

		tfMessage = new JTextField();
		tfMessage.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfMessage.setBounds(10, 373, 388, 38);
		contentPane.add(tfMessage);
		tfMessage.setColumns(10);

		JButton btnSend = new JButton("SEND");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				insert();

			}
		});
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSend.setBounds(298, 421, 100, 38);
		contentPane.add(btnSend);
	}

	protected void insert() {
		String messageInsert = tfMessage.getText();
		textArea.append("\n" + "Me : " + messageInsert + " \n");
		message.setMessage(messageInsert);
		tfMessage.setText("");

	}
}
