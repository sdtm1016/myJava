package net.socket.qqDemo.client;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

//View层
public class GUI extends JFrame {

	private static final long serialVersionUID = -8596158456354228705L;
	// 聊天内容区
	private JTextArea chatArea;
	// 滚动条
	private JScrollPane scrollPane;
	// 联系人
	private JTable frendsList;
	// 输入内容区
	private JTextArea inputArea;
	// 发送按钮
	private JButton sentButton;

	public GUI() {
		super("QQ");
		init();
	}

	public void init() {
		this.setVisible(true);
		this.setSize(600, 400);
		this.setLocation(700, 400);
		this.setLayout(null);

		chatArea = new JTextArea();
		chatArea.setEditable(false);
		// chatArea.setBounds(0, 0, 490, 350);
		scrollPane = new JScrollPane(chatArea);
		scrollPane.setBounds(0, 0, 450, 250);
		this.add(scrollPane);

		inputArea = new JTextArea();
		inputArea.setBounds(0, 260, 365, 90);
		this.add(inputArea);

		sentButton = new JButton("发送");
		sentButton.setBounds(380, 280, 70, 50);
		sentButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String text = inputArea.getText();
				// System.out.println(text);
				ClientSocket clientSocket = ClientSocket.getInstance(GUI.this);
				clientSocket.sendText(text + "\r\t");
				inputArea.setText("");// 清空输入区
			}
		});
		this.add(sentButton);

		frendsList = new JTable();
		// frendsList = new JTable(model);
		frendsList.setBounds(470, 0, 100, 350);
		this.add(frendsList);
		this.repaint();// 重绘
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

				ClientSocket clientSocket = ClientSocket.getInstance(GUI.this);
				clientSocket.close();
				System.out.println("windows closing..");
				System.exit(0);
			}
		});

	}

	// 刷新好友列表
	public void refreshFriendsUI(Set<String> set) {
		// 有序
		final List<String> friends = new ArrayList<String>(set);
		// 模型
		TableModel tableModel = new AbstractTableModel() {
			private static final long serialVersionUID = 886919054650499901L;

			public int getColumnCount() {
				return 1;
			}

			public int getRowCount() {
				return friends.size();
			}

			public Object getValueAt(int row, int col) {
				return friends.get(row);
			}
		};
		frendsList.setModel(tableModel);
	}

	// 更新聊天信息
	public void appendChatArea(String chatText) {
		// 记录原文
		StringBuilder builder = new StringBuilder();
		System.out.println(chatArea.getText());
		builder.append(chatArea.getText() + "\r\n");

		builder.append(chatText);
		chatArea.setText(builder.toString());
	}

}