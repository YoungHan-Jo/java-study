package java0622;

class Parent {

	void showParent() {
		System.out.println("Parent showParent()");
	}
}

class Child extends Parent {
	
	// 메소드 오버라이딩(overriding) : 부모의 메소드를 재 정의 
	// 부모메소드를 기반으로 내껄로 다시 만들어서 바꿔서 쓰겠다
	//@Override //애노테이션을 줘야함 - 오타 방지
	
	@Override
	void showParent() {
		System.out.println("Child showParent()");
	}
	
	void printMessage() {
		super.showParent(); // super <= 조상 클래스 참조변수.
		this.showParent();
	}
	
	void showChild() {
		System.out.println("Child showChild()");
	}

}

public class Ex4 {

	public static void main(String[] args) {

		Child c = new Child();
		c.showChild();
		c.showParent(); // 오버라이드한 메소드가 호출됨.
		
		
		// 부모쪽 메소드는 외부에서 호출 할 수 없음.
		System.out.println("=======================");
		
		c.printMessage();
		
		

	} // main

}
