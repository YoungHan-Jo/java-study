package java0622p;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CaptionTv extends Tv{
	private boolean isCaptionOn;

	public CaptionTv() {
	
	}
	
	CaptionTv(int channel) {
		super(channel);
	}
	
	void captionStatus() {
		System.out.println("μΊ‘μ μν : " + isCaptionOn);
	}

}
