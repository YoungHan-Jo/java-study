package com.example.repository;

import java.util.List;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Ex0 extends JFrame {

	public static final int TABLE_NUMBER = 15;

	private JPanel[] panelTable = new JPanel[TABLE_NUMBER];
	private JPanel[] panelTableHeader = new JPanel[TABLE_NUMBER];
	private JLabel[] lblTableCharge = new JLabel[TABLE_NUMBER];
	private JTextArea[] taTableOrderList = new JTextArea[TABLE_NUMBER];
	private JLabel[] lblTableNum = new JLabel[TABLE_NUMBER];
	private JLabel[] lblTableAdmission = new JLabel[TABLE_NUMBER];
	private JLabel[] lblTableCno = new JLabel[TABLE_NUMBER];
	private JLabel[] lblTableGetCno = new JLabel[TABLE_NUMBER];
	
	List<JPanel> tableList = new ArrayList<>();
	private JTextField tfChangeNum;

	public Ex0() {
		super("JPanel");

		Container container = getContentPane();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 900, 800);

		container.add(scrollPane);

		JPanel panelTables = new JPanel();
		panelTables.setPreferredSize(new Dimension(900, 1200));
		scrollPane.setViewportView(panelTables);
		panelTables.setLayout(null);

		tfChangeNum = new JTextField();
		tfChangeNum.setBounds(615, 10, 116, 21);
		panelTables.add(tfChangeNum);
		tfChangeNum.setColumns(10);

		for (int i = 0; i < TABLE_NUMBER; ++i) {
			int row = i / 4;
			int column = i % 4;
			int x = column * 195 + 60;
			int y = row * 260 + 75;

			panelTable[i] = new JPanel();
			panelTable[i].setBounds(x, y, 143, 190);
			panelTable[i].setBorder(UIManager.getBorder("DesktopIcon.border"));
			panelTables.add(panelTable[i]);
			panelTable[i].setLayout(new BorderLayout(0, 0));

			panelTableHeader[i] = new JPanel();
			panelTable[i].add(panelTableHeader[i], BorderLayout.NORTH);
			panelTableHeader[i].setLayout(new BorderLayout(0, 0));

			lblTableNum[i] = new JLabel(String.valueOf(i + 1));
			lblTableNum[i].setFont(new Font("굴림", Font.BOLD, 20));
			panelTableHeader[i].add(lblTableNum[i], BorderLayout.NORTH);

			lblTableAdmission[i] = new JLabel("공석");
			lblTableAdmission[i].setFont(new Font("굴림", Font.PLAIN, 13));
			lblTableAdmission[i].setHorizontalAlignment(SwingConstants.RIGHT);
			panelTableHeader[i].add(lblTableAdmission[i], BorderLayout.SOUTH);

			lblTableCno[i] = new JLabel("손님번호");
			lblTableCno[i].setFont(new Font("굴림", Font.PLAIN, 12));
			panelTableHeader[i].add(lblTableCno[i], BorderLayout.WEST);

			lblTableGetCno[i] = new JLabel("");
			lblTableGetCno[i].setFont(new Font("굴림", Font.PLAIN, 12));
			panelTableHeader[i].add(lblTableGetCno[i], BorderLayout.EAST);

			lblTableCharge[i] = new JLabel("0");
			lblTableCharge[i].setFont(new Font("굴림", Font.BOLD, 12));
			lblTableCharge[i].setHorizontalAlignment(SwingConstants.RIGHT);
			panelTable[i].add(lblTableCharge[i], BorderLayout.SOUTH);

			taTableOrderList[i] = new JTextArea();
			panelTable[i].add(taTableOrderList[i], BorderLayout.CENTER);

			tableList.add(panelTable[i]);
		}

		tfChangeNum.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					int num = Integer.valueOf(tfChangeNum.getText());
					for (int i = 0; i < num; ++i) {
						panelTable[i].setVisible(true);
					}
					for (int i = num; i < TABLE_NUMBER; ++i) {
						panelTable[i].setVisible(false);
					}
				}
			}
		});

		init();

		setComponents();

		setFrame();
	}

	private void init() {

	}

	private void setComponents() {

	}

	private void setFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 800);

		setLocationByPlatform(true);

		setVisible(true);

	}

	public static void main(String[] args) {

		new Ex0();

	}
}
