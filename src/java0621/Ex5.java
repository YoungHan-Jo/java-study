package java0621;


// 생성자 오버로딩 허용 규칙
// - 매개변수 개수가 다를때
// - 매개변수 개수가 같으면 자료형이 다를때

// 메서드 오버로딩 허용 규칙
// - 같은 클래스 내에서 동일한 이름의 메소드명
// - 매개변수 개수 다르거나 자료형 다를때
// - 메서드 반값타입은 규칙에 포함되지않음!

class MethodTest {
	void printData(int num) {
		System.out.println(num);
	}
	
	void printData(double num) {
		System.out.println(num);
	}
	
	void printData(boolean b) {
		System.out.println(b);
	}
	
	void printData(String str) {
		System.out.println(str);
	}
}

public class Ex5 {

	public static void main(String[] args) {
		MethodTest mt = new MethodTest();
		
		mt.printData(true);
		mt.printData('한');
		mt.printData(100);
		mt.printData(3.14);
		mt.printData("안녕하세요");
		
		
		
	} // main
}
