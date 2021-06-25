package java0625;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// 컨테이너 : 컴포넌트를 포함할 수 있는 요소 ex) JFrame 윈도우 창
// 컴포넌트 : 컨테이너 안에 포함되야만 나타나는 요소 ex) JButton 버튼

// GUi 프로그램에서는 main 쓰레드의 역할이 최소화됨.

public class Ex1 extends JFrame {

	public Ex1() {
		setTitle("창 제목"); // 창 제목 달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창이 닫힐때 프로그램도 함게 종료.// System.exit(0); 자바프로그램 종료.
		
		Container contentPane = getContentPane(); // 컨텐트팬 영역을 가져오기  // Container 부모 참조변수
		contentPane.setBackground(Color.orange);  // 컨텐트팬 영역에 오렌지색 배경 설정
		
		contentPane.setLayout(new FlowLayout()); //  컨텐트팬에 flowlayout (왼쪽 -> 오른쪽) 배치관리자를 설정 ( 안에 들어갈 버튼 정렬 방식)
		contentPane.add(new JButton("OK"));
		contentPane.add(new JButton("Cancel"));
		contentPane.add(new JButton("Ignore"));
		
		setLocationByPlatform(true);
		setSize(400, 300); // 창 크기 가로,세로 (디폴트값 0,0)
		setVisible(true); // 창을 화면에 보이게 설정 ( 디폴트 false)
		
		
	}
	
	
	public static void main(String[] args) {
		// 
		
		new Ex1();

	} // main

}
