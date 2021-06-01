package java0601;

class TV {
	// 클래스는 객체가 생성되면 기본값으로 초기화됨
	String color; // 기본값 NULL
	boolean power; // 기본값 false
	int channel; // 기본값 0
	
	void power() {
		power = !power;
	}
	void channel1Up() {
		channel++;
	}
	void channel1Down() {
		channel--;
	}
}

public class Ex1 {

	public static void main(String[] args) {
		
		TV t = new TV();
		t.color = "BLACK";
		t.channel = 7;
		t.channel1Up();
		
		System.out.printf("현재 채널은 %d번 입니다.", t.channel);
		
		
		// 객체배열
		String[] strArr = new String[3];
		strArr[0] = "안녕";
		strArr[0] = "hello";
		
		TV[] tvArr = new TV[3];
		tvArr[0] = new TV();
		tvArr[1] = new TV();
		tvArr[2] = new TV();
		
		String[] strArr2 = { "안녕", "Hello","반가워"};
		
		TV[] tvArr2 = {new TV(), new TV(), new TV()};
		
		
		
		
		
		
	}// main

}
