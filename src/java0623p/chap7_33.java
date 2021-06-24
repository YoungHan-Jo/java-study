package java0623p;

public class chap7_33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Unit[] UnitArr = new Unit[] {new Marine(), new Tank(), new Dropship()};
		
		for(Unit u : UnitArr) {
			u.move(100, 200);
		}
		
		
		
	} // main

}
