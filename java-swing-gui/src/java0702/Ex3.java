package java0702;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex3 extends JFrame {

	public Ex3() {
		super("체크박스");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setLocationByPlatform(true);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		ImageIcon appleIcon = new ImageIcon("images/apple.jpg");
		ImageIcon pearIcon = new ImageIcon("images/pear.jpg");
		ImageIcon cherryIcon = new ImageIcon("images/cherry.jpg");
		ImageIcon selectedCherryIcon = new ImageIcon("images/selectedCherry.jpg");
		
		
		JCheckBox apple = new JCheckBox("사과");
		JCheckBox pear = new JCheckBox("배", true); // 기본값 체크
		JCheckBox cherry = new JCheckBox("체리", cherryIcon); // 이미지넣기
		
		JButton btn = new JButton("버튼");
		btn.addActionListener(event ->{
			
			String str = "";
			str += "사과 : " + apple.isSelected(); // isSelected 선택 유무, boolean 리턴
			str += "\n배 : " + pear.isSelected();
			str += "\n체리 : " + cherry.isSelected();
			
			JOptionPane.showMessageDialog(Ex3.this, str , "대화상자 제목", JOptionPane.INFORMATION_MESSAGE);
			
			
			//System.out.println("사과 : " + apple.isSelected());
		});
		
		cherry.setSelectedIcon(selectedCherryIcon); // 선택되었을때 이미지
		cherry.setBorderPainted(true); // 테두리 선 유무
		
		c.add(apple);
		c.add(pear);
		c.add(cherry);
		c.add(btn);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {

		new Ex3();

	} // end of main

}
