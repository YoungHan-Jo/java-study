package java0625p;

public class Ex7 {

	public static void main(String[] args) {

		Runnable goTask = new Runnable() {

			@Override
			public void run() {
				while (true) {
					System.out.println("goTask");

					try {
						Thread.sleep(200);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} // while

			}
		};

		Thread th1 = new Thread(goTask);
		System.out.println(th1.getName());
		th1.setName("goThread");
		th1.setPriority(Thread.MAX_PRIORITY);
		System.out.println(th1.getName());

		System.out.println("==============================");

		Thread th2 = new Thread(new Runnable() {

			@Override
			public void run() {

				Thread currTh = Thread.currentThread();
				currTh.setPriority(Thread.MIN_PRIORITY);

				while (true) {
					System.out.println("ComeTask");
					try {
						Thread.sleep(200);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}

			}
		});
		
		System.out.println(th2.getName());
		
		Thread th3 = new Thread(() ->{
			while(true) {
				System.out.println("byeTask");
				try {
					Thread.sleep(200);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
		System.out.println(th3.getName());
		
		th1.start();
		th2.start();
		th3.start();
		

	} // main
}
