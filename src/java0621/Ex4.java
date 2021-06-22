package java0621;

// *상속의 장점*
// - 클래스 사이의 멤버 중복선언 불필요
// - 필드와 메소드 재사용으로 클래스 간결화
// - 클래스 사이에 계층적 분류 및 관리

// Point2D 클래스
// 멤버변수 정수형 x y
// 메소드 show2D() 출력 "x,y"
class Point2d {
	int x;
	int y;
	
	void show2d() {
		System.out.println(x + ", " + y);
	}
}

// Point3D 클래스 상속받고 z 추가하기


class Point3d extends Point2d {
	int z;
	
	void show3d() {
		System.out.println(x + ", " + y + ", " + z);
	}
}

public class Ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Point3d p3d = new Point3d();
		p3d.show2d();
		p3d.show3d();
		
	} // main

}
