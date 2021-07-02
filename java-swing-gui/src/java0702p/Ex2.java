package java0702p;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Ex2 extends JFrame {

	private Container c;
	
	private ImageIcon beauty;
	private ImageIcon normalIcon;
	
	private JLabel textLabel;
	private JLabel imageLabel;
	private JLabel complexLabel;
	
	public Ex2() {
		super("레이블");
		init();
		setComponents();
		setFrame();
	}

	private void init() {
		beauty = new ImageIcon("images/beauty.jpg");
		normalIcon = new ImageIcon("images/normalIcon.gif");
		
		textLabel = new JLabel("사랑합니다");
		imageLabel = new JLabel(beauty);
		complexLabel = new JLabel("보고싶으면 연락하세요", normalIcon, SwingConstants.CENTER);
	}

	private void setComponents() {
		c = getContentPane();
		
		c.add(textLabel);
		c.add(imageLabel);
		c.add(complexLabel);
		
	}

	private void setFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 600);
		setLocationByPlatform(true);
		c.setLayout(new FlowLayout());

		setVisible(true);
	}

	public static void main(String[] args) {

		new Ex2();

	} // end of main

}
