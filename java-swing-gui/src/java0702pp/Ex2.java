package java0702pp;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Ex2 extends JFrame {

	Container c;

	ImageIcon beauty;
	ImageIcon normalIcon;
	ImageIcon rollOverIcon;
	ImageIcon pressedIcon;

	JLabel textLabel;
	JLabel imageLabel;
	JButton btn;

	public Ex2() {
		super("레이블");
		init();
		setComponents();
		addListener();
		setFrame();
	}

	private void init() {
		beauty = new ImageIcon("images/beauty.jpg");
		normalIcon = new ImageIcon("images/normalIcon.gif");
		rollOverIcon = new ImageIcon("images/rolloverIcon.gif");
		pressedIcon = new ImageIcon("images/pressedIcon.gif");

		textLabel = new JLabel("사랑합니다.");
		imageLabel = new JLabel(beauty);
		btn = new JButton("보고 싶으면 전화하세요.", normalIcon);
		btn.setRolloverIcon(rollOverIcon);
		btn.setPressedIcon(pressedIcon);
	}

	private void setComponents() {
		c = getContentPane();
		c.setLayout(new FlowLayout());

		c.add(textLabel);
		c.add(imageLabel);
		c.add(btn);

	}

	private void addListener() {
		btn.addActionListener(e -> {

			JButton btn = (JButton) e.getSource();

			JFrame frame = (JFrame) btn.getTopLevelAncestor();

			answerQuestion(frame);

		});
	}

	private void answerQuestion(JFrame frame) {
		int count = 3;

		while (count > 0) {
			String answer = JOptionPane.showInputDialog(frame, "3+1 = ?", "문제 풀기", JOptionPane.INFORMATION_MESSAGE);

			if (Integer.valueOf(answer) == 4) {
				JOptionPane.showMessageDialog(frame, "next stage", "info", JOptionPane.INFORMATION_MESSAGE);
				break;
			} else
				count -= 1;
		}

		if (count == 0) {
			JOptionPane.showMessageDialog(frame, "game over", "game over", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	private void setFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 600);
		setLocationByPlatform(true);

		setVisible(true);
	}

	public static void main(String[] args) {

		new Ex2();

	}

}
