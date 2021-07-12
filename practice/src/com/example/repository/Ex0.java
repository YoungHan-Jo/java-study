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
	private JPanel[] panelHeader = new JPanel[TABLE_NUMBER];
	private JLabel[] lblCharge = new JLabel[TABLE_NUMBER];
	private JTextArea[] taTable = new JTextArea[TABLE_NUMBER];
	private JLabel[] lblTableNum = new JLabel[TABLE_NUMBER];
	private JLabel[] lblAdmission = new JLabel[TABLE_NUMBER];
	private JLabel[] lblCno = new JLabel[TABLE_NUMBER];
	private JLabel[] lblGetCno = new JLabel[TABLE_NUMBER];

	List<JPanel> tableList = new ArrayList<>();
	private JScrollPane scrollPane;
	private JTextField tfChangeNum;
	private JButton btnChangeNum;

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

		btnChangeNum = new JButton("New button");
		btnChangeNum.setBounds(743, 9, 97, 23);
		panelTables.add(btnChangeNum);

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

			panelHeader[i] = new JPanel();
			panelTable[i].add(panelHeader[i], BorderLayout.NORTH);
			panelHeader[i].setLayout(new BorderLayout(0, 0));

			lblTableNum[i] = new JLabel(String.valueOf(i + 1));
			lblTableNum[i].setFont(new Font("굴림", Font.BOLD, 20));
			panelHeader[i].add(lblTableNum[i], BorderLayout.NORTH);

			lblAdmission[i] = new JLabel("공석");
			lblAdmission[i].setFont(new Font("굴림", Font.PLAIN, 13));
			lblAdmission[i].setHorizontalAlignment(SwingConstants.RIGHT);
			panelHeader[i].add(lblAdmission[i], BorderLayout.SOUTH);

			lblCno[i] = new JLabel("손님번호");
			lblCno[i].setFont(new Font("굴림", Font.PLAIN, 12));
			panelHeader[i].add(lblCno[i], BorderLayout.WEST);

			lblGetCno[i] = new JLabel("");
			lblGetCno[i].setFont(new Font("굴림", Font.PLAIN, 12));
			panelHeader[i].add(lblGetCno[i], BorderLayout.EAST);

			lblCharge[i] = new JLabel("0");
			lblCharge[i].setFont(new Font("굴림", Font.BOLD, 12));
			lblCharge[i].setHorizontalAlignment(SwingConstants.RIGHT);
			panelTable[i].add(lblCharge[i], BorderLayout.SOUTH);

			taTable[i] = new JTextArea();
			panelTable[i].add(taTable[i], BorderLayout.CENTER);

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
