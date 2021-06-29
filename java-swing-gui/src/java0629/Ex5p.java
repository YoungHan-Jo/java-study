package java0629;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;

public class Ex5p {

	private JFrame frame;
	private JTextField textField;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex5p window = new Ex5p();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Ex5p() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 255, 255));
		frame.setBounds(100, 100, 409, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setFont(new Font("D2Coding", Font.PLAIN, 16));
		btnNewButton.setBounds(130, 136, 125, 48);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(130, 71, 125, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
