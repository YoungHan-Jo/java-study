package java0622p;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CaptionTv extends Tv{
	private boolean isCaptionOn;
	
	void captionStatus() {
		System.out.println("캡션 상태 : " + isCaptionOn);
	}
}
