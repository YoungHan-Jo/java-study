package java0628p;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ex8 extends JFrame {
	
	public Ex8() {

		setTitle("초간단 사칙연산 계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 200);
		setLocationByPlatform(true);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn = new JButton("계산");

		JTextField tfNum1 = new JTextField(10);
		JTextField tfNum2 = new JTextField(10);
		JTextField tfOperator = new JTextField(3);
		JTextField tfResult = new JTextField(10);

		c.add(tfNum1);
		c.add(tfOperator);
		c.add(tfNum2);
		c.add(new JLabel("="));
		c.add(tfResult);
		c.add(btn);

		btn.addActionListener(event -> {
			String num1_String = tfNum1.getText();
			String num2_String = tfNum2.getText();
			String operator = tfOperator.getText();

			String answer = String.valueOf(calculator(num1_String, operator, num2_String));

			tfResult.setText(answer);
		});
		
		
		setVisible(true);
	} // end of Ex8

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
