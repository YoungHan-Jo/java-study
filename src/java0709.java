import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.Dimension;
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
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JCheckBox;

public class java0709 extends JFrame {

	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_4;
	private JPanel panel_3;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPanel panel_11;
	private JTable table;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxNewCheckBox_1;

	public java0709() {

		Container c = getContentPane();

		panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);

		lblNewLabel = new JLabel("New label");
		panel_1.add(lblNewLabel);

		panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new BorderLayout(0, 0));

		panel_7 = new JPanel();
		panel_2.add(panel_7, BorderLayout.NORTH);

		table = new JTable();
		panel_7.add(table);

		panel_8 = new JPanel();
		panel_2.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new BorderLayout(0, 0));

		panel_9 = new JPanel();
		panel_8.add(panel_9, BorderLayout.NORTH);

		lblNewLabel_1 = new JLabel("New label");
		panel_9.add(lblNewLabel_1);

		panel_10 = new JPanel();
		panel_8.add(panel_10, BorderLayout.CENTER);

		panel_11 = new JPanel();
		panel_8.add(panel_11, BorderLayout.WEST);

		panel_4 = new JPanel();
		getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));

		panel_3 = new JPanel();
		panel_4.add(panel_3, BorderLayout.NORTH);

		panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.SOUTH);

		panel_6 = new JPanel();
		panel_4.add(panel_6, BorderLayout.CENTER);

		chckbxNewCheckBox_1 = new JCheckBox("New check box");
		panel_6.add(chckbxNewCheckBox_1);
		chckbxNewCheckBox_1.setBorderPainted(true);
		chckbxNewCheckBox_1.setPreferredSize(new Dimension(200, 300));

		chckbxNewCheckBox = new JCheckBox("New check box");
		panel_6.add(chckbxNewCheckBox);

		setSize(600, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new java0709();
	}
}
