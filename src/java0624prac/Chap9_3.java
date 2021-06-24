package java0624prac;

class Person {
	long id;

	Person(long id) {
		super();
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Person))
			return false;

		boolean result = false;
		Person person = (Person) obj;
		if (this.id == person.id)
			result = true;
		else
			result = false;

		return result;
	}

}

public class Chap9_3 {

	public static void main(String[] args) {
		
		Person p1 = new Person(13243546);
		Person p2 = new Person(13242523);
		Person p3 = new Person(13243546);
		
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));
		
		
	}// main

}
