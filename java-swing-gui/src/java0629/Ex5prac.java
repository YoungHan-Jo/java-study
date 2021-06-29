package java0629;

import java.awt.Container;

import javax.swing.JFrame;
import java.awt.Color;

public class Ex5prac extends JFrame {

	

	public Ex5prac() {
		
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		setSize(500, 300);
		
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.BLUE);
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new Ex5prac();
		
	} // end of main
	
}
