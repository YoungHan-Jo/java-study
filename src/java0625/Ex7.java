package java0625;

public class Ex7 {

	public static void main(String[] args) {
		// 람다식을 사용할 수 있는 경우
		// : 함수형 인터페이스일 때만 사용가능함
		// -> 선언된 추상메소드를 한개만 가진 인터페이스는 함수형 인터페이스라고 한다.

		// 익명의 내부클래스
		// 클래스로부터 객체생성 후 . 업캐스팅해서 사용.

		Runnable goTask = new Runnable() { // 익명의 클래스. 이름없는 클래스에 implements Runnable 한것과 같음/ 일회용.

			@Override
			public void run() {
				while (true) {
					System.out.println("goTask");
					
					try {
						Thread.sleep(200); // 1초 = 1000ms
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} // while
			}
		};

		Thread th1 = new Thread(goTask);
		System.out.println(th1.getName());
		th1.setName("goThread");
		th1.setPriority(Thread.MAX_PRIORITY); // 우선순위 최대값 설정. 숫자가 높을 수록 빠른거
		System.out.println(th1.getName());
		
		
		System.out.println("==============================");
		
		Thread th2 = new Thread(new Runnable() {

			@Override
			public void run() {
				
				Thread curTh = Thread.currentThread(); // 현재 쓰레드
				curTh.setPriority(Thread.MIN_PRIORITY); // 우선순위 최소값. 가장 후 순위
				
				while (true) {
					System.out.println("ComeTask");
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}

		});
		System.out.println(th2.getName());
		

		Thread th3 = new Thread(() -> {
			while (true) {
				System.out.println("byeTask");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		System.out.println(th3.getName());
		
//		th1.start();
//		th2.start();
//		th3.start();

	} // main

}
