package java0702pp;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex3 extends JFrame {
	
	private Container c;
	
	private JCheckBox[] cb;
	
	private JButton btn;
	
	public Ex3() {
		super("체크박스");
		init();
		setComponents();
		addListener();
		setFrame();
	}

	private void init() {
		cb = new JCheckBox[3];
		cb[0] = new JCheckBox("사과");
		cb[1] = new JCheckBox("배");
		cb[2] = new JCheckBox("체리");
		
		btn = new JButton("버튼");
		
		for(JCheckBox cb : cb)
			cb.setBorderPainted(true);
	}

	private void setComponents() {
		c = getContentPane();
		c.setLayout(new FlowLayout());
		for(JCheckBox cb : cb)
			c.add(cb);
		c.add(btn);
	}

	private void addListener() {
		btn.addActionListener(e ->{
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < cb.length; ++i) {
				sb.append(cb[i].getText() + " : " + cb[i].isSelected() +"\n");
			}
			
			JOptionPane.showMessageDialog(Ex3.this, sb.toString());
			
			
		});
	}

	private void setFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(230, 200);
		setLocationByPlatform(true);
		
		setVisible(true);
	}

	public static void main(String[] args) {

		new Ex3();

	} // end of main

}
