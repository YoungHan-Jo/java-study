package java0702;

import javax.swing.JFrame;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex1 extends JFrame {
	private final JButton b1 = new JButton("Magenta/Yellow Button");
	private final JButton b2 = new JButton(" Disabled Button ");
	private final JButton b3 = new JButton("getX(), getY()");

	public Ex1() {
		super("JComponent의 공통 메소드 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		setSize(260, 200);
		setResizable(false); // 창 크기 조절 못하게 막기

		Container c = getContentPane(); // Ex1 객체 자기 자신의 팬을 꺼내는것
		c.setLayout(new FlowLayout());
		this.b1.setFont(new Font("Arial", Font.ITALIC, 20));
		this.b1.setForeground(new Color(255, 0, 255));
		this.b1.setBackground(Color.YELLOW);

		this.b2.setEnabled(false);

		c.add(this.b1);
		c.add(this.b2);
		c.add(this.b3);

		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource(); // 이벤트발생 객체를 추출해서 다운캐스팅
				String location = b.getX() + "," + b.getY();

				JFrame frame = (JFrame) b.getTopLevelAncestor(); // 외부에 있으면 이런식으로 최상위 프레임 가져와서 최상위 프레임 만들기
				// frame.setTitle(location);

				Ex1.this.setTitle(location); // 내부클래스에서 외부클래스 this 로 참조 하려면. 외부클래스이름.this로 참조
			}
		});

		setVisible(true);
	}

	public static void main(String[] args) {

		new Ex1();

	} // end of main

}
