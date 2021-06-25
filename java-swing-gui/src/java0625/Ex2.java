package java0625;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// FlowLayout 배치관리자
public class Ex2 extends JFrame {

	public Ex2() {
		setTitle("FlowLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel contentPane = (JPanel) getContentPane();
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40)); // setLayout 없으면 borderLayout 이 기본값
		
		
		contentPane.add(new JButton("덧셈"));
		contentPane.add(new JButton("뺄셈"));
		contentPane.add(new JButton("곱셈"));
		contentPane.add(new JButton("나눗셈"));
		contentPane.add(new JButton("계산하기"));
		
		setLocationByPlatform(true);
		setSize(300, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new Ex2();
		
		
	} // main

}
