package java0621;

// 객체지향 언어에서 객체간의 관계 두가지

// 1) 포함관계 (~를 가지고 있다/ A는 B를 가지고 있다)
// 나는 핸드폰을 가지고(사용하고) 있다.
// 자동차가 엔진을 가지고(사용하고) 있다.

class Car {
	private Engine engine = new Engine();
	
	public void drive() {
		engine.use();
		System.out.println("부릉부릉~~");
	}
}

class Engine {
	public void use() {
		System.out.println("엔진을 사용합니다");
	}
}

// 2) 상속관계 (~이다/ A는 B이다)
// 중학생은 학생이다. <-> 학생은 중학생이다 x
// 강아지는 동물이다. <-> 동물은 강아지다 x

class Parent {
	
	void showParent() {
		System.out.println("Parent의 showParent() 호출됨");
	}
}

class Child extends Parent{
	void showChild() {
		System.out.println("Child의 showChild() 호출됨");
	}
}

class Grandchild extends Child{
	void showGrandchild() {
		System.out.println("Grandchild의 showGrandchild() 호출됨");
	}
}


public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car car1 = new Car();
		car1.drive();
		
		Child child = new Child();
		child.showChild();
		child.showParent();
		
		System.out.println("=======================");
		
		Grandchild gc = new Grandchild();
		gc.showGrandchild();
		gc.showChild();
		gc.showParent();
		
		
		
	}// main
}
