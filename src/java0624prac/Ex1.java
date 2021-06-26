package java0624prac;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

class ObjectTest extends Object {

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
class Puppy {
	private String name;
	private int age;

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Puppy)) {
			return false;
		}

		boolean result = false;
		Puppy puppy = (Puppy) obj;
		if (name.equals(puppy.name) && age == puppy.age) {
			result = true;
		} else {
			result = false;
		}

		return result;
	}

}

public class Ex1 {

	public static void main(String[] args) {

		
		
		
		
		
	} // main

}
