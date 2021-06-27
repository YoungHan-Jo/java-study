package java0625p;

public class Ex1 {

	public static void main(String[] args) {
		
		int a = 10;
		int b = 0;
		int result = 0;
		
		try {
			
			result = a/b;
			
			System.out.println("result : " + result);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
	} // main

}
