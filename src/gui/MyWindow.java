package gui;

import java.awt.Component;
import java.awt.FileDialog;
import java.awt.Scrollbar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import io.byteStream.FIleOutputStreamDemo;

public class MyWindow extends JFrame {

	private static final long serialVersionUID = -6780635712379403885L;
	// 文本域
	private JTextArea textArea;
	// 按钮
	private JButton saveButton;
	private JButton openButton;
	private JButton closeButton;
	// 滚动条
	private JScrollPane scrollPane;

	public MyWindow() {
		initWindow();
	}

	public void initWindow() {
		// 设置可见性
		this.setVisible(true);
		// 设置大小(单位:像素)
		this.setSize(600, 400);
		// 显示坐标位置(屏幕:1980*1200)
		this.setLocation(700, 400);
		// 不设置管理器
		this.setLayout(null);

		// 创建文本域
		textArea = new JTextArea();
		// textArea.setBounds(0, 20, 580, 260);
		// this.add(textArea);

		// 滚动面板滚动的是文本域
		// 如果添加scrollPane
		// 原来的textArea只需直接加到这里,且其边界设置将会无效
		scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(0, 20, 585, 260);
		this.add(scrollPane);

		// 添加一个打开按钮
		openButton = new JButton("打开");
		openButton.setBounds(100, 300, 100, 50);
		MyMouseAdapt mouseAdapt = new MyMouseAdapt();
		openButton.addMouseListener(mouseAdapt);
		this.add(openButton);

		saveButton = new JButton("保存");
		// button位置,相对于容器frame的位置
		saveButton.setBounds(250, 300, 100, 50);
		saveButton.addMouseListener(mouseAdapt);
		this.add(saveButton);

		// 添加一个关闭按钮
		closeButton = new JButton("关闭");
		closeButton.setBounds(400, 300, 100, 50);
		closeButton.addMouseListener(mouseAdapt);
		this.add(closeButton);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("windows closing..");
				System.exit(0);
			}
		});

	}

	class MyMouseAdapt extends MouseAdapter {
		// 鼠标点击事件
		@Override
		public void mouseClicked(MouseEvent e) {
			Component comp = e.getComponent();
			if (comp == openButton) {
				System.out.println("打开");
				// 打开一个对话框
				FileDialog fd = new FileDialog(MyWindow.this);
				fd.setVisible(true);
				File file = new File(fd.getDirectory(), fd.getFile());
				if (file != null) {
					BufferedReader br = null;
					String line = null;
					String old = null;
					try {
						// br = new BufferedReader(new FileReader(file));
						br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));// 视文件类型而定

						while ((line = br.readLine()) != null) {
							old = textArea.getText();
							old = old == null ? "" : old;
							textArea.setText(old + "\r\n" + line);
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					} finally {
						try {
							if (br != null)
								br.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}

				}
			}
			if (comp == saveButton) {
				System.out.println("保存");
				String cont = textArea.getText();
				FileOutputStream fos = null;
				try {
					fos = new FileOutputStream("file/fos.txt");
					fos.write(cont.getBytes("utf-8"));
					fos.close();
					textArea.setText("");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (comp == closeButton)

			{
				System.out.println("关闭");
			}
		}
	}
}