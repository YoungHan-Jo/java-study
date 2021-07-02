package java0702p;

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
	public static final int NUM_OF_FRUITS = 3;

	public Ex4() {
		super("체크박스");
		init();
		setComponents();
		addListener();
		setFrame();
	}

	private void init() {
		fruits = new JCheckBox[NUM_OF_FRUITS];
		fruits[0] = new JCheckBox("사과");
		fruits[1] = new JCheckBox("배");
		fruits[2] = new JCheckBox("체리");

		lblMenu = new JLabel(
				fruits[0].getText() + " 100원, " + fruits[1].getText() + " 500원, " + fruits[2].getText() + " 20000원");

		lblSum = new JLabel("현재 0원 입니다.");

		for (JCheckBox cb : fruits) {
			paintBorder(cb);
		}
	}

	private void paintBorder(JCheckBox cb) {
		cb.setBorderPainted(true);
	}

	private void setComponents() {
		c = getContentPane();
		c.add(lblMenu);
		for (JCheckBox cb : fruits) {
			c.add(cb);
		}

		c.add(lblSum);

	}

	private void addListener() {

		MyItemListener itemListener = new MyItemListener();

		for (int i = 0; i < fruits.length; ++i)
			fruits[i].addItemListener(itemListener);

	}

	class MyItemListener implements ItemListener {

		private int sum = 0;

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
		c.setLayout(new FlowLayout());

		setVisible(true);
	}

	public static void main(String[] args) {

		new Ex4();

	} // end of main

}
