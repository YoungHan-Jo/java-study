package java0629;

import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class Ex6 extends JFrame {

	private JLabel[] lbNum;

	private int[] randNum;
	private JLabel label;
	private Container c;

	public Ex6() {
		super("Pull the Lever");
		this.init();
		this.setComponents();
		this.addListener();
		this.setFrame();
	} // end of Ex6

	private void init() {
		lbNum = new JLabel[3];
		for (int i = 0; i < lbNum.length; ++i) {
			this.lbNum[i] = new JLabel("0");
			this.lbNum[i].setSize(50, 50);
			this.lbNum[i].setLocation(100 * i + 60, 56);
			this.lbNum[i].setBackground(new Color(0, 0, 0));
			this.lbNum[i].setForeground(new Color(255, 255, 255));
			this.lbNum[i].setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 25));
			this.lbNum[i].setHorizontalAlignment(SwingConstants.CENTER);
			this.lbNum[i].setOpaque(true);
		}

		this.label = new JLabel("시작합니다");
		this.label.setFont(new Font("D2Coding", Font.PLAIN, 20));
		this.label.setHorizontalAlignment(SwingConstants.CENTER);
		this.label.setLocation(97, 145);
		this.label.setSize(183, 30);

	}// end of init

	private void setComponents() {
		c = getContentPane();
		c.setLayout(null);
		for (int i = 0; i < lbNum.length; ++i)
			c.add(lbNum[i]);
		c.add(label);
	} // end of setComponents

	private void addListener() {
		c.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					pullLever();

					if (pullLever() == true)
						label.setText("축하합니다");
					else
						label.setText("아쉽군요");
				}
			};
		});
	} // end of addListener

	private boolean pullLever() {
		this.randNum = new int[3];
		
		for (int i = 0; i < randNum.length; ++i) {
			randNum[i] = (int) (Math.random() * 3 + 1);
			lbNum[i].setText(String.valueOf(randNum[i]));
		}

		boolean result = false;

		if (randNum[0] == randNum[1] && randNum[0] == randNum[2])
			result = true;
		else
			result = false;

		return result;
	} // end of pullLever Method

	private void setFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(387, 245);
		setLocationByPlatform(true);
		setVisible(true);
		c.setFocusable(true);
		c.requestFocus();
	} // end of setFrame

	public static void main(String[] args) {

		new Ex6();

	} // end of main
}
