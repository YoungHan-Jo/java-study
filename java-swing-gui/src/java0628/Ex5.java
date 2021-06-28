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

import java0628.Ex3.MyActionListener2;


// 외부클래스는 static 클래스와 같다.
public class Ex5 extends JFrame {
	
	 int a = 10;
	 static int b = 20;
	
	// 클래스단위(스태틱) 내부클래스는 외부 독립클래스와 동일함. 위치만 내부에 존재함.
		static class MyActionListener5 implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println(a); 클래스 안에 있더라도. static은 시작부터 생성이라 a는 그때 존재하지 않음
				System.out.println(b); // b는 static 이라서 처음에 존재하고 있기 때문에 가능.
			}
		}
		static interface Movable{ // 이거처럼 그냥 정리만 해서 위치만 안에 있는 것,
			public static final int RED = 1;
			public static final int BLUE = 2;
		}
	
	private JButton btn = new JButton("Action");
	private JTextArea ta = new JTextArea(7, 20);

	public Ex5() {
		setTitle("이벤트 리스너 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.setBackground(Color.cyan);

		ta.setEditable(false); // 편집 못하게 막음.

		c.add(btn);
		c.add(new JScrollPane(ta)); // ta에 스크롤바 부착해서 컨텐트팬에 추가

		// btn.addActionListener(new MyActionListener2()); // 버튼에 이벤트 핸들러(처리)를 객체로 등록.

		setLocationByPlatform(true);
		setSize(300, 200);
		setVisible(true); // 마지막에 설정 / 화면 최종적으로 갱신됨.

	}

	
	

	public static void main(String[] args) {

		new Ex5();
		
		

	} // main
}
