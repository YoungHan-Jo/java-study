package java0623;

public class Ex5 {

	public static void main(String[] args) {

//		new Animal(); // abstract 클래스 자체로는 객체 생성 불가능.
		// 참조변수로는 사용 가능함.(다형성)
		Animal puppy = new Puppy();
		puppy.eat();
		puppy.speak();

		// 추상메소드는 상속받는 자식클래스에서 모두 구현해야한다.
		// 추상메소드는 몸통이 없음. 다형성을 위해 존재할 뿐.

	} // main

}
