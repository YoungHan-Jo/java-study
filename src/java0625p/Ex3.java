package java0625p;

class ExceptionTest {

	void methodA() throws ClassNotFoundException {
		System.out.println("=== methodA()호출됨===");

		methodB();

		System.out.println("=== methodA() 정상종료===");
	}

	void methodB() throws ClassNotFoundException {
		System.out.println("=== methodB()호출됨===");

		methodC();

		System.out.println("=== methodB() 정상종료===");
	}

	void methodC() throws ClassNotFoundException {
		System.out.println("=== methodC()호출됨===");

		Class.forName("java.lang.String2");

		System.out.println("=== methodC() 정상종료===");
	}

}

public class Ex3 {

	public static void main(String[] args) {

		ExceptionTest et = new ExceptionTest();

		try {
			et.methodA();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// main

}
