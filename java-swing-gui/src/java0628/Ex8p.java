package java0628;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex8p extends JFrame {
	private JTextField 			jtf1, jtf3, jtf4;
	private JComboBox   		jcb;
	private JLabel				lbl;
	private JButton				btn;
	private static String[]    	NAMES;
	// 생성자
	public Ex8p() {
		super("초간단한 사칙연산 계산기");
		this.init(); // 변수 초기화하는 메서드
		this.setLayout(); // 화면 구성요소 메서드
		this.addListener(); // 화면 이벤트 메서드
		this.showFrame(); // 화면을 보여주기 위한 메서드
	} // end of Ex8

	private void init() {
		this.jtf1 = new JTextField(3);
		NAMES     = new String[]{"+", "-", "*", "/"};
		this.jcb  = new JComboBox<String>(NAMES);
		this.jtf3 = new JTextField(3);
		this.jtf4 = new JTextField(5);
		this.lbl  = new JLabel("=");
		this.btn  = new JButton("계산");
	} // end of init

	private void setLayout() {
		this.setLayout(new FlowLayout());
		
		this.jtf4.setEditable(false);
		
		this.add(this.jtf1);
		this.add(this.jcb);
		this.add(this.jtf3);
		this.add(this.lbl);
		this.add(this.jtf4);
		this.add(this.btn);
	} // end of setLayout

	private void addListener() {
		this.btn.addActionListener(e -> {
			String  temp = "";
			
			if (this.jcb.getSelectedItem().toString().equals("+")) {
				temp = String.valueOf(Integer.parseInt(this.jtf1.getText()) + Integer.parseInt(this.jtf3.getText()));
				this.jtf4.setText(temp); 
			} else if (this.jcb.getSelectedItem().toString().equals("-")) {
				temp = String.valueOf(Integer.parseInt(this.jtf1.getText()) - Integer.parseInt(this.jtf3.getText()));
				this.jtf4.setText(temp);
			} else if (this.jcb.getSelectedItem().toString().equals("*")) {
				temp = String.valueOf(Integer.parseInt(this.jtf1.getText()) * Integer.parseInt(this.jtf3.getText()));
				this.jtf4.setText(temp);
			} else if (this.jcb.getSelectedItem().toString().equals("/")) {
				temp = String.valueOf(Integer.parseInt(this.jtf1.getText()) / Integer.parseInt(this.jtf3.getText()));
				this.jtf4.setText(temp);
			}
		});
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				int result = JOptionPane.showConfirmDialog(Ex8p.this, "종료하시겠습니까?", "종료", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if (result == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			} // end of windowClosing
		});
	} // end of addListener

	private void showFrame() {
		this.setSize(300, 150);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	} // end of showFrame

	public static void main(String[] args) {
		new Ex8p();
	} // end of main
} // end of Ex8