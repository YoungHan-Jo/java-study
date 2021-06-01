package java0601;

public class Ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p = new Point();
		System.out.println(p.x);
		System.out.println(p.y);
		p.showPoint();
		
		p.x = 10; // 외부에서 대입
		p.y = 20;
		p.showPoint();
		
		p.setX(100); // 내부에서 값 변경
		p.setY(200);
		p.showPoint();
		System.out.println("=====================");
		
		Point p2 = new Point(300);
		p2.showPoint();
		
		Point p3 = new Point(300,400);
		p3.showPoint();
	}

}
