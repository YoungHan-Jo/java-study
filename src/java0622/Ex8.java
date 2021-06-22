package java0622;

// 다형성/ 형변환

class Animal {

	void eat() {
		System.out.println("먹는다");
	}

	void speak() {
		System.out.println("소리내기");
	}
}

class Puppy extends Animal {

	@Override
	void speak() {
		System.out.println("멍멍!!");
	}

	void helpPerson() {
		System.out.println("주인 도와주기");
	}
}

class Cat extends Animal{

	@Override
	void speak() {
		System.out.println("야옹");
	}
}

public class Ex8 {

	public static void main(String[] args) {

		// 자료형 형변환 (기본자료형 - 숫자형끼리만 가능)
		// 형변환은 서로 호환되는 자료형끼리만 가능하다.

		double d = 3; // 자동형변환

		int a = (int) 3.14; // 수동 형변환

		Puppy puppy = new Puppy();
		puppy.eat();
		puppy.speak();
		System.out.println("=====================");
		
		// 자료형 형변환. 참조자료형 - 같은 계열타입(상속관계)끼리만 가능
		// 형변환은 서로 호환되는 자료형(상속관계)끼리만 가능하다.
		
		Animal ani = new Puppy(); // 부모타입(넓은범위 ex 실수) = 자식타입(좁은 범위 ex 정수);
		ani.speak();
		
		ani = new Cat();
		ani.speak();
		//ani.helpPerson(); // 오버라이딩 일때만 가능함. 참조변수 타입이 Animal 이기 때문에 helpPerson()은 없는거라서 쓸 수 없음.
		
		// 정적 바인딩 : 컴파일 시간에 메소드 호출 결정(참조변수 타입기준)
		// 동적 바인딩: 실행 시간에 JVM이 메소드 호출 결정(객체 기준)

		// 자식 타입 객체를 부모 타입 참조변수로 사용하는 상황에서는
		// 정적 바인딩, 동적 바인딩 모두 발생함.

	} // main

}
