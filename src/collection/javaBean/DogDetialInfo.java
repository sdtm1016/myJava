package collection.javaBean;

public class DogDetialInfo {
	Dog d;

	public DogDetialInfo(Dog d) {
		this.d = d;
	}

	@Override
	public String toString() {
		return d.getCategory() + "'s detail information";
	}
}
