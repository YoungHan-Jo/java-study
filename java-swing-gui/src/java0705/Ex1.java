package java0705;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Ex1 extends JFrame {
	private final JPanel panel = new JPanel();
	private final JRadioButton rdbtnApple = new JRadioButton("사과");
	private final JRadioButton rdbtnCherry = new JRadioButton("체리");
	private final JRadioButton rdbtnPear = new JRadioButton("배");
	private final JLabel lblImage = new JLabel("");

	private ImageIcon[] imageArr = { new ImageIcon("images/apple.jpg"), new ImageIcon("images/pear.jpg"),
			new ImageIcon("images/cherry.jpg") };

	public Ex1() {
		super("라디오버튼 ItemEvent");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250, 200);
		setLocationByPlatform(true);

		this.panel.setBackground(Color.GRAY);
		getContentPane().add(this.panel, BorderLayout.NORTH);

		// 라디오버튼 3개를 버튼그룹 한개로 그룹화
		ButtonGroup g = new ButtonGroup();
		g.add(rdbtnApple);
		g.add(rdbtnPear);
		g.add(rdbtnCherry);

		this.panel.add(this.rdbtnApple);
		this.panel.add(this.rdbtnPear);
		this.rdbtnCherry.setSelected(true);
		this.panel.add(this.rdbtnCherry);
		lblImage.setIcon(imageArr[2]);

		this.lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(this.lblImage, BorderLayout.CENTER);

		// 라디오 버튼 3개에 ItemListener 이벤트 리스너 연결하기
		MyItemListener itemListener = new MyItemListener();

		rdbtnApple.addItemListener(itemListener);
		rdbtnPear.addItemListener(itemListener);
		rdbtnCherry.addItemListener(itemListener);

		setVisible(true);
	}

	class MyItemListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.DESELECTED) {
				return;
			}

//			JRadioButton rdbtn = (JRadioButton) e.getItem();
//			if(rdbtn == rdbtnApple) {
//				lblImage.setIcon(imageArr[0]);
//			}else if(rdbtn == rdbtnPear) {
//					lblImage.setIcon(imageArr[1]);
//			}else {
//				lblImage.setIcon(imageArr[2]);
//			}

			if (rdbtnApple.isSelected()) {
				lblImage.setIcon(imageArr[0]);
			} else if (rdbtnPear.isSelected()) {
				lblImage.setIcon(imageArr[1]);
			} else {
				lblImage.setIcon(imageArr[2]);
			}

		}

	} // class MyItemListener

	public static void main(String[] args) {

		new Ex1();

	} // end of main

}
