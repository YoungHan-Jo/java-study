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
		this.init(); 
		this.setComponents(); 
		this.addListener();
		this.setFrame();
	} // end of Ex8

	private void init() {
		this.tfNum1 = new JTextField(5);
		this.tfNum2 = new JTextField(5);
		this.tfOperator = new JTextField(3);
		this.tfResult = new JTextField(5);
		this.btn = new JButton("계산");
		this.label = new JLabel("=");
	} // end of init

	private void setComponents() {
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(this.tfNum1);
		c.add(this.tfOperator);
		c.add(this.tfNum2);
		c.add(this.label);
		c.add(this.tfResult);
		c.add(this.btn);
	} // end of seyLayout

	private void setFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 100);
		setLocationByPlatform(true);
		setVisible(true);
	} // end of showFrame

	private void addListener() {
		this.btn.addActionListener((e) -> {
			Float num1 = Float.valueOf(tfNum1.getText());
			Float num2 = Float.valueOf(tfNum2.getText());
			String operator = tfOperator.getText();

			String answer = String.valueOf(calculator(num1, num2, operator));
			
			tfResult.setText(answer);
		});
	} // end of addListener

	private float calculator(float num1, float num2, String operator) {
	
		float result = 0.0f;

		if (operator.equals("+")) {
			result = num1 + num2;
		} else if (operator.equals("-")) {
			result = num1 - num2;
		} else if (operator.equals("*")) {
			result = num1 * num2;
		} else if (operator.equals("/")) {
			result = num1 / num2;
		}
		return result;
	} // end of calculator()

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Ex8();
	}

}
