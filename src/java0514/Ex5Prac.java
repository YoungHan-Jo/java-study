package java0514;

public class Ex5Prac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = (int) (Math.random() * 3) + 1;
		System.out.println("1~3 중 임의의 정수 : " + num);

		System.out.println("=====================");
		num = (int) (Math.random() * 11) + 10;
		System.out.println("10~20 중 임의의 정수 : " + num);

		System.out.println("=====================");
		num = (int) (Math.random() * 100) + 1;
		System.out.println("1~100 중 임의의 정수 : " + num);
	} // main

}
