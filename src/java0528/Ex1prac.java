package java0528;

public class Ex1prac {

	static void showStar() {
		System.out.println("* * * * *");
		System.out.println(" * * * * ");
	}
	
	static String getHello() {
		String str = "안녕";
		return str;
	}
	
	static int addTwoNum(int a, int b) {
		return a + b;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		showStar();
		showStar();
		
		System.out.println(getHello());
		
		System.out.println(addTwoNum(10,20));
		
		
	}// main

}
