package java0623;

public class Ex7 {

	public static void main(String[] args) {
		// 다형성은 상속을 전제로 함.
		// 자바는 다중상속을 허용하지 않으며, 단일상속만 허용함.
		Animal animal = new Puppy();
		animal.eat();
		animal.speak();
		
		System.out.println("=========================");
		Puppy puppy = (Puppy) animal;
		
		System.out.println(IRobot.RED);
		System.out.println(IRobot.BLUE);
		
		IRobot iRobot = puppy;
		iRobot.sayHello();
		iRobot.sayGoodbye();
		
	} // main
}
