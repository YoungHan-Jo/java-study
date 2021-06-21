package java0621p;

public class Car {
	Engine engine = new Engine();
	
	void drive() {
		engine.use();
		System.out.println("부릉부릉~~");
	}
}
