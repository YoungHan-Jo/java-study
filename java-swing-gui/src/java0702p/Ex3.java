package java0702p;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex3 extends JFrame {

	private Container c;

	private JCheckBox apple;
	private JCheckBox pear;
	private JCheckBox cherry;

	private JButton btn;
	
	public Ex3() {
		super("체크박스");
		init();
		setComponents();
		addListener();
		setFrame();
	}

	private void init() {
		apple = new JCheckBox("사과");
		pear = new JCheckBox("배", true);
		cherry = new JCheckBox("체리");
		
		btn = new JButton("버튼");
		
		paintBorder(apple);
		paintBorder(pear);
		paintBorder(cherry);
	}
	
	private void paintBorder(JCheckBox cb) {
		cb.setBorderPainted(true);
	}

	private void setComponents() {
		c = getContentPane();
		c.add(apple);
		c.add(pear);
		c.add(cherry);
		
		c.add(btn);
	}

	private void addListener() {
		btn.addActionListener(event -> {
			StringBuilder sb = new StringBuilder();
			sb.append("사과 : " + apple.isSelected());
			sb.append("\n배 : " + pear.isSelected());
			sb.append("\n체리 : " + cherry.isSelected());
			
			JOptionPane.showMessageDialog(Ex3.this, sb.toString(), "대화상자 제목", JOptionPane.INFORMATION_MESSAGE);
		});
	}

	private void setFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setLocationByPlatform(true);
		c.setLayout(new FlowLayout());

		setVisible(true);
	}

	public static void main(String[] args) {

		new Ex3();

	} // end of main

}
