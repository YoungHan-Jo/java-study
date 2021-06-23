package java0622p;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
class Point2D {
	private int x;
	private int y;
	
	public String getLocation() {
		return x+ ", " + y;
	}
}

@NoArgsConstructor
@AllArgsConstructor
class Point3D extends Point2D {
	private int z;
	


	Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getLocation() {
		return super.getLocation() + ", " + z;
	}
}

public class Ex5 {

	public static void main(String[] args) {
		
		Point2D p1 = new Point3D(10,20,30);
		System.out.println(p1.getLocation());

	} // main

}
