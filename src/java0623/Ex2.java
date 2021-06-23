package java0623;

import java.util.ArrayList;

class Shape {
	protected double area; // 면적

	double calcArea() {

		return area;
	}
}

class Circle extends Shape {
	private int radius; // 반지름 초기값 5
	final double PI = 3.14; // 변하지않는 값 or 확실한 값 , 단순한 값은 바로 값 넣어주기.

	Circle() {
		this(5);
	}

	Circle(int radius) {
		super();
		this.radius = radius;
	}

	@Override
	double calcArea() { // 원 면적 리턴
		System.out.print("원의 넓이 : ");
		return radius * radius * PI;
	}
}

class Rectangle extends Shape {
	private int width;
	private int height;

	Rectangle() {
		this(10, 10);
	}

	Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	@Override
	double calcArea() {
		System.out.print("사각형의 넓이 : ");
		return width * height;
	}
}

class Triangle extends Shape {
	private int width;
	private int height;

	Triangle() {
		this(10, 10);
	}

	Triangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	@Override
	double calcArea() {
		System.out.print("삼각형의 넓이 : ");
		super.area = width * height / 2.0; // 이런방식으로 해도 됨. 정확하게 쓰자면 'super'를 붙여야함. (this/생략도 사용가능)
		return area;
	}
}

public class Ex2 {

	public static void main(String[] args) {

		Shape[] shapeArr = new Shape[] { new Circle(), new Rectangle(), new Triangle() };

		for (Shape shape : shapeArr) {
			System.out.println(shape.calcArea());
		}

		System.out.println("========================");

		Shape s;
		s = new Circle(); // 업캐스팅 : 메소드 오버라이딩. 부모변수로 접근가능.
		System.out.println(s.calcArea());
		
		s = new Rectangle();
		System.out.println(s.calcArea());
		
		s = new Triangle();
		System.out.println(s.calcArea());
		
		System.out.println("===========================");
		
		Triangle tri = (Triangle) s; // 다운캐스팅 (형변환)

		// ArrayList : 배열 리스트 (가변크기 배열) , 다른 타입끼리도 들어갈 수 있음. (오브젝트의 형태로 저장함)
		ArrayList<Object> list = new ArrayList<Object>();
		list.add("강아지");
		list.add(3);
		list.add(true);
		list.add(2.4);
		
		String str = (String) list.get(0); // 다운캐스팅 (명시적 형변환)
		
		for(int i = 0 ; i < list.size(); i ++)
			System.out.println(list.get(i) + "\t " + list.get(i).getClass().getName());
		
		
		
		
		
	} // main

}
