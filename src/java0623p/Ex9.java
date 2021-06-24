package java0623p;

interface Movable {
	public abstract void move(int x,int y);
}

class Fighter implements Movable {

	@Override
	public void move(int x, int y) {
	System.out.printf("%d.%d 로 이동한다.\n", x, y);
	}
	
	void attack(String x) {
		System.out.printf("%s를 공격한다.", x);
	}
	
}


public class Ex9 {

	public static void main(String[] args) {
		Movable unit1 = new Fighter();
		unit1.move(100, 200);
		
		Fighter unit2 = (Fighter) unit1;
		unit2.move(200,100);
		unit2.attack("탱크");
		

	} // main

}
