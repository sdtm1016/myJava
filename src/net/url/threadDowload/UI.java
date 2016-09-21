package net.url.threadDowload;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class UI extends JFrame {

	private static final long serialVersionUID = -8538340017289871763L;
	// URL地址
	private JLabel lbUrl;
	private JTextField tfUrl;

	// 本地地址
	private JLabel lbLocal;
	private JTextField tfLocal;

	// 线程数量
	private JLabel lbCount;
	private JTextField tfCount;
	// 按钮
	private JButton btnStart;
	// 暂停
	private JButton btnPause;

	// 进度条
	private JProgressBar bar;
	public boolean isPausing = false;

	public UI() {
		init();
	}

	private void init() {
		this.setBounds(600, 400, 600, 400);
		this.setLayout(null);
		lbUrl = new JLabel("url: ");
		lbUrl.setBounds(0, 0, 100, 50);
		this.add(lbUrl);

		tfUrl = new JTextField("http://localhost:8000/lantern-installer-beta.exe");
		tfUrl.setBounds(120, 0, 400, 50);
		this.add(tfUrl);

		lbLocal = new JLabel("lbLocal :");
		lbLocal.setBounds(0, 60, 100, 50);
		this.add(lbLocal);

		tfLocal = new JTextField("file/lantern-installer-beta.exe");
		tfLocal.setBounds(120, 60, 400, 50);
		this.add(tfLocal);

		lbCount = new JLabel("Count :");
		lbCount.setBounds(0, 120, 100, 50);
		this.add(lbCount);

		tfCount = new JTextField("3");
		tfCount.setBounds(120, 120, 400, 50);
		this.add(tfCount);

		btnStart = new JButton("开始");
		btnStart.setBounds(10, 180, 100, 50);
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String url = tfUrl.getText();
				String local = tfLocal.getText();
				int count = Integer.parseInt(tfCount.getText());
				DowLoaderManager mgr = new DowLoaderManager(url, local, count, UI.this);

				mgr.start();
				bar.setValue(0);
				bar.setVisible(true);
			}
		});
		this.add(btnStart);

		btnPause = new JButton("暂停");
		btnPause.setBounds(120, 180, 100, 50);
		btnPause.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UI.this.isPausing = !UI.this.isPausing;
				btnPause.setText(UI.this.isPausing ? "继续" : "暂停");
			}
		});
		this.add(btnPause);

		// 进度条
		bar = new JProgressBar();
		bar.setBounds(5, 240, 550, 10);
		this.add(bar);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	// synchronized后保证该方法内执行时间尽可能短
	public synchronized void updataProcessBar(int len) {
		int newValue = bar.getValue() + len;
		bar.setValue(newValue);

		if (newValue >= bar.getMaximum()) {
			JDialog dialog = new JDialog();
			dialog.setTitle("下载完成!");
			dialog.setVisible(true);
			dialog.setBounds(400, 300, 200, 100);
			bar.setValue(0);
			bar.setVisible(false);
		}

	}

	public void setProgressbarMax(int totalLength) {
		bar.setMaximum(totalLength);
	}

}
