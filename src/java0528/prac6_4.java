package java0528;

public class prac6_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyMath mm = new MyMath();

		System.out.println(mm.add(3, 5));
		System.out.println(mm.sub(3, 5));
		System.out.println(mm.mul(3, 5));
		System.out.println(mm.div(3, 5));
	}// main

} // class

class MyMath {
	int add(int a, int b) {
		return a + b;
	}

	int sub(int a, int b) {
		return a - b;
	}

	int mul(int a, int b) {
		return a * b;
	}

	float div(int a, int b) {
		return (float) a / b;
	}

}
