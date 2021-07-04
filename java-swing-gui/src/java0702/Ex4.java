package java0702;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex4 extends JFrame {

	private JLabel sumLabel = new JLabel("현재 0 원 입니다.");
	private JCheckBox apple = new JCheckBox("사과");
	private JCheckBox pear = new JCheckBox("배");
	private JCheckBox cherry = new JCheckBox("체리");

	public Ex4() {
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

		MyItemListener itemListener = new MyItemListener();
		apple.addItemListener(itemListener);
		pear.addItemListener(itemListener);
		cherry.addItemListener(itemListener);

		setVisible(true);
	}

	class MyItemListener implements ItemListener {

		private int sum = 0;

		@Override
		public void itemStateChanged(ItemEvent e) {
			JCheckBox item = (JCheckBox) e.getItem();// 이벤트를 발생시킨 Object 리턴.

			if (e.getStateChange() == ItemEvent.SELECTED) {
				if (item == apple) {
					sum += 100;
				} else if (item == pear) {
					sum += 500;
				} else { // item == cherry
					sum += 20000;
				}
			} else { // ItemEvent.DESELECTED
				if (item == apple) {
					sum -= 100;
				} else if (item == pear) {
					sum -= 500;
				} else { // item == cherry
					sum -= 20000;
				}

			}
			sumLabel.setText("현재 " + sum + "원 입니다.");

		}

	}

	public static void main(String[] args) {

		new Ex4();

	} // end of main

}
