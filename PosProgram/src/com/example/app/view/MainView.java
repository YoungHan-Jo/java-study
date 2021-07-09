package com.example.app.view;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.Calendar;

import javax.swing.JPanel;

import com.example.app.StoreManager;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MainView implements Viewable, Runnable {

	public static final String VIEW_NAME = "main";
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 700;

	private Thread thread;

	private CardLayout cardLayout;
	private Container container;
	private StoreManager frame;
	private JPanel panelMain;
	private JPanel panelHeader;
	private JPanel panelFooter;
	private JPanel panelBody;
	private JLabel lblMainView;
	private JLabel lblCurrentTime;
	private JPanel panelLeft;
	private JPanel panelRight;
	private JPanel panelTables;
	private JPanel panelOrder;
	private JPanel panelTableNum1;
	private JPanel panelTableHeader1;
	private JPanel panel_2;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblTableNum1;
	private JLabel lblTableTime1;
	private JTextArea textArea;
	private JLabel lblNewLabel;
	private JLabel lblAdults;
	private JLabel lblKids;
	private JTextField tfAdults;
	private JTextField tfKids;
	private JButton btnAdmission;
	private JLabel lblSoju;
	private JLabel lblBeer;
	private JTextField tfSoju;
	private JTextField tfBeer;
	private JLabel lblBeverage;
	private JLabel lblSoup;
	private JTextField tfBeverage;
	private JTextField tfSoup;
	private JLabel lblDessert;
	private JTextField tfDessert;
	private JButton btnRenewOrder;
	private JButton btnAdmissionCancel;
	private JButton btnPayment;

	public MainView(CardLayout cardLayout, Container container, StoreManager frame) {
		this.cardLayout = cardLayout;
		this.container = container;
		this.frame = frame;

		init();
		setComponents();
		addListener();
	}

	@Override
	public JPanel getView() {
		return panelMain;
	}

	@Override
	public void run() {
		while (true) {
			Calendar cal = Calendar.getInstance();
			String now = cal.get(Calendar.YEAR) + "년 "
					+ ((cal.get(Calendar.MONTH) + 1) < 10 ? "0" + (cal.get(Calendar.MONTH) + 1)
							: (cal.get(Calendar.MONTH) + 1))
					+ "월 " + (cal.get(Calendar.DATE) < 10 ? "0" + cal.get(Calendar.DATE) : cal.get(Calendar.DATE))
					+ "일 "
					+ (cal.get(Calendar.HOUR_OF_DAY) < 10 ? "0" + cal.get(Calendar.HOUR_OF_DAY)
							: cal.get(Calendar.HOUR_OF_DAY))
					+ "시" + (cal.get(Calendar.MINUTE) < 10 ? "0" + cal.get(Calendar.MINUTE) : cal.get(Calendar.MINUTE))
					+ "분" + (cal.get(Calendar.SECOND) < 10 ? "0" + cal.get(Calendar.SECOND) : cal.get(Calendar.SECOND))
					+ "초 ";
			lblCurrentTime.setText(now);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void init() {
		panelMain = new JPanel();
		panelMain.setSize(WIDTH, HEIGHT);
		panelMain.setLayout(new BorderLayout(0, 0));

		panelHeader = new JPanel();
		panelMain.add(panelHeader, BorderLayout.NORTH);
		panelHeader.setLayout(new BorderLayout(0, 0));

		lblMainView = new JLabel("POS");
		lblMainView.setFont(new Font("굴림", Font.BOLD, 25));
		panelHeader.add(lblMainView, BorderLayout.CENTER);

		lblCurrentTime = new JLabel("");

		panelFooter = new JPanel();
		panelMain.add(panelFooter, BorderLayout.SOUTH);

		panelBody = new JPanel();
		panelMain.add(panelBody, BorderLayout.CENTER);
		panelBody.setLayout(new BorderLayout(0, 0));

		panelLeft = new JPanel();
		panelBody.add(panelLeft, BorderLayout.WEST);
		panelLeft.setLayout(new BorderLayout(0, 0));

		panelTables = new JPanel();
		panelTables.setPreferredSize(new Dimension(900, 250));
		panelLeft.add(panelTables, BorderLayout.CENTER);
		panelTables.setLayout(null);
		
		panelTableNum1 = new JPanel();
		panelTableNum1.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panelTableNum1.setBounds(82, 80, 152, 167);
		panelTables.add(panelTableNum1);
		panelTableNum1.setLayout(new BorderLayout(0, 0));
		
		panelTableHeader1 = new JPanel();
		panelTableNum1.add(panelTableHeader1, BorderLayout.NORTH);
		panelTableHeader1.setLayout(new BorderLayout(0, 0));
		
		lblTableNum1 = new JLabel("테이블 1");
		panelTableHeader1.add(lblTableNum1, BorderLayout.NORTH);
		
		lblTableTime1 = new JLabel("New label ");
		lblTableTime1.setHorizontalAlignment(SwingConstants.TRAILING);
		panelTableHeader1.add(lblTableTime1, BorderLayout.SOUTH);
		
		lblNewLabel_2 = new JLabel("New label ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		panelTableNum1.add(lblNewLabel_2, BorderLayout.SOUTH);
		
		textArea = new JTextArea();
		panelTableNum1.add(textArea, BorderLayout.CENTER);

		panelRight = new JPanel();
		panelBody.add(panelRight, BorderLayout.CENTER);
		panelRight.setLayout(new BorderLayout(0, 0));

		panelOrder = new JPanel();
		panelRight.add(panelOrder, BorderLayout.CENTER);
		panelOrder.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBounds(698, 31, 77, 83);
		panelOrder.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_1 = new JLabel("New label");
		panel_2.add(lblNewLabel_1, BorderLayout.NORTH);
		
		lblNewLabel = new JLabel("테이블 번호");
		lblNewLabel.setBounds(111, 31, 70, 18);
		panelOrder.add(lblNewLabel);
		
		lblAdults = new JLabel("성인");
		lblAdults.setBounds(61, 96, 55, 18);
		panelOrder.add(lblAdults);
		
		lblKids = new JLabel("어린이");
		lblKids.setBounds(61, 126, 55, 18);
		panelOrder.add(lblKids);
		
		tfAdults = new JTextField();
		tfAdults.setBounds(134, 94, 60, 22);
		panelOrder.add(tfAdults);
		tfAdults.setColumns(10);
		
		tfKids = new JTextField();
		tfKids.setColumns(10);
		tfKids.setBounds(134, 124, 60, 22);
		panelOrder.add(tfKids);
		
		btnAdmission = new JButton("입장");
		btnAdmission.setBounds(38, 171, 98, 28);
		panelOrder.add(btnAdmission);
		
		lblSoju = new JLabel("소주");
		lblSoju.setBounds(61, 251, 55, 18);
		panelOrder.add(lblSoju);
		
		lblBeer = new JLabel("맥주");
		lblBeer.setBounds(61, 281, 55, 18);
		panelOrder.add(lblBeer);
		
		tfSoju = new JTextField();
		tfSoju.setColumns(10);
		tfSoju.setBounds(134, 249, 60, 22);
		panelOrder.add(tfSoju);
		
		tfBeer = new JTextField();
		tfBeer.setColumns(10);
		tfBeer.setBounds(134, 279, 60, 22);
		panelOrder.add(tfBeer);
		
		lblBeverage = new JLabel("음료수");
		lblBeverage.setBounds(61, 313, 55, 18);
		panelOrder.add(lblBeverage);
		
		lblSoup = new JLabel("된장찌개");
		lblSoup.setBounds(61, 343, 55, 18);
		panelOrder.add(lblSoup);
		
		tfBeverage = new JTextField();
		tfBeverage.setColumns(10);
		tfBeverage.setBounds(134, 311, 60, 22);
		panelOrder.add(tfBeverage);
		
		tfSoup = new JTextField();
		tfSoup.setColumns(10);
		tfSoup.setBounds(134, 341, 60, 22);
		panelOrder.add(tfSoup);
		
		lblDessert = new JLabel("냉면");
		lblDessert.setBounds(61, 375, 55, 18);
		panelOrder.add(lblDessert);
		
		tfDessert = new JTextField();
		tfDessert.setColumns(10);
		tfDessert.setBounds(134, 373, 60, 22);
		panelOrder.add(tfDessert);
		
		btnRenewOrder = new JButton("주문 갱신");
		btnRenewOrder.setBounds(162, 422, 98, 28);
		panelOrder.add(btnRenewOrder);
		
		btnAdmissionCancel = new JButton("입장 취소");
		btnAdmissionCancel.setBounds(162, 171, 98, 28);
		panelOrder.add(btnAdmissionCancel);
		
		btnPayment = new JButton("결제하기");
		btnPayment.setBounds(162, 512, 98, 28);
		panelOrder.add(btnPayment);
	}

	private void setComponents() {

		setClock();

	}

	private void setClock() {
		lblCurrentTime.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCurrentTime.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCurrentTime.setFont(new Font("굴림", Font.BOLD, 15));
		panelHeader.add(lblCurrentTime, BorderLayout.EAST);
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	private void addListener() {
	}
}
