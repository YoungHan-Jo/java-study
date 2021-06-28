package java0628;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex7 extends JFrame {

	// 이벤트 메소드정의를 가진 리스너 인터페이스가
	// 추상메소드 선언을 2개 이상 가질 경우
	// 대응되는 Adapter 클래스를 제공해준다. // 안쓰는 매소드를 정의 안 해도 되도록

	class MyMouseListener implements MouseListener { // 인터페이스라서 전부 재정의로 존재해야함

		Container c;

		public MyMouseListener(Container c) {
			super();
			this.c = c;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("버튼이 클릭됨");
		}

		@Override
		public void mousePressed(MouseEvent e) {
			System.out.println("마우스 버튼이 눌러짐");
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			System.out.println("마우스 버튼이 떼짐");
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			System.out.println("마우스가 버튼으로 들어옴");

			JButton btn = (JButton) e.getSource();
			btn.setBackground(Color.RED);

		}

		@Override
		public void mouseExited(MouseEvent e) {
			System.out.println("마우스가 버튼에서 나감");
			JButton btn = (JButton) e.getSource();
			btn.setBackground(Color.YELLOW);
		}

	}

	public Ex7() {
		setTitle("버튼에 마우스 이벤트 리스너 달기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setLocationByPlatform(true);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// 지역 내부클래스에서 참조하는 지역변수는 final 상수로 자동 컴파일됨.
		final JButton btn = new JButton("MouseEvent 테스트 버튼");
		// btn.addMouseListener(new MyMouseListener(c));

		c.add(btn);

		// 익명의 내부 지역클래스로 객체 생성 후 전달
		btn.addMouseListener(new MouseAdapter() {
			// MouseAdapter 클래스는 다른 인터페이스들은 받고있음
			// 인터페이스의 추상매서드가 전부 아무것도 없는 상태로 재정의 되어있어서. 쓸거만 재정의

			@Override
			public void mouseEntered(MouseEvent e) {

				btn.setBackground(Color.RED); // 여기서 btn 객체를 가지고오면
				// 원래 있던 btn은 {} 끝나면 사라져야하는데 여기로 옮아서 수명 연장됨.
			}

			@Override
			public void mouseExited(MouseEvent e) {

				btn.setBackground(Color.YELLOW);
			}

		});

		setVisible(true);
	}

	public static void main(String[] args) {

		new Ex7();

	}// main
}
