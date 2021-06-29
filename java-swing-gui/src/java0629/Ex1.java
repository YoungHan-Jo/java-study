package java0629;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex1 extends JFrame {

	private JLabel la = new JLabel("hello");

	public Ex1() {
		super("창 제목"); // setTitle("창 제목");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setLocationByPlatform(true);

		Container c = getContentPane();
		c.setLayout(null);

		la.setOpaque(true); // 레이블에 배경색이 보이도록 설정.
		la.setBackground(Color.yellow);
		la.setSize(50, 10);
		la.setLocation(30, 30); // 절대 위치 설정
		c.add(la);

		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// e.getClickCount(); // 클릭 횟수. 이걸로 2번 더블클릭시 작동하는 거 만들 수 있음
				int x = e.getX(); // 마우스가 클릭된 절대값 x 좌표
				int y = e.getY(); // 마우스가 클릭된 절대값 y 좌표
				System.out.println(x + ", " + y);
				System.out.println(e.getClickCount());
				
				la.setLocation(x - 28, y - 18); // 위치 바꿀 수 있음
				
				// 눌러진 마우스 버튼 구분하기
				switch(e.getButton()) {
				case MouseEvent.BUTTON1:
					System.out.println("BUTTON1 눌러짐");
					break;
				case MouseEvent.BUTTON2:
					System.out.println("BUTTON2 눌러짐");
					break;
				case MouseEvent.BUTTON3:
					System.out.println("BUTTON3 눌러짐");
					break;
				}
				
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) { // 더블클릭
					System.out.println("더블클릭"); // 더블클릭은 한번클릭도 같이 동작한다.
				}else if (e.getClickCount() == 1) {
					System.out.println("한번클릭"); 
				}
			}
		});

		setVisible(true);
	}

	public static void main(String[] args) {

		new Ex1();

	} // end of main

}
