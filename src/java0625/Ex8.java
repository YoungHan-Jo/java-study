package java0625;

public class Ex8 {

	public static void main(String[] args) {
		
		Thread mainThread = Thread.currentThread();
		
		System.out.println(mainThread.getName()); // 쓰레드 이름 main -> setName도 있음
		System.out.println(mainThread.getPriority()); // 쓰레드 우선순위 5 -> setPriority 도 있음
		
		System.out.println(Thread.MAX_PRIORITY); // 10 높은숫자가 더 빠른거. 선순위
		System.out.println(Thread.NORM_PRIORITY); // 5 (우선순위 기본값)
		System.out.println(Thread.MIN_PRIORITY); // 1  낮은숫자가 더 느린거. 후순위
		
		

	} // main

}
