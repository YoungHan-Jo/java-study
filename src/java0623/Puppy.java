package java0623;

// 강아지 클래스는 Animal 클래스를 상속, IRobot 인터페이스를 구현함
// 일종의 다중상속 효과를 가짐 - > 다형성의 범위가 확장되는 효과.
class Puppy extends Animal implements IRobot {

	@Override
	public void speak() {
		System.out.println("멍멍");
		
	}// Animal 추상클래스를 상속 받음,
		// 추상메소드를 상속 받기 때문에 추상클래스가 되던지 or 오버라이딩 해줘야함!
	@Override
	public void sayHello() {
		System.out.println("멍멍 안녕하세요");
	}
	@Override
	public void sayGoodbye() {
		System.out.println("멍멍 안녕히 가세요");
	}
}
