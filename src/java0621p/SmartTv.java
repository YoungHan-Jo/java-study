package java0621p;

public class SmartTv extends Tv{
	boolean caption;
	void displayCaption() {
		if(caption == true) {
			System.out.println("text");
		}
	}
	
	void showTv() {
		System.out.println(channel + "번 채널,");
		displayCaption();
	}
}
