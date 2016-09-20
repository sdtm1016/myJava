package collection.javaBean;

public class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// 作为测试使用
	@Override
	public int hashCode() {
		// return 1;
		return name == null ? age : name.hashCode() + age;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (obj.getClass() == Person.class) {
			Person s = (Person) obj;
			// 优化版,对Name,Age先从逻辑简单的属性判断的下手
			// 然后根据Name特殊情况
			if (this.age != s.getAge()) {
				return false;
			}
			// 关于name是否需要考虑null的情况
			else {// 如果能进入这里说明age已经相等,只需判断name
				if (this.name == null) {
					return s.getName() == null;
				} else {// 如果进入这里,最多只能是s.getName为null,排除了null==null的情况,不影响==的比较
					return this.name == s.getName();
				}
			}

		}
		return false;
	}
}