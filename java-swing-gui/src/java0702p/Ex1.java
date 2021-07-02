package java0702p;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex1 extends JFrame {
	
	private Container c;
	private final JButton btn1 = new JButton("Magenta/Yellow Button");
	private final JButton btn2 = new JButton(" Disabled Button ");
	private final JButton btn3 = new JButton("getX(), getY()");
	
	public Ex1() {
		super("JComponent의 공통 메소드 예제");
		init();
		setComponents();
		addListener();
		setFrame();
				
	}
	
	private void init() {
		makeUpBtn1();
		btn2.setEnabled(false);
		
	}
	
	private void makeUpBtn1() {
		this.btn1.setFont(new Font("Arial", Font.ITALIC, 20));
		this.btn1.setForeground(new Color(255, 0, 255));
		this.btn1.setBackground(new Color(255, 255, 0));
	}
	
	private void setComponents() {
		c = getContentPane();
		
		c.add(btn1);
		c.add(btn2);
		c.add(btn3);
	}
	
	private void addListener() {
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();
			
			JFrame frame = (JFrame) btn.getTopLevelAncestor();
			frame.setTitle(btn.getX() + "," + btn.getY());
				
			}
		});
	}
	
	private void setFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(260, 200);
		setResizable(false);
		setLocationByPlatform(true);
		c.setLayout(new FlowLayout());
				
		setVisible(true);
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Ex1();
		
	} // end of main

}
