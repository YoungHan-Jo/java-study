package java0622;

public class AccessTest {

	private int a = 10; // 같은 클래스 내
	int b = 20; // 같은 패키지 내 
	protected int c = 30; // 같은패키지 or 다른패키지의 상속받은 자식클래스에서 접근 가능
	public int d = 40; // 모든 패키지 가능
	
	public void showData() {
		System.out.println("AccessTest showDate()");
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);
	}
}
