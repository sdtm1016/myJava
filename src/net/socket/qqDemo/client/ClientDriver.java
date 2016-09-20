package net.socket.qqDemo.client;

public class ClientDriver {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		GUI ui = new GUI();
		ClientSocket clientSocket = ClientSocket.getInstance(ui);
	}
}
