package java0601p;

public class Point {
	
	int x;
	int y;
	
	Point(){
		System.out.println("Hello World");
		x = y = 2;
	}
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
	void showPoint(){
		System.out.println(x + ", " + y);
	}


	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}
