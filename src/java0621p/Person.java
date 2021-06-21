package java0621p;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Person {
	private String name;
	private int age;
	
	public void showPerson() {
		System.out.println("이름 : " + name + "\t 나이 : " + age);
	}
	
}
