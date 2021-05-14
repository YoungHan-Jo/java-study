package java0514;

public class Ex5 {

	public static void main(String[] args) {
		// 임의의 정수 만들기
		// 0.0 <= Math.random() <1.0

		int num = (int) (Math.random() * 3) + 1;
		System.out.println("1~3 중 임의의 정수 : " + num);

		System.out.println("=====================");
		// 10~ 20사이 임의의정수
		num = (int) (Math.random() * 11) + 10;
		System.out.println("10~20 중 임의의 정수 : " + num);

		System.out.println("=====================");
		// 1~100 사이의 임의의정수
		num = (int) (Math.random() * 100) + 1;
		System.out.println("1~100 중 임의의 정수 : " + num);

	} // main

}
