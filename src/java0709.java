import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextArea;

public class java0709 extends JFrame {
	private JLabel lblNewLabel;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextArea textArea;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextArea textArea_1;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextArea textArea_2;
	private JPanel panel_5;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JTextArea textArea_3;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;




	

	
	public java0709() {
		
		Container c = getContentPane();
		
		lblNewLabel = new JLabel("New label");
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("New button");
		panel.add(btnNewButton_2);
		
		panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBounds(56, 37, 93, 128);
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_1 = new JLabel("New label");
		panel_2.add(lblNewLabel_1, BorderLayout.NORTH);
		
		lblNewLabel_2 = new JLabel("New label");
		panel_2.add(lblNewLabel_2, BorderLayout.SOUTH);
		
		textArea = new JTextArea();
		panel_2.add(textArea, BorderLayout.CENTER);
		
		panel_3 = new JPanel();
		panel_3.setBounds(171, 37, 93, 128);
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_3 = new JLabel("New label");
		panel_3.add(lblNewLabel_3, BorderLayout.NORTH);
		
		lblNewLabel_4 = new JLabel("New label");
		panel_3.add(lblNewLabel_4, BorderLayout.SOUTH);
		
		textArea_1 = new JTextArea();
		panel_3.add(textArea_1, BorderLayout.CENTER);
		
		panel_4 = new JPanel();
		panel_4.setBounds(288, 37, 93, 128);
		panel_1.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_5 = new JLabel("New label");
		panel_4.add(lblNewLabel_5, BorderLayout.NORTH);
		
		lblNewLabel_6 = new JLabel("New label");
		panel_4.add(lblNewLabel_6, BorderLayout.SOUTH);
		
		textArea_2 = new JTextArea();
		panel_4.add(textArea_2, BorderLayout.CENTER);
		
		panel_5 = new JPanel();
		panel_5.setBounds(414, 37, 93, 128);
		panel_1.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_7 = new JLabel("New label");
		panel_5.add(lblNewLabel_7, BorderLayout.NORTH);
		
		lblNewLabel_8 = new JLabel("New label");
		panel_5.add(lblNewLabel_8, BorderLayout.SOUTH);
		
		textArea_3 = new JTextArea();
		panel_5.add(textArea_3, BorderLayout.CENTER);
		
		panel_6 = new JPanel();
		panel_6.setBounds(56, 204, 93, 128);
		panel_1.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_9 = new JLabel("New label");
		panel_6.add(lblNewLabel_9, BorderLayout.NORTH);
		
		lblNewLabel_10 = new JLabel("New label");
		panel_6.add(lblNewLabel_10, BorderLayout.SOUTH);
		
		textField = new JTextField();
		panel_6.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		panel_7 = new JPanel();
		panel_7.setBounds(171, 204, 93, 128);
		panel_1.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_11 = new JLabel("New label");
		panel_7.add(lblNewLabel_11, BorderLayout.NORTH);
		
		lblNewLabel_12 = new JLabel("New label");
		panel_7.add(lblNewLabel_12, BorderLayout.SOUTH);
		
		textField_1 = new JTextField();
		panel_7.add(textField_1, BorderLayout.CENTER);
		textField_1.setColumns(10);
		
		panel_8 = new JPanel();
		panel_8.setBounds(288, 204, 93, 128);
		panel_1.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_13 = new JLabel("New label");
		panel_8.add(lblNewLabel_13, BorderLayout.NORTH);
		
		lblNewLabel_14 = new JLabel("New label");
		panel_8.add(lblNewLabel_14, BorderLayout.SOUTH);
		
		textField_2 = new JTextField();
		panel_8.add(textField_2, BorderLayout.CENTER);
		textField_2.setColumns(10);
		
		panel_9 = new JPanel();
		panel_9.setBounds(414, 204, 93, 128);
		panel_1.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_15 = new JLabel("New label");
		panel_9.add(lblNewLabel_15, BorderLayout.NORTH);
		
		lblNewLabel_16 = new JLabel("New label");
		panel_9.add(lblNewLabel_16, BorderLayout.SOUTH);
		
		textField_3 = new JTextField();
		panel_9.add(textField_3, BorderLayout.CENTER);
		textField_3.setColumns(10);
		
		
		
		
		

		setSize(600, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new java0709();
	}
}


		
