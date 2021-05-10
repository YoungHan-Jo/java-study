package java0510;

public class Ex2 {

	public static void main(String[] args) {
		// 문자열 결합 
		String name = "Ja" + "va";
		String str = name + 8.0;
		// String형 + double형 = "Java" + "8.0" ="Java8.0"
		// 숫자형이 문자형으로 바뀜
		System.out.println("str = " + str);
		
		System.out.println(7 + 7 + ""); // "14"
		System.out.println("" + 7 + 7); // "77"
		
	}// main

}
