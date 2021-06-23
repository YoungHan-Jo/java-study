package java0623;

abstract public class Animal {
	// 추상 메소드를 한 개 이상 가진 클래스 라면 추상클래스가 되어야함.

	public void eat() {
		System.out.println("먹는다");
	}

	abstract public void speak(); // 추상 메소드 선언
}
