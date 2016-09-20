package net.udp.scBigImage;

public class ClientDriver {

	public static void main(String[] args) {
		ClientUI ui = new ClientUI();
		new ClientReceiveThread(ui).start();
	}
}
