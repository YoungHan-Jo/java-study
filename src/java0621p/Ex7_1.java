package java0621p;

public class Ex7_1 {

	public static void main(String[] args) {
		
		SmartTv stv = new SmartTv();
		stv.power = true;
		stv.channel = 8;
		stv.channelUp();
		stv.showTv();
		stv.caption = true;
		stv.showTv();
		
		
		
	} // main

}
