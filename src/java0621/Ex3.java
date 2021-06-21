package java0621;

import javax.swing.JFrame;

// 상속 활용 예

// JFrame를 상속 받아 창 만들기


public class Ex3 extends JFrame{
	
	public Ex3() { // 생성자 초기화
		setTitle("창 제목");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기버튼 누르면 프로그램종료
		
		setSize(500, 400); // 가로세로 크기
		setVisible(true); // 보이는지 안보이는지
	}

	public static void main(String[] args) {
		Ex3 window = new Ex3();
		
	}

}
