package java0625;

public class Ex2 {

	public static void main(String[] args) {
		// 예외처리 :  try-catch-finally 방법
		// 예외를 직접 처리하는 방법

		int a = 10;
		int b = 5;
		int result = 0;
		
		String str = null;

		try {
			// 예외가 발생할 수 있는 구문
			result = a / b;
			System.out.println("result = " + result);
			
			System.out.println(str.toUpperCase());
			
		} catch (ArithmeticException e) {
			// 예외 처리 구문이 온다.
			System.out.println("수학관련 예외발생: 0 으로 나눔");
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			// 예외 처리 구문 추가
			
			System.out.println(e.getMessage());
			e.printStackTrace(); // 에러 문장 콘솔창에 그대로 출력
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 무조건 실행됨
			System.out.println("예외 발생 여부와 상관없이 정리 작업");
		}
		
				
		
		
		System.out.println("==== 정상종료 ====");
	} // main

}
