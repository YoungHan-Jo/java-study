package java0628;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


// 버튼이 클릭되었을 때 발생하는 Action 이벤트 처리하는 예
// 버튼 이름이 "Action" - > "액션" -> "Action" 토글버튼 구현

//1. 프레임 클래스가 리스너까지 전부 구현하는 방법

public class Ex1 extends JFrame implements ActionListener {
	
	
	// 자주 참조하면 멤버변수로 만든다. 이렇게하면 actionPerformed 에서 getsource()로 가져올 필요 없음. 멤버변수로 존재하기 때문에.
	private JButton btn = new JButton("Action");
	private JTextArea ta = new JTextArea(7,20);
	
	public Ex1() {
		setTitle("이벤트 리스터 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());	
		
		ta.setEditable(false); // 편집 못하게 막음.
		
		c.add(btn);
		c.add(new JScrollPane(ta)); // ta에 스크롤바 부착해서 컨텐트팬에 추가
		
		btn.addActionListener(this); // 버튼에 이벤트 핸들러(처리)를 객체로 등록.
		
		setLocationByPlatform(true);
		setSize(300, 200);
		setVisible(true); // 마지막에 설정 / 화면 최종적으로 갱신됨.
	}
	
	
	// 콜백 메서드(call-back) : 사용자는 정의만 해놓고, 시스템이 조건(클릭 등)을 만족할 때 시스템이 호출하는거.
	@Override
	public void actionPerformed(ActionEvent e) {
		// 이벤트소스(여기서는 버튼) 이외의 컴포넌트 참조 가능. 멤버변수로 존재하기 때문에.
		String str = ta.getText(); // 기존 문자열 가져오기
		ta.setText(str + "버튼 클릭됨\n"); // 기존 문자열에서 덧 붙이기
		
		// ActionEvent 매개변수는 이벤트 정보를 가진 이벤트 객체를 전달받음.
		// 이벤트 객체에는 다양한 정보를 가지고 있고 필요한 정보를 가져올 수 있음.
		// 이벤트 소스(이벤트가 발생된 대상. 여기서는 btn) 객체의 참조를 getSource() 메소드로 가져올 수 있음.
		JButton button = (JButton) e.getSource(); // 직접 가져오기.
		
		if(btn.getText().equals("Action")) {
			btn.setText("액션");
		}else {
			btn.setText("Action");
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
	new Ex1(); // 클래스 자체가 jframe 이 됨. 생성자 호출	
		
	} // main



	
}
