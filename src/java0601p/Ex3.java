package java0601p;

public class Ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p = new Point();
		System.out.println("=================");
		System.out.println(p.x);
		System.out.println(p.y);
		p.showPoint();
		System.out.println("====================");
		
		Point p2 = new Point(100,200);
		p2.showPoint();
		p2.setX(200);
		p2.setY(300);
		System.out.printf("%d , %d", p2.getX(),p2.getY());
		
		
		
		
	} //main

}
