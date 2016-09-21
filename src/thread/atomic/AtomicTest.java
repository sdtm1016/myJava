/**
 * 
 */
/**
 * @author Noah
 *
 */
package thread.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicTest {
	private int x, y;

	private enum State {
		NEW, INITIALIZING, INITIALIZED
	};

	private final AtomicReference<State> init = new AtomicReference<State>(State.NEW);

	public AtomicTest() {
	}

	public AtomicTest(int x, int y) {
		initialize(x, y);
	}

	private void initialize(int x, int y) {
		if (!init.compareAndSet(State.NEW, State.INITIALIZING)) {
			throw new IllegalStateException("initialize is error");
		}
		this.x = x;
		this.y = y;
		init.set(State.INITIALIZED);
	}

	public int getX() {
		checkInit();
		return x;
	}

	public int getY() {
		checkInit();
		return y;
	}

	private void checkInit() {
		if (init.get() == State.INITIALIZED) {
			throw new IllegalStateException("uninitialized");
		}
	}

}