package java0625p;

class GoThread extends Thread {
	
	
	
	
	@Override
	public void run() {
		methodGo();
	}

	void methodGo() {
		while(true) {
			System.out.println("go");
		}
	}
	
}

class ComeThread extends Thread{
	
	
	
	
	@Override
	public void run() {
		methodCome();
	}

	void methodCome() {
		while(true) {
			System.out.println("come");
		}
	}
}


public class Ex5 {

	public static void main(String[] args) {
		
		
		GoThread goThread = new GoThread();
		ComeThread comeThread = new ComeThread();
		
		
		goThread.setDaemon(true);
		comeThread.setDaemon(true);
		
		
		goThread.start();
		comeThread.start();
		
		
		
		System.out.println("==== main() 정상 종료 ====");
	} //main

}
