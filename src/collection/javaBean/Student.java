package collection.javaBean;

public class Student {
	private String name;
	private int age;
	private char sex;

	// construct
	public Student() {
	}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Student(String name, int age, char sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	// getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	// toString
	@Override
	public String toString() {
		return "Student[" + this.getName() + "," + this.getAge() + ","
				+ this.getSex() + "]";
	}

	// equals
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		// 注意不能使用instanceOf
		// 这里只做name和age的判断
		if (obj.getClass() == Student.class) {
			Student o = (Student) obj;
			// 对Name为null,由判断先后逻辑确定
			if (this.name == null && o.getName() == null) {
				return o.getAge() == this.age;
			}
			if (this.name == null || o.getName() == null) {
				return false;
			}
			// Name均不是null
			else {
				if (this.name.equals(o.getName())) {
					return o.getAge() == this.age;
				}
				return false;
			}
		}
		return false;
	}

	public boolean myEquals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (obj.getClass() == Student.class) {
			Student s = (Student) obj;
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