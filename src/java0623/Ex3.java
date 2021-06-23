package java0623;
//static변수 (=전역변수)
// 메모리를 아끼기 위해 사용함. 상시 존재하는 변수


class StaticTest {
	
	// 스태틱 초기화 블록 : 클래스가 로딩 되면 static 멤버 초기화를 위해 바로 호출 됨.
	
	final int MIN = 0; // 인스턴스 상수 - > 객체 생성 때마다 값이 계속 들어감 -> 메모리 낭비.
	// 객체의 존재이유 : 객체마다 각기 다른 값들을 저장하기 위해 생성하는것인데 , 같은 값 들어가면 낭비.
	static final int MAX = 500; // 클래식 상수
	
	static int a = 10; // 클래스 변수. 정적 변수. 클래스마다 한개씩 생성. 전역변수.

	
	static {
		// 클래스 로딩 후
		// static 변수 또는 static 메소드 호출을 하기 위해 사용함.
		// static 만 들어올 수 있음.
	}
	//====================================================================== 주석으로 구분 해주면 보기 쉬움
	int b = 20; // 인스턴스 변수. 인스턴스마다 한개씩 생성.
	
	static void staticPrint() {
		System.out.println("a = " + a);
//		System.out.println("b = " + b); // 스태틱 메소드에서는 인스턴스 변수를 사용 불가. 
		// 객체 생성 시기보다 staticPrint 함수의 생성 시기가 더 빠르기 때문에 b가 아직 있는지 없는지 모름
	}
}



public class Ex3 {

	public static void main(String[] args) {
		//static : 객체생성없이 '클래스이름.static멤머이름' 으로 접근 가능.
		System.out.println(StaticTest.a);
		
		StaticTest st = new StaticTest();
		System.out.println(st.a); // 되기는 되는데 옳은 방법은 아님.
		System.out.println(st.b);
		
		System.out.println("=====================");
		StaticTest.a++;
		st.b++;
		StaticTest st2 = new StaticTest();
		System.out.println(StaticTest.a); // 전체가 공유하는 하나뿐인 절대적 변수
		System.out.println(st2.b);
		
		System.out.println("=====================");
		
		// Math math = new Math(); // 기본 Math 객체는 생성 없이 바로사용하도록 static 메소드로 구성됨
		System.out.println("PI = " + Math.PI);
		System.out.println("원의 면적 : " +(5*5*Math.PI));
		System.out.println("-5의 절대값 : " + Math.abs(-5));
		
		
		
		
	} // main

}
