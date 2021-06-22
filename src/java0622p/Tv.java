package java0622p;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Tv {
	private int channel;
	
	void channelUp() {
		channel++;
	}
	void channelDown() {
		channel--;
	}
	
	void showChannel() {
		System.out.println("현재 채널 : " + channel);
	}
}
