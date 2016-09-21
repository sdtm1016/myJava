package net.url.threadDowload2;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
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
	private JProgressBar[] bars;
	public boolean isPausing = false;

	private int completeCount = 0;

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

				addBars(mgr.getInfos());
				mgr.start();
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
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	/**
	 * 动态添加进度条
	 */
	protected void addBars(List<DowloadInfo> infos) {
		//
		bars = new JProgressBar[infos.size()];

		//
		for (int i = 0; i < infos.size(); i++) {
			DowloadInfo info = infos.get(i);
			bars[i] = new JProgressBar();
			bars[i].setName("threads-" + i);
			bars[i].setMaximum(info.getEndPos() - info.getStartPos() + 1);// 单线程最大值
			// 250 所有进度条纵坐标开始量,25每个进度条占空间,20实际进度条的高度
			bars[i].setBounds(10, 250 + i * 25, 400, 20);
			bars[i].setVisible(true);
			this.add(bars[i]);
		}
		this.repaint();
	}

	/**
	 * 单线程进度条更新,这里如果加synchronized,1无意义,2会特别影响下载线程效率
	 * 
	 * @param len
	 *            单线程一定阶段内下载量
	 * @param index
	 *            该线程号
	 */
	public void updataProcessBar(int len, int index) {
		int newValue = bars[index].getValue() + len;
		bars[index].setValue(bars[index].getValue() + len);
		if (newValue >= bars[index].getMaximum()) {
			completeCount++;
			if (completeCount >= bars.length) {
				// 处理完成工作
				processFinish();
			}
		}
	}

	/**
	 * 处理完成
	 */
	private void processFinish() {
		for (Component cmp : bars) {
			this.remove(cmp);
		}
		this.repaint();//重绘
	}

}
