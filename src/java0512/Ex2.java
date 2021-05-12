package java0512;

public class Ex2 {

	public static void main(String[] args) {
		// 문자열 간의 비교는 == 가 아닌 equals 메소드로 비교해야 함!

		String str1 = "abc";
		String str2 = new String("abc");
		// 참조변수는 객체의 주소를 저장하는 용도이기 때문에
		// 비교연산자를 사용해서 비교하면 주소값 비교가 됨
		// 그러므로 내용비교를 위해서는 equals() 메소드를 사용해야함

		// 주소값 비교하기
		System.out.println(str1 == str2);

		// 내용비교하기
		// 객체 참조 연산자 (.)
		System.out.println(str1.equals(str2));
		// A.equals(B) A를 B와 비교하기 (내용물)
		System.out.println(str2.equals(str1));

		System.out.println(str1.equals("abc"));
		System.out.println("abc".equals(str2));

		System.out.println(str1.equalsIgnoreCase("ABC"));
		// case(대소문자) ignore 해서 비교

		System.out.println("=====================");

		// 특수문자 출력하려면 이스케이프 문자 \ 를 먼저 쓰고 사용함
		// \" \'
		System.out.println("\"안녕~!\"");

		System.out.println("=======================");

		// 논리 연산자
		int x = 15;
		// x 는 10보다 크고, 20보다 작다.
		System.out.println(x > 10 && x < 20); // true
		// true && true -->> true

		x = 100;
		System.out.println(x > 10 || x < 20); // true

		// i는 2의 배수 또는 3의 배수이다.
		int i = 9;
		System.out.println(i + "는 2의 배수 또는 3의 배수이지만 6의 배수는 아니다." + ((i % 2 == 0 || i % 3 == 0) && i % 6 != 0));

		boolean bVal = (i % 2 == 0 || i % 3 == 0) && i % 6 != 0;

	} // main

}
