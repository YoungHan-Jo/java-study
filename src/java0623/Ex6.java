package java0623;

//추상클래스 MyShape
// 추상 메소드 void draw()
abstract class MyShape {

	abstract void draw();
}

class MyCircle extends MyShape {

	@Override
	void draw() {
		System.out.println("원을 그린다.");
	}
}

class MyRectangle extends MyShape {

	@Override
	void draw() {
		System.out.println("사각형을 그린다.");
	}
}

class MyTriangle extends MyShape {

	@Override
	void draw() {
		System.out.println("삼각형을 그린다.");
	}
}

public class Ex6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 추상클래스 타입변수로 자식객체를 사용하기 / 업캐스팅 다형성

		MyShape cir = new MyCircle();
		cir.draw();

		MyShape rec = new MyRectangle();
		rec.draw();

		MyShape tri = new MyTriangle();
		tri.draw();
		
		System.out.println("==========================================");
		
		MyShape[] shapeArr = new MyShape[] {new MyCircle(),new MyRectangle(), new MyTriangle()};
		
		for(int i = 0; i < shapeArr.length; ++i)
			shapeArr[i].draw();
		
		System.out.println("================================");
		
		for(MyShape sp : shapeArr) // MyShape sp = new MyCircle() . . . 배열 안에 있는거 하나씩 하는거랑 같은 느낌.
			sp.draw();
		
	} // main

}
