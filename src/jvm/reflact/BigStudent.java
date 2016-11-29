/**
 * 
 */
/**
 * @author Noah
 *
 */
package jvm.reflact;

public class BigStudent extends Student {
	private int degree;

	public BigStudent() {
	}

	public BigStudent(int degree) {
		this.degree = degree;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	private void sayHello(String name) {
		System.out.println(name);
	}

	@Override
	public void setName(String name) {
		super.setName(name);
	}
}