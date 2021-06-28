package java0628p;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ex8 extends JFrame {
	private JTextField tfNum1, tfNum2, tfOperator, tfResult;
	private JButton btn;
	private JLabel label;

	public Ex8() {
		setTitle("초간단 사칙연산 계산기");
		this.init(); // init
		this.setLayout(); // components
		this.addListener();
		this.showFrame();// Frame
	} // end of Ex8

	private void init() {
		this.tfNum1 = new JTextField(10);
		this.tfNum2 = new JTextField(10);
		this.tfOperator = new JTextField(3);
		this.tfResult = new JTextField(10);
		this.btn = new JButton("계산");
		this.label = new JLabel("=");
	} // end of init

	private void setLayout() {
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(this.tfNum1);
		c.add(this.tfOperator);
		c.add(this.tfNum2);
		c.add(this.label);
		c.add(this.tfResult);
		c.add(this.btn);
	} // end of seyLayout

	private void showFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 200);
		setLocationByPlatform(true);
		setVisible(true);
	} // end of showFrame

	private void addListener() {
		this.btn.addActionListener((e) -> {
			String num1_String = tfNum1.getText();
			String num2_String = tfNum2.getText();
			String operator = tfOperator.getText();

			String answer = String.valueOf(calculator(num1_String, operator, num2_String));

			tfResult.setText(answer);
		});
	} // end of addListener

	private float calculator(String num1_String, String operator, String num2_String) {
		Float a = Float.valueOf(num1_String);
		Float b = Float.valueOf(num2_String);
		float result = 0.0f;

		if (operator.equals("+")) {
			result = a + b;
		} else if (operator.equals("-")) {
			result = a - b;
		} else if (operator.equals("*")) {
			result = a * b;
		} else if (operator.equals("/")) {
			result = a / b;
		}
		return result;
	} // end of calculator()

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Ex8();
	}

}
