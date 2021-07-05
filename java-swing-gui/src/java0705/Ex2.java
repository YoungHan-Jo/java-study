package java0705;

import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Ex2 extends JFrame {
	
	private CardLayout cardLayout = new CardLayout(0,0); // 카드 레이아웃 배치관리자. //(0,0) cardlayout 액자 내용 꼭다리 좌표
	
	private final JPanel panel1 = new JPanel();
	private final JLabel lblNewLabel = new JLabel("첫번째 화면");
	private final JButton btn1 = new JButton("두번째 화면으로 이동");
	private final JPanel panel2 = new JPanel();
	private final JLabel lblNewLabel_1 = new JLabel("두번째 화면");
	private final JButton btn2 = new JButton("세번째 화면으로 이동");
	private final JPanel panel3 = new JPanel();
	private final JLabel lblNewLabel_2 = new JLabel("세번째 화면");
	
	
	private final JButton btn3 = new JButton("첫 화면으로 돌아가기");
	

	public Ex2() {
		super("카드레이아웃 화면전환");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 500);
		setLocationByPlatform(true);
		
		Container c = getContentPane();
		
		c.setLayout(cardLayout);
		
		c.add(this.panel1, "첫번째 화면"); // 카드 이름
		this.panel1.add(this.lblNewLabel);
		this.panel1.add(this.btn1);
		
		c.add(this.panel2, "두번째 화면");
		this.panel2.add(this.lblNewLabel_1);
		this.panel2.add(this.btn2);
		
		c.add(this.panel3, "세번째 화면");
		this.panel3.add(this.lblNewLabel_2);
		this.panel3.add(this.btn3);
		
		cardLayout.show(c, "첫번째 화면"); // 카드 보여주기 (부모컴포넌트, 보여줄 카드이름);
		
		btn1.addActionListener(e ->{
			cardLayout.show(c, "두번째 화면");
		});
		
		btn2.addActionListener(e ->{
			cardLayout.show(c, "세번째 화면");
		});
		
		btn3.addActionListener(e ->{
			cardLayout.show(c, "첫번째 화면");
		});

		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		
		new Ex2();		
		
	} // end of main
}
