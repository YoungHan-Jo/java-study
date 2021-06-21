package java0621;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @ : 애노테이션(annotation) 주석 - 기능이 있는 주석
// // 그냥주석
@Getter
@Setter
@AllArgsConstructor // 매개변수 전부 가진 생성자
@NoArgsConstructor // 매개변수 없는 생성자

public class Person {
	
	private String name;
	private int age;
	
	public void showPerson() {
		System.out.printf("이름 : %s, 나이 : %d\n", name, age);
	}
}
