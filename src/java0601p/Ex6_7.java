package java0601p;


class Mymath {
	static int sum(int a, int b) {
		return a + b;
	}
}

class Card{
	static int width = 100;
	static int height = 250;
}

class Data{int x;}

public class Ex6_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Data d = new Data();
		d.x = 10;
		System.out.println("main() : x = " + d.x);
		
		change(d);
		
		System.out.println("After change(d)");
		System.out.println("main() : x = " + d.x);
		
		System.out.println("==========================");
		
		System.out.printf("카드 가르 길이 : %d\n", Card.width);
		System.out.printf("카드 세로 길이 : %d\n", Card.height);
		
		System.out.println("==============================");
		
		System.out.printf("%d + %d = %d\n", 3, 5, Mymath.sum(3, 5));
		
	}//main
	
	static void change(Data d) {
		d.x = 1000;
		System.out.println("change() : x = " + d.x);
	}

}
