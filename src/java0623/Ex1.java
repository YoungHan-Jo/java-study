package java0623;

class Parent {
	void parentPrn() {
		System.out.println("parentPrn()");
	}
}

class Child extends Parent{
	void childPrn() {
		System.out.println("childPrn()");
	}
}

public class Ex1 {

	public static void main(String[] args) {
		//참조(레퍼런스)형 형변환
		
		Child c = new Child();
		
		c.parentPrn();
		
		
		System.out.println("=======================");
		Parent p = c; // 자동 형변환 c -> p 업 캐스팅 -> 다형성
		p.parentPrn();
		//p.childPrn(); 부모타입 참조변수로 자식멤버 접근 못함. 객체에 존재는 하지만 타입이 Parent 타입이라서 호출은 불가능.
		// 근데 사용하는 이유 ? 다형성. 다양한 자식들을 저장할때 편하게 관리유지를 위해
		
		System.out.println("=========================");
		Parent p2 = new Child(); // 업캐스팅
		p2.parentPrn();
		
		System.out.println("============================");
		Child c2 = (Child)p2; // (참조변수) 강제로 넣어줘야함 수동 형변환 다운캐스팅
		c2.parentPrn();
		c2.childPrn();
		
		
		
		
		
	} // main

}
