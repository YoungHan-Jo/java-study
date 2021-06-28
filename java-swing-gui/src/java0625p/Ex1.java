package java0625p;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class Ex1 extends JFrame {
	
	public Ex1() {
		setTitle("창 제목");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.BLUE);
		
		
		setLocationByPlatform(true);
		setSize(300, 200);
		setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Ex1();
	}

}
