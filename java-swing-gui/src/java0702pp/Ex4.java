package java0702pp;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex4 extends JFrame {

	private Container c;

	private JLabel lblMenu;
	private JLabel lblSum;

	private JCheckBox[] fruits;

	public Ex4() {
		super("체크박스");
		init();
		setComponents();
		addListener();
		setFrame();
	}

	private void init() {
		lblMenu = new JLabel("사과 100원, 배 500원, 체리 20000원");
		lblSum = new JLabel("현재 0원 입니다.");

		fruits = new JCheckBox[3];
		fruits[0] = new JCheckBox("사과");
		fruits[1] = new JCheckBox("배");
		fruits[2] = new JCheckBox("체리");

		for (JCheckBox cb : fruits)
			cb.setBorderPainted(true);
	}

	private void setComponents() {
		c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(lblMenu);

		for (JCheckBox cb : fruits)
			c.add(cb);

		c.add(lblSum);

	}

	private void addListener() {
		MyItemListener itemListener = new MyItemListener(lblSum);
		for (JCheckBox cb : fruits)
			cb.addItemListener(itemListener);
	}

	class MyItemListener implements ItemListener {

		JLabel lblSum;
		int sum = 0;

		public MyItemListener(JLabel lblSum) {
			this.lblSum = lblSum;
		}

		@Override
		public void itemStateChanged(ItemEvent e) {

			JCheckBox item = (JCheckBox) e.getItem();

			if (e.getStateChange() == ItemEvent.SELECTED) {
				if (item == fruits[0])
					sum += 100;
				else if (item == fruits[1])
					sum += 500;
				else
					sum += 20000;
			} else {
				if (item == fruits[0])
					sum -= 100;
				else if (item == fruits[1])
					sum -= 500;
				else
					sum -= 20000;
			}

			lblSum.setText("현재 " + sum + "원 입니다.");

		}

	}

	private void setFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250, 200);
		setLocationByPlatform(true);

		setVisible(true);
	}

	public static void main(String[] args) {

		new Ex4();

	}

}
