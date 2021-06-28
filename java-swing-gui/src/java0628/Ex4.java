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

public class Ex4 extends JFrame {

	private JButton btn = new JButton("Action");
	private JTextArea ta = new JTextArea(7, 20);

	public Ex4() {
		setupView(); // 화면 모양 설정

		// new MyActionListener3();// 아직 클래스 정의가 메모리에 없어서 안됨.

		// 이름이 있는 지역 내부 클래스. 실행 흐름 중에 로딩이 일어남 생성자Ex4(){ } 동안만 살아 있음.
		// 그런데 잠깐 쓸거면 굳이 이름 붙여서 할 필요가 없음. 보통 익명클래스로 함
		class MyActionListener3 implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				String str = ta.getText();
				ta.setText(str + "버튼 클릭됨\n");

				if (btn.getText().equals("Action")) {
					btn.setText("액션");
				} else {
					btn.setText("Action");
				}
			}
		} // class MyActionListener3

		// btn.addActionListener(new MyActionListener3()); // 클래스 정의 이후에 해야 객체생성 가능

		// 익명(이름이 없는) 지역 내부클래스.

		ActionListener A = new ActionListener() { // interface ActionLIstener 로 해서 익명으로 객체를 행성하겠다

			@Override
			public void actionPerformed(ActionEvent e) {
				String str = ta.getText();
				ta.setText(str + "버튼 클릭됨\n");

				if (btn.getText().equals("Action")) {
					btn.setText("액션");
				} else {
					btn.setText("Action");
				}
			}
		};

		// btn.addActionListener(A);

//		btn.addActionListener(new ActionListener() { // interface ActionLIstener 로 해서 익명으로 객체를 행성하겠다
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String str = ta.getText();
//				ta.setText(str + "버튼 클릭됨\n");
//
//				if (btn.getText().equals("Action")) {
//					btn.setText("액션");
//				} else {
//					btn.setText("Action");
//				}
//			}
//		});

		// 람다식 : () -> {} 로 함수정의를 전달하는 표현방식
		// 조건 - 인터페이스가 추상메소드 1개만 가졌을 경우면 사용가능.
		// (매개변수) -> {실행문}
		// 매개변수 하나밖에 없으면 () 괄호 생략 가능
		// 실행문 하나밖에 없으면 {} 중괄호 생략가능. but! ; 세미콜론 없어야함.
		btn.addActionListener(event -> { // 매개변수를 가져와야함. 아무이름 가능. 매개변수 형식도 하나뿐이라 생략
			String str = ta.getText();

			ta.setText(str + "버튼 클릭됨\n");

			if (btn.getText().equals("Action")) {
				btn.setText("액션");
			} else {
				btn.setText("Action");
			}

		});

		setVisible(true); // 마지막에 설정 / 화면 최종적으로 갱신됨.
	}// 생성자

	private void setupView() { // 화면 모양 설정
		setTitle("이벤트 리스너 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		ta.setEditable(false); // 편집 못하게 막음.

		c.add(btn);
		c.add(new JScrollPane(ta)); // ta에 스크롤바 부착해서 컨텐트팬에 추가
		setLocationByPlatform(true);
		setSize(300, 200);

	}

	public static void main(String[] args) {

		new Ex4();

	} // main
}
