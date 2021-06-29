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

	private JLabel[] lblNum;
	private int[] randNum;
	private JLabel lblResult;
	private Container c;
	public static final int NUMBER_OF_LBLNUM = 3;
	public static final int RANGE_OF_RANDNUM = 3;

	public Ex6() {
		super("Pull the Lever");
		this.init();
		this.setComponents();
		this.addListener();
		this.setFrame();
	} // end of Ex6

	private void init() {
		lblNum = new JLabel[NUMBER_OF_LBLNUM];
		for (int i = 0; i < lblNum.length; ++i) {
			this.lblNum[i] = new JLabel("0");
			makeUpLblNum(this.lblNum[i], i);
		}

		this.lblResult = new JLabel("시작합니다");
		this.lblResult.setFont(new Font("D2Coding", Font.PLAIN, 20));
		this.lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblResult.setLocation(NUMBER_OF_LBLNUM * 45 - 40, 145);
		this.lblResult.setSize(183, 30);

	}// end of init

	private void makeUpLblNum(JLabel label, int indexNum) {
		label.setSize(50, 50);
		label.setLocation(100 * indexNum + 60, 55);
		label.setBackground(new Color(0, 0, 0));
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 25));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setOpaque(true);
	} // end of makeUpLblNum

	private void setComponents() {
		c = getContentPane();
		c.setLayout(null);

		for (JLabel label : lblNum)
			c.add(label);

		c.add(lblResult);
	} // end of setComponents

	private void addListener() {
		c.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					pullLever();

					if (pullLever() == true)
						lblResult.setText("축하합니다");
					else
						lblResult.setText("아쉽군요");
				}
			}; // end of keyPressed
		});
	} // end of addListener

	private boolean pullLever() {
		this.randNum = new int[NUMBER_OF_LBLNUM];

		for (int i = 0; i < randNum.length; ++i) {
			randNum[i] = (int) (Math.random() * RANGE_OF_RANDNUM + 1);
			lblNum[i].setText(String.valueOf(randNum[i]));
		}

		boolean result = false;

		for (int i = 1; i < randNum.length; ++i) {
			if (randNum[i] != randNum[i - 1]) {
				result = false;
				break;
			} else
				result = true;
		}

		return result;
	} // end of pullLever Method

	private void setFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(NUMBER_OF_LBLNUM * 100 + 80, 245);
		setLocationByPlatform(true);
		setVisible(true);
		c.setFocusable(true);
		c.requestFocus();
	} // end of setFrame

	public static void main(String[] args) {

		new Ex6();

	} // end of main
} // end of Ex6
