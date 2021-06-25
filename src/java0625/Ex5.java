package java0625;

class GoThread extends Thread {

	@Override
	public void run() {
		methodGo();
	}
	
	void methodGo() {
		while (true) {
			System.out.println("go");
		}
	}
	
}

class ComeThread extends Thread {
	
	
	
	@Override
	public void run() {
		methodCome();
	}

	void methodCome () {
		while(true) {
			System.out.println("come");
		}
	}
}


public class Ex5 {

	public static void main(String[] args) {
		// 멀티쓰레드 구현 방법
		// 1. Thread 클래스 상속
		//		run() 시작점 메소드를 오버라이딩
		//		.start()를 사용해 쓰레드 시작을 JVM에게 주문함. // 스케쥴링
		
		GoThread goThread = new GoThread();
		ComeThread comeThread = new ComeThread();
		
		//기본적으로 사용자가 생성한 쓰레드는 주 쓰레드.
		// 주 쓰레드는 스택에 실행할 메서드가 존재하면 종료되지 않음. 
		
		// 데몬(보조)쓰레드 설정 : 주 쓰레드가 종료되면 함께 종료되는 쓰레드.백그라운드 작업
		goThread.setDaemon(true);
		comeThread.setDaemon(true);
		
		goThread.start();
		comeThread.start(); // 실제로는 완전한 병렬인데, 지금은 콘솔출력이라서 왓다갓다하는걸로 보임.

		
		System.out.println("=== main() 정상 종료 ===");
	} // main

}
