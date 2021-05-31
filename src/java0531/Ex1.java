package java0531;

// tree 클래스 정의
// 클래스는 객체를 정의하는 역할
class Tree { // 클래스는 위에서 아래로 순차적으로 하지 않음. 그냥 나열.
	// 멤버(구성요소)변수 (상태) // 데이터
	String name;
	int age;
	
	
	// 메소드 (기능) // 함수
	void showTree() {
		System.out.print(age + "살 " + name + "나무가 바람에 ");
		if (age < 10) 
			System.out.println("세게 흔들린다.");
		else
			System.out.println("약하게 흔들린다.");			
	}
	
	
}

public class Ex1 { // class - 객체 정의

	public static void main(String[] args) {
		// 객체(object) 지향 언어
		
		// 변수 ( 한개의 기억장소 )
		// -> 배열 ( 같은 자료형의 기억장소 여러개)
		// -> 구조체 (다른 자료형의 기억장소 여러개)
		// -> 클래스 (구조체 + 함수)
		
		// 참조변수 선언
		Tree tree;
		tree = new Tree(); // 객체 만들기. - 객체가 만들어지면 객체를 구성하는 데이터(변수)는 null, 0 으로 초기화됨.
		// new : 객체 생성 연산자
		// tree : 참조변수
		// . : 객체 참조 연산자
		
		tree.name = "버드";
		tree.age = 5;
		tree.showTree();
		
		Tree tree2 = new Tree();
		tree2.name = "소";
		tree2.age = 50;
		tree2.showTree();
	} // main

}
