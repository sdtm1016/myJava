package thread.IOStream;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class run {

	public static void main(String[] args) {
		try {
			WriteData writeData = new WriteData();
			ReadData readData = new ReadData();

			PipedOutputStream outputStream = new PipedOutputStream();
			PipedInputStream inputStream = new PipedInputStream();

			/**
			 * Causes this piped input stream to be connected to the piped
			 * output stream src. If this object is already connected to some
			 * other piped output stream, an IOException is thrown.
			 */
			inputStream.connect(outputStream);
			/**
			 * If src is an unconnected piped output stream and snk is an
			 * unconnected piped input stream, they may be connected by either
			 * the call: snk.connect(src) or the call: src.connect(snk) The two
			 * calls have the same effect.
			 */
			// outputStream.connect(inputStream);
			
			ThreadRead threadRead = new ThreadRead(readData, inputStream);
			threadRead.start();
			Thread.sleep(2000);

			ThreadWrite threadWrite = new ThreadWrite(writeData, outputStream);
			threadWrite.start();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
