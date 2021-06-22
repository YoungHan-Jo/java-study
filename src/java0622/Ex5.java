package java0622;
// 메소드 오버라이딩 활용
/*
   메소드 오버라이딩 규칙
   - 메소드 선언부(시그니처 signature)가 부모와 일치해야한다
   - 접근 제어자의 범위는 조상 보다 넓게 해야함
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Point2D {
	private int x;
	private int y;

	public String getLocation() {
		return x + ", " + y;
	}
}

@Getter
@Setter
class Point3D extends Point2D {
	private int z;

	public String getLocation() {
		return super.getLocation() + ", " + z;
		//return getX() + ", " + getY() + ", " + z;
	}
}

public class Ex5 {

	public static void main(String[] args) {

		Point3D p = new Point3D();
		p.setX(10);
		p.setY(20);
		p.setZ(30);
		System.out.println(p.getLocation());

	} // main

}
