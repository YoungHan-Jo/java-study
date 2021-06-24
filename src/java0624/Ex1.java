package java0624;

import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
 	java.lang 패키지 : 자바의 기본패키지
 	
 	Object 클래스의 메소드 : toString(), equals()
 	
 */

class ObjectTest extends Object {

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
class Puppy {
	private String name;
	private int age;
	
//	@Override
//	public String toString() { // 멤버변수 다 알려주는 오버라이딩 메소드 //lombok으로도 비슷하게 가능.
//		return "Puppy [name=" + name + ", age=" + age + "]";
//	}
	
	
	//오버라이딩으로 Object에 있는 equals() 메소드를 재정의.
	@Override
	public boolean equals(Object obj) { // Object 타입의 자손이면 다 들어올 수 있음
		// instanceof 연산자 : 참조변수가 현재 참조하는 실제 객체의 타입이 Puppy인지 확인 // 다운캐스팅 하기 전에 올바른 객체가 맞는지 확인하는거
		// true/false 리턴
		if(!(obj instanceof Puppy)) {
			return false;
		}
		
		boolean result = false;
		Puppy puppy = (Puppy) obj; // 다운캐스팅 - 수동형변환
		if(this.name.equals(puppy.name) && this.age == puppy.age) { // name은 문자열이라 내용비교, age는 그냥 비교 가능
			result = true;
		}else {
			result = false;
		}
		
		return result;
	}
	
}

public class Ex1 {

	public static void main(String[] args) {
		// Object : java.lang.Object / 최상위 클래스, 모든 클래스는 OBject 상속받음
		// 클래스들의 공통적인 부분을 정의해놓음.
		
		Object ot = new ObjectTest();
		System.out.println(ot.getClass()); // 현 객체의 런타임 클래스를 리턴
		
		//toString()은 객체의 스트링표현을 리턴 / id값 같은거
		System.out.println(ot); // 출력문 안에서는 자동으로 toString() 해줌 컴파일러가
		System.out.println(ot.toString()); // 재정의 오버라이딩 용도
		
		// equals() 메소드 : 현재객체와 매개변수로 받은 객체가 내용이 같은지 비교
		// 재정의 오버라이딩 용도
		int a= 10, b = 10;
		if(a == b) {
			System.out.println("숫자가 서로 같다");
		}else {
			System.out.println("숫자가 서로 다르다");
		}
		System.out.println("============================");
		String str1 = new String("안녕");
		String str2 = new String("안녕");
		
		if(str1 == str2) {
			System.out.println("참조주소가 서로 같다");
		}else {
			System.out.println("참조주소가 서로 다르다");
		}
		
		if(str1.equals(str2)) {
			System.out.println("문자열 내용이 서로 같다");
		}else {
			System.out.println("문자열 내용이 서로 다르다");
		}
		
		System.out.println("===============================");
		
		Puppy p1 = new Puppy("진돗개",5);
		Puppy p2 = new Puppy("진돗개",5);
		
		if(p1.equals(p2)) {
			System.out.println("강아지 두마리 이름과 나이가 같다");
		}else {
			System.out.println("강아지 두마리 이름과 나이가 다르다");
		}
		
		System.out.println(p1);
		System.out.println(p1.toString());
		
		System.out.println("=============================================");
		
		String str3 = "반가워"; // 리터럴은 메모리를 아끼기 위해 특별한 테이블을 사용함. / 원래 있던 리터럴이면 원래 있던 주소로 가서 그대로 가져와서 씀 // 같을때도 있고 다를때도 있음. 쓰면안됨.
		String str4 = "반가워";
		
		if(str3 == str4) {
			System.out.println("참조주소가 서로 같다");
		}else {
			System.out.println("참조주소가 서로 다르다");
		}
		
		if(str3.equals(str4)) { // 문자열 비교
			System.out.println("문자열 내용이 서로 같다");
		}else {
			System.out.println("문자열 내용이 서로 다르다");
		}
		
		
	} // main

}
