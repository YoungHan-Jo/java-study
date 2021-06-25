package java0625;

import java.io.IOException;

class ExceptionTest {
	
	void methodA() throws ClassNotFoundException, IOException {
		System.out.println("=== methodA() 호출됨 ===");
		
		methodB();
		
		System.out.println("=== methodA() 정상종료 ===");
	}
	
	void methodB() throws ClassNotFoundException, IOException { // throws에 s 붙는 이유 예외처리할게 여러 종류 일 수 있음
		System.out.println("=== methodB() 호출됨 ===");
		
		methodC();
		
		System.out.println("=== methodB() 정상종료 ===");
	}
	
	void methodC() throws ClassNotFoundException { // 나를 호출한 곳 던져서 떠넘기기 // 나를 사용하는 곳에서 알아서 처리해라
		System.out.println("=== methodC() 호출됨 ===");
		// 예외 떠넘기는 예외처리 방법 : throws 키워드로 예외를 자신을 호출한 쪽으로 되던진다.
		
		Class.forName("java.lang.String2"); // 던지면 아래 문장들은 실행 하지 않고 바로 던진다
		
		System.out.println("=== methodC() 정상종료 ===");
	}
}


public class Ex3 {

	public static void main(String[] args) {
		// 예외 떠넘기는 예외처리 방법
		System.out.println("=== main() 호출됨 ===");
		
		
		ExceptionTest et =new ExceptionTest();
		try {
			et.methodA();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		System.out.println("=== main() 정상종료 ===");
	} // main

}
