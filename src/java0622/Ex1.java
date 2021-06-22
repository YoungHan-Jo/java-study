package java0622;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

class Tv {
	private int channel;

	public void channelUp() {
		channel++;
	}

	public void channelDown() {
		channel--;
	}

	public void showChannel() {
		System.out.println("현재 채널: " + channel);
	}
}

@Setter
@Getter
class CaptionTv extends Tv {
	boolean isCaptionOn;

	public void showCaption() {
		System.out.println("캡션상태 : " + isCaptionOn);
	}
}

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CaptionTv tv1 = new CaptionTv();

		tv1.setChannel(5);
		tv1.channelUp();
		tv1.showChannel();
		tv1.showCaption();

		System.out.println("=======================");
		tv1.setCaptionOn(true);
		tv1.showCaption();

	} // main

}
