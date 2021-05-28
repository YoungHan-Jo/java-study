package java0528;

public class Ex1 {
	// 순차적 진행 아님 // class 안에서만 함수선언 가능. but 다른 함수 안에서 다른 함수 선언 불가
	
	static void showStar(){
		System.out.println("* * * * *");
		System.out.println(" * * * * ");
	}
	
	
	//main 함수
	// 자바는 함수 블럭 안에서 또다른 함수 선언이 불가능함.
	public static void main(String[] args) {
		// 사용자 정의 함수(메소드)
		System.out.println("======프로그램 시작됨 ======");
		showStar();
		showStar();
		showStar();
		System.out.println("======프로그램 종료됨 ======");
	} // main

	
}
