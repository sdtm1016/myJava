package thread.base.syc;

public class SyncTest {
	public void syncMethod1(SyncDomain domain) {
		synchronized (domain) {
			System.out.println(domain.getStr());
		}
	}

	public static void main(String[] args) {
		final SyncTest test = new SyncTest();
		new Thread() {
			@Override
			public void run() {
				SyncDomain domain = new SyncDomain();
				domain.setStr("t1");
				test.syncMethod1(domain);
			}
		}.start();

		new Thread() {
			@Override
			public void run() {
				SyncDomain domain = new SyncDomain();
				domain.setStr("t2");
				test.syncMethod1(domain);
			}
		}.start();
	}

	private static class SyncDomain {
		private String str;

		public String getStr() {
			return str;
		}

		public void setStr(String str) {
			this.str = str;
		}
	}
}
