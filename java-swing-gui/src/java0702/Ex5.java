package java0702;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex5 extends JFrame {

	private JLabel sumLabel = new JLabel("현재 0 원 입니다.");
	private JCheckBox apple = new JCheckBox("사과");
	private JCheckBox pear = new JCheckBox("배");
	private JCheckBox cherry = new JCheckBox("체리");

	private int sum = 0;

	public Ex5() {
		super("체크박스");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250, 200);
		setLocationByPlatform(true);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JLabel lblMenu = new JLabel("사과 100원, 배 500원, 체리 20000원");

		apple.setBorderPainted(true);
		pear.setBorderPainted(true);
		cherry.setBorderPainted(true); // 테두리 선 유무

		c.add(lblMenu);
		c.add(apple);
		c.add(pear);
		c.add(cherry);
		c.add(sumLabel);

		apple.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED)
				sum += 100;
			else
				sum -= 100;
			sumLabel.setText("현재 " + sum + "원 입니다.");
		});
		pear.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED)
				sum += 500;
			else
				sum -= 500;
			sumLabel.setText("현재 " + sum + "원 입니다.");
		});
		cherry.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED)
				sum += 2000;
			else
				sum -= 2000;
			sumLabel.setText("현재 " + sum + "원 입니다.");
		});

		setVisible(true);
	}

	public static void main(String[] args) {

		new Ex5();

	} // end of main

}
