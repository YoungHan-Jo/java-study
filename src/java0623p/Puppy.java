package java0623p;

public class Puppy extends Animal implements IRobot{

	@Override
	public void speak() {
		System.out.println("멍멍~~!!");
		
	}

	@Override
	public void sayHello() {
		System.out.println("멍멍 ~ 안녕하세요");
		
	}

	@Override
	public void sayGoodbye() {
		System.out.println("멍멍 ~ 안녕히가세요");
		
	}

	
}
