package java0628;

public class Ex6 {

	public static void main(String[] args) {
		
		
		System.out.println(Ex5.b);
		System.out.println(Ex5.Movable.RED);
		
		// static inner class
		Ex5.MyActionListener5 l =  new Ex5.MyActionListener5(); 
		// 클래스 안에 있는 static 을 호출할때는 클래스명.이름
		// Ex5 와 MyActionLIstener5 는  독립된 클래스지만 위치는 저렇게 돼있기때문에.
		
		

		
		
	} // main

}
