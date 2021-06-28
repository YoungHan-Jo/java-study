package java0628;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// 3.내부 클래스(inner class)로
// 내부클래스 종류: member inner class, local inner class
// member inner class - 멤버 구성요소로써 클래스를 정의
// local inner class - 지역 내부 클래스.익명의 클래스

class A {

	int num = 100; // 멤버 변수

	class B { // 멤버 내부 클래스

		void methodB() {
			num++;
		}

	}

	class C { // 멤버 내부 클래스

	}

	void methodA() {
		int a = 10; // 지역변수
		class E { // 지역 내부클래스

		}
	}

}

public class Ex3 extends JFrame {

	private JButton btn = new JButton("Action");
	private JTextArea ta = new JTextArea(7, 20);

	public Ex3() {
		setTitle("이벤트 리스너 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.setBackground(Color.cyan);

		ta.setEditable(false); // 편집 못하게 막음.

		c.add(btn);
		c.add(new JScrollPane(ta)); // ta에 스크롤바 부착해서 컨텐트팬에 추가

		btn.addActionListener(new MyActionListener2(c)); // 버튼에 이벤트 핸들러(처리)를 객체로 등록.

		setLocationByPlatform(true);
		setSize(300, 200);
		setVisible(true); // 마지막에 설정 / 화면 최종적으로 갱신됨.
	}

	class MyActionListener2 implements ActionListener {

		Container c;

		public MyActionListener2(Container c) {
			super();
			this.c = c;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String str = ta.getText();
			ta.setText(str + "버튼 클릭됨\n");

			if (btn.getText().equals("Action")) {
				btn.setText("액션");
			} else {
				btn.setText("Action");
			}

			if (c.getBackground() == Color.black) {
				c.setBackground(Color.cyan);
			} else
				c.setBackground(Color.black);

		}

	}

	public static void main(String[] args) {

		new Ex3();

	} // main
}
