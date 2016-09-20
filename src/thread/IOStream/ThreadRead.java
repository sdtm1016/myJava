package thread.IOStream;

import java.io.PipedInputStream;

public class ThreadRead extends Thread {

	private ReadData read;
	private PipedInputStream in;
	public ThreadRead(ReadData read,PipedInputStream in){
		super();
		this.read = read;
		this.in = in;
	}
	public void run(){
		read.readMethod(in);
	}
}
