package java0623p;


class Shape {
	double area; // 면적

	double calcArea() {
		return area;
	}
}

class Circle extends Shape {
	int radius; // 반지름 초기값 5
	
	Circle() {
		this.radius = 5;
	}
	@Override
	double calcArea() { // 원 면적 리턴
		System.out.print("원의 넓이 : ");
		return radius * radius * 3.14;
	}
}

class Rectangle extends Shape {
	int width;
	int height;
	
	Rectangle() {
		this.width = 10;
		this.height = 10;
	}

	@Override
	double calcArea() {
		System.out.print("사각형의 넓이 : ");
		return width * height;
	}
}

class Triangle extends Shape {
	int width;
	int height;

	Triangle() {
		this.width = 10;
		this.height = 10;
	}
	
	@Override
	double calcArea() {
		System.out.print("삼각형의 넓이 : ");
		return width * height / 2;
	}
}

public class Ex2 {

	public static void main(String[] args) {
		
		Shape[] shapeArr = new Shape[] { new Circle(), new Rectangle(), new Triangle() };

		for (Shape shape : shapeArr) {
			System.out.println(shape.calcArea());
		}
	}

}
