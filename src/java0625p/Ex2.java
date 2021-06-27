package java0625p;

public class Ex2 {

	public static void main(String[] args) {
		
		int a = 10;
		int b = 0;
		int result = 0;
		
		String str = null;
		
		try {
			
			result = a/b;
			System.out.println("result = " + result);
			
			System.out.println(str.toUpperCase());
		} catch (ArithmeticException e) {
			
			System.out.println("수학관련 예외발생 :0으로 나눔");
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			System.out.println("예외 발생 여부와 관계업이 실행됨.");
		}
		
		
		
		
		System.out.println("=== 정상종료 ===");
		} // main

}
