package java0629;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex2 extends JFrame {

	JLabel[] lblKey;

	Ex2() {
		super("키 이벤트 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setLocationByPlatform(true);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		lblKey = new JLabel[3];
		lblKey[0] = new JLabel(" getKeyCode() ");
		lblKey[1] = new JLabel(" getKeyChar() ");
		lblKey[2] = new JLabel(" getKeyText() ");

		for (int i = 0; i < lblKey.length; ++i) {
			c.add(lblKey[i]);
			lblKey[i].setOpaque(true);
			lblKey[i].setBackground(Color.CYAN);
		}

		c.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println("keyTyped");
			}

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("keyPressed");
				
				int keyCode = e.getKeyCode(); // 키 코드 - keyText의 코드번호
				char keyChar = e.getKeyChar(); // 키 문자값 - 실제 입력 값
				String keyText = KeyEvent.getKeyText(keyCode); //키 이름 문자열 표현 // getKeyText는 KeyEvent의 스태틱 메소드
				
				lblKey[0].setText(Integer.toString(keyCode)); // String.valueOf(keyCode); 
				lblKey[1].setText(Character.toString(keyChar)); // String.valueOf(keyChar);
				lblKey[2].setText(keyText); // 실제 키보드에 나와있는 이름표.
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("keyReleased");
			}
			
			
		});

		setVisible(true);
		c.setFocusable(true); // 포커스 받을 수 있게
		c.requestFocus(); // 
	}

	public static void main(String[] args) {

		new Ex2();

	} // end of main
}
