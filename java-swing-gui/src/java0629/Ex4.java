package java0629;

import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex4 extends JFrame {

	private JLabel la = new JLabel("Hello");
	private int laX, laY;

	final int MOVE_UNIT = 10;

	public Ex4() {
		super("상,하,좌,우 키를 이용하여 텍스트 움직이기");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);

		Container c = getContentPane();
		c.setLayout(null); // 레이블이 자유롭게 위치하도록 제거

		la.setSize(100, 20);
		la.setLocation(50, 50);
		laX = la.getX();
		laY = la.getY();
		c.add(la);

		c.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_LEFT: 
					laX -= MOVE_UNIT;
					break;
				case KeyEvent.VK_RIGHT:
					laX += MOVE_UNIT;
					break;
				case KeyEvent.VK_UP:
					laY -= MOVE_UNIT;
					break;
				case KeyEvent.VK_DOWN:
					laY += MOVE_UNIT;
					break;
				}
				la.setLocation(laX, laY);
				System.out.println(laX+","+laY);
			}
		});

		setVisible(true);

		c.setFocusable(true);
		c.requestFocus();
	}

	public static void main(String[] args) {

		new Ex4();

	} // end of main

}
