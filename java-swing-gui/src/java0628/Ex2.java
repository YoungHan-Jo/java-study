package java0628;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//버튼이 클릭되었을 때 발생하는 Action 이벤트 처리하는 예
//버튼 이름이 "Action" - > "액션" -> "Action" 토글버튼 구현

// 2. 이벤트 리스너 클래스를 외부 독립 클래스로 구현하는 방법.

// 조작할 객체가 많으면 전부 의존객체로 생성자 주입 받아야해서 귀찮음.

// 의존객체(사용할 대상객체) : 포함관계가 된다.
// 의존객체는 외부에서 주입받도록 만든다.
// 생성자 또는 setter를 통해서 주입받음.

class MyActionListener implements ActionListener {

	private JTextArea ta; // new 로 새로 만들면 안되고. Ex2에서 만든 객체를 가져와야함.

	//생성자를 통해서 의존객체인 ta를 주입받음.(외부로부터 전달 받음)
	public MyActionListener(JTextArea ta) {
		super();
		this.ta = ta;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = ta.getText();
		ta.setText(str + "버튼 클릭됨\n");

		JButton button = (JButton) e.getSource(); // 외부 클래스라서 이렇게 가져와야함.
		// getSource(); 는 오브젝트 형태로 가져오기때문에 형변환 해야함.

		if (button.getText().equals("Action")) {
			button.setText("액션");
		} else {
			button.setText("Action");
		}
	}
}

public class Ex2 extends JFrame {

	private JButton btn = new JButton("Action");
	private JTextArea ta = new JTextArea(7, 20);

	public Ex2() {
		setTitle("이벤트 리스너 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		ta.setEditable(false); // 편집 못하게 막음.

		c.add(btn);
		c.add(new JScrollPane(ta)); // ta에 스크롤바 부착해서 컨텐트팬에 추가

		btn.addActionListener(new MyActionListener(ta)); // 버튼에 이벤트 핸들러(처리)를 객체로 등록.

		setLocationByPlatform(true);
		setSize(300, 200);
		setVisible(true); // 마지막에 설정 / 화면 최종적으로 갱신됨.
	}

	public static void main(String[] args) {

		new Ex2();

	} // main

}
