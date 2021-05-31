package java0528;

public class Ex1 { //객체로 사용됨
	// 순차적 진행 아님 // class 안에서만 함수선언 가능. but 다른 함수 안에서 다른 함수 선언 불가
	
	// 매개변수 업고, 반환값도 업는 함수
	static void showStar(){
		System.out.println("* * * * *");
		System.out.println(" * * * * ");
	}
	
	// 매개변수 업고, 반환값도 업는 함수
	static void multipleTen(int num) {
		System.out.println("받은 숫자의 열배는 " + num*10);
		return; // 반환값이 없으면 생략 가능
	}
	
	// 매개변수 업고, 반환값은 있는 함수
	static String getHello() {
		String str = "안녕";
		return str;
		// return "안녕";
	}
	
	// 매개변수 있고, 반환값도 있는 함수
	static int addTwoNumber(int a, int b) {
		int c = a + b;
		return c;
	}
	
	
	//main 함수
	// 자바는 함수 블럭 안에서 또다른 함수 선언이 불가능함.
	public static void main(String[] args) {
		// 사용자 정의 함수(메소드)
		System.out.println("======프로그램 시작됨 ======");
		showStar();
		showStar();
		showStar();
		multipleTen(20);
		multipleTen(5);
		
		String str = getHello();
		System.out.println("main함수에서 출력 : " + str);
		
	
		System.out.println(addTwoNumber(10,20));
		
		System.out.println("======프로그램 종료됨 ======");
		
		
		
		
		
	} // main

	
}
