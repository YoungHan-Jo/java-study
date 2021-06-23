package java0623;

interface Movable{
	public abstract void move(int x, int y);
}

class Fighter implements Movable{
	
	@Override
	public void move(int x, int y) {
		System.out.println(x + "," + y + "로 이동한다.");
	}
}

public class Ex9 {

	public static void main(String[] args) {
		
		Fighter p = new Fighter();
		p.move(3, 6);
		
		System.out.println("========================");
		
		Movable mv = new Fighter();
		mv.move(2, 3);
		
	} // main

}
