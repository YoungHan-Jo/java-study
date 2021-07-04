package java0702pp;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Font;

public class Ex1 extends JFrame {

	Container c;

	private final JButton b1 = new JButton("Magenta/Yellow Button");
	private final JButton b2 = new JButton(" Disabled Button ");
	private final JButton b3 = new JButton("getX(), getY()");

	public Ex1() {
		super("JComponent 공통 메소드 예제");
		init();
		setComponents();
		addListener();
		setFrame();
	}

	private void init() {
		makeupB1(b1);
		b2.setEnabled(false);
	}

	private void makeupB1(JButton b1) {
		b1.setForeground(Color.MAGENTA);
		b1.setBackground(Color.YELLOW);
		b1.setFont(new Font("Arial", Font.ITALIC, 20));
	}

	private void setComponents() {
		c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(b1);
		c.add(b2);
		c.add(b3);
	}

	private void addListener() {
		b3.addActionListener(event -> {
			JButton btn = (JButton) event.getSource();
			int locateX = btn.getX();
			int locateY = btn.getY();

			JFrame frame = (JFrame) btn.getTopLevelAncestor();

			frame.setTitle(locateX + "," + locateY);
		});
	}

	private void setFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(260, 200);
		setLocationByPlatform(true);

		setVisible(true);
	}

	public static void main(String[] args) {

		new Ex1();

	} // end of main

}
