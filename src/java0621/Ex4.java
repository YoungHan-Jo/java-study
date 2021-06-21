package java0621;

// *상속의 장점*
// - 클래스 사이의 멤버 중복선언 불필요
// - 필드와 메소드 재사용으로 클래스 간결화
// - 클래스 사이에 계층적 분류 및 관리

// Point2D 클래스
// 멤버변수 정수형 x y
// 메소드 show2D() 출력 "x,y"
class Point2D {
	int x;
	int y;

	void show2D() {
		System.out.printf("%d, %d\n", x, y);
	}
}

// Point3D 클래스 상속받고 z 추가하기

class Point3D extends Point2D {
	int z;

	void show3D() {
		System.out.printf("%d, %d, %d\n", x, y, z);
	}
}

public class Ex4 {

	public void main(String[] args) {
		
	Point3D p = new Point3D();
	p.x = 10;
	p.y = 20;
	p.z = 30;
	p.show3D();
	
	
	

	} // main

}
