package java0623p;

public class Ex5 {

	public static void main(String[] args) {
		
		
		System.out.println(IRobot.BLUE);
		Animal puppy = new Puppy();
		puppy.speak();
		puppy.eat();
		
		System.out.println("=====================");
		
		IRobot robot = (IRobot) puppy;
		robot.sayHello();
		robot.sayGoodbye();
		robot.speak();
		
		
	
		
	} // main

}
