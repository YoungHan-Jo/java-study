package java0622;

import lombok.Getter;
import lombok.Setter;

// 기본생성자 x, y , z ->  1,2,3 초기화
// x y z 받아서 초기화 하는 생성자
// getLocation() 메소드 오버라이딩. 이클립스 자동완성 사용 return "x,y,z"

@Getter
@Setter
class Point2DD {
	private int x;
	private int y;

	Point2DD(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public String getLocation() {
		return x + ", " + y;
	}
}

@Getter @Setter
class Point3DD extends Point2DD {
	private int z;

	Point3DD() {
		this(1,2,3); // 매개변수 다 들어간거 활용
	}

	Point3DD(int x, int y, int z) {
		super(x,y); // 부모클래스 매개변수 다 들어간 생성자 활용
		this.z = z;
	}

	@Override
	public String getLocation() {
		return super.getLocation() + ", " + z;
	}

}

public class Ex7 {

	public static void main(String[] args) {

		System.out.println("기본 생성자");
		Point3DD p = new Point3DD();
		System.out.println(p.getLocation());
		
		System.out.println("=============================");
		
		System.out.println("x,y,z 받아서 생성");
		Point3DD p2 = new Point3DD(10, 20, 30);
		System.out.println(p2.getLocation());

	} // main

}
