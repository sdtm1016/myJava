package introspector;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import org.junit.Test;

public class TestApp {

	@Test
	public void testProperty() {
		try {
			// 判断属性描述符是否相等
			PropertyDescriptor[] catPds = Introspector.getBeanInfo(Cat.class).getPropertyDescriptors();
			PropertyDescriptor[] dogPds = Introspector.getBeanInfo(Dog.class).getPropertyDescriptors();

			System.out.println(catPds[0].equals(dogPds));

		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试不同对象的属性复制
	 */
	@Test
	public void test() {
		Cat cat = new Cat();
		cat.setName("cafe");
		cat.setAge(2);
		cat.setBlood(10);
		cat.setColor("yellow");
		Dog dog = new Dog();
		BeanUtil.copyProperties(cat, dog);
		System.out.println(dog);
	}
}
