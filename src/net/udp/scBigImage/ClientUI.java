package net.udp.scBigImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

//客户端窗口
public class ClientUI extends JFrame {
	private static final long serialVersionUID = 5603344745491571442L;
	private JLabel label;
	private ImageIcon icon;

	public ClientUI() {
		init();
	}

	/**
	 * Frame初始化
	 */
	private void init() {
		this.setBounds(0, 0, 1400, 800);
		// this.setBounds(0, 0, 1366, 768);
		this.setLayout(null);

		// label
		label = new JLabel();
		label.setBounds(10, 10, 1366, 768);
		label.setLayout(null);
		icon = new ImageIcon("file/image.jpg");
		label.setIcon(icon);
		this.add(label);
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * 刷新图片
	 */
	public void refreshImage(byte[] ungizpData) {

		ImageIcon icon = new ImageIcon(ungizpData);
		label.setIcon(icon);
		System.out.println("flush----------------------------");
	}

}
