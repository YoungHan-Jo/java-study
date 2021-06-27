package java0625p;

class GoTask implements Runnable {

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

class ComeTask implements Runnable {

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

		
		Runnable goTask = new GoTask();
		ComeTask comeTask = new ComeTask();
		
		Thread threadGo = new Thread(goTask);
		Thread threadCome = new Thread(comeTask);
		
		threadGo.setDaemon(true);
		threadCome.setDaemon(true);
		
		threadGo.start();
		threadCome.start();
		
		System.out.println("==== main() 완전 종료 ====");
	} // main

}
