package math.sort;

//霍纳规则
public class HornerDemo {
	// a0+x*(a1+x(a2+...+x(a(n-1)+x*an)..))
	public void horner() {
		int y = 0;
		int n = 10;
		int a = 2;
		int x = 1;
		for (int i = n; i >= 0; i--) {
			y = a + x * y;
		}
	}
}
