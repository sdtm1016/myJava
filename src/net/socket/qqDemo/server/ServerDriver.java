package net.socket.qqDemo.server;


public class ServerDriver {
	public static void main(String[] args) {
		// 创建一个窗口
		Server server = new Server();
		server.start(12345);
		System.out.println("server start ");
		
	}
}
