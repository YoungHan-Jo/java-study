package java0625p;

public class Ex7p {

	public static void main(String[] args) {
		
		Runnable goTask = new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					System.out.println("go Task");
				}
			}
		};
		
		Thread th1 = new Thread(goTask);
		System.out.println(th1.getName());
		th1.setName("GoThread");
		th1.setPriority(Thread.MAX_PRIORITY);
		System.out.println(th1.getName());
		System.out.println("==========================");
		
		Thread th2 = new Thread(new Runnable() {
			
			
			
			
			@Override
			public void run() {
				
				Thread currTh = Thread.currentThread();
				currTh.setPriority(Thread.MIN_PRIORITY);
				
				while(true) {
					System.out.println("come Task");
				}
			}
		});
		
		System.out.println(th2.getName());
		th2.setName("ComeTread");
		System.out.println(th2.getName());
		
		System.out.println("================================");
		
		Thread th3 = new Thread(() -> {
			
			while(true) {
				System.out.println("bye Task");
			}
			
		});
		
		System.out.println(th3.getName());
		th3.setName("ByeThread");
		System.out.println(th3.getName());
		
		System.out.println("=================================");
		
		th1.start();
		th2.start();
		th3.start();
		
		
		
		

	} // main

}
