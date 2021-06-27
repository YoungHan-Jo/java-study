package java0625;



class GoTask implements Runnable { // 원래 존재하는 인터페이스 Runnable // 쓰레드를 갖고 있지는 않음.

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

class ComeTask implements Runnable { // 원래 존재하는 인터페이스 Runnable , 

	@Override
	public void run() {
		methodCome();
	}
	
	void methodCome() {
		while (true) {
			System.out.println("come");
		}
	}
}


public class Ex6 {

	public static void main(String[] args) {
		// 멀티쓰레드 
		// 2.Runnable 인터페이스 구현 // Thread 클래스를 상속받으면 노출됨.
		//  Thread 객체 생성해서 Runnable 구현객체를 Thread에 전달. // Thread - 일꾼, Runnable - 일거리
		// .start() 메소드 호출해서 실행을 주문함.(JVM에게 주문)
		
		
		Runnable goTask = new GoTask();
		ComeTask comeTask = new ComeTask(); // 참조변수는 두개다 가능. 동적바인딩
		
		Thread thread1 = new Thread(goTask);
		Thread thread2 = new Thread(comeTask);
		
		//한줄로도 가능
		// Thread thread1 = new Thread(new GoTask());
		
		thread1.start();
		thread2.start();
		
		
		
	} // main

}
