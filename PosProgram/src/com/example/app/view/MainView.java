package com.example.app.view;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.Calendar;

import javax.swing.JPanel;

import com.example.app.StoreManager;
import com.example.domain.CustomerVO;
import com.example.repository.CustomerDAO;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.SwingConstants;

import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.sql.Timestamp;

import javax.swing.JTextArea;

import javax.swing.UIManager;

import java.awt.Color;
import javax.swing.border.MatteBorder;

public class MainView implements Viewable, Runnable {

	CustomerDAO customerDAO = CustomerDAO.getInstance();

	public static final String VIEW_NAME = "main";
	public static final int WIDTH = 1160;
	public static final int HEIGHT = 700;

	public static final int CHARGE_ADULT = 14000;
	public static final int CHARGE_KID = 8000;

	public static final int CHARGE_SOJU = 4000;
	public static final int CHARGE_BEER = 4000;
	public static final int CHARGE_BEVERAGE = 2000;
	public static final int CHARGE_SOUP = 2000;
	public static final int CHARGE_DESSERT = 4000;

	private Thread thread;

	private CardLayout cardLayout;
	private Container container;
	private StoreManager frame;
	private JPanel panelMain;
	private JPanel panelHeader;
	private JPanel panelFooter;
	private JPanel panelBody;
	private JLabel lblMainView;
	private JPanel panelLeft;
	private JPanel panelRight;
	private JPanel panelOrder;
	private JLabel lblUpdateTable;
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
	private JPanel panelTableView;
	private JPanel panelTable1;
	private JPanel panelTableHeader1;
	private JLabel lblCharge1;
	private JLabel lblTable1;
	private JLabel lblAdmission1;
	private JTextArea taTable1;
	private JPanel panelTable2;
	private JPanel panelTableHeader2;
	private JLabel lblCharge2;
	private JTextArea taTable2;
	private JLabel lblTable2;
	private JLabel lblAdmission2;
	private JPanel panelTable3;
	private JPanel panelTable4;
	private JPanel panelTable5;
	private JPanel panelTable6;
	private JPanel panelTable7;
	private JPanel panelTable8;
	private JPanel panelTableHeader3;
	private JPanel panelTableHeader4;
	private JPanel panelTableHeader5;
	private JPanel panelTableHeader6;
	private JPanel panelTableHeader7;
	private JPanel panelTableHeader8;
	private JLabel lblCharge3;
	private JLabel lblCharge4;
	private JLabel lblCharge5;
	private JLabel lblCharge6;
	private JLabel lblCharge7;
	private JLabel lblCharge8;
	private JTextArea taTable3;
	private JTextArea taTable4;
	private JTextArea taTable5;
	private JTextArea taTable6;
	private JTextArea taTable7;
	private JTextArea taTable8;
	private JLabel lblTable3;
	private JLabel lblTable4;
	private JLabel lblTable5;
	private JLabel lblTable6;
	private JLabel lblTable7;
	private JLabel lblTable8;
	private JLabel lblAdmission3;
	private JLabel lblAdmission4;
	private JLabel lblAdmission5;
	private JLabel lblAdmission6;
	private JLabel lblAdmission7;
	private JLabel lblAdmission8;
	private JLabel lblCurrentTime;
	private JButton btnAdultsUp;
	private JButton btnAdultsDown;
	private JButton btnKidsUp;
	private JButton btnSojuUp;
	private JButton btnBeerUp;
	private JButton btnBeverageUp;
	private JButton btnSoupUp;
	private JButton btnDessertUp;
	private JButton btnKidsDown;
	private JButton btnSojuDown;
	private JButton btnBeerDown;
	private JButton btnBeverageDown;
	private JButton btnSoupDown;
	private JButton btnDessertDown;
	private JLabel lblSelectedNum;
	private JLabel lblCno1;
	private JLabel lblGetCno1;
	private JLabel lblCno2;
	private JLabel lblCno3;
	private JLabel lblCno4;
	private JLabel lblCno5;
	private JLabel lblCno6;
	private JLabel lblCno7;
	private JLabel lblCno8;
	private JLabel lblGetCno2;
	private JLabel lblGetCno3;
	private JLabel lblGetCno4;
	private JLabel lblGetCno5;
	private JLabel lblGetCno6;
	private JLabel lblGetCno7;
	private JLabel lblGetCno8;
	private JLabel lblGetCno;
	private JTextField tfGetCno;

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

		panelHeader = new JPanel();
		panelHeader.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		lblMainView = new JLabel("POS");

		panelFooter = new JPanel();
		panelBody = new JPanel();
		panelLeft = new JPanel();

		panelTableView = new JPanel();
		panelTableView.setBackground(Color.WHITE);
		panelTableView.setBorder(new MatteBorder(0, 1, 1, 0, (Color) new Color(0, 0, 0)));

		panelTable1 = new JPanel();
		panelTableHeader1 = new JPanel();
		lblTable1 = new JLabel("1");
		lblAdmission1 = new JLabel("공석");
		lblCharge1 = new JLabel("0 ");
		taTable1 = new JTextArea();

		panelTable2 = new JPanel();
		panelTableHeader2 = new JPanel();
		lblTable2 = new JLabel("2");
		lblAdmission2 = new JLabel("공석");
		lblCharge2 = new JLabel("0 ");
		taTable2 = new JTextArea();

		panelTable3 = new JPanel();
		panelTableHeader3 = new JPanel();
		lblTable3 = new JLabel("3");
		lblAdmission3 = new JLabel("공석");
		lblCharge3 = new JLabel("0 ");
		taTable3 = new JTextArea();

		panelTable4 = new JPanel();
		panelTableHeader4 = new JPanel();
		lblTable4 = new JLabel("4");
		lblAdmission4 = new JLabel("공석");
		lblCharge4 = new JLabel("0 ");
		taTable4 = new JTextArea();

		panelTable5 = new JPanel();
		panelTableHeader5 = new JPanel();
		lblTable5 = new JLabel("5");
		lblAdmission5 = new JLabel("공석");
		lblCharge5 = new JLabel("0 ");
		taTable5 = new JTextArea();

		panelTable6 = new JPanel();
		panelTableHeader6 = new JPanel();
		lblTable6 = new JLabel("6");
		lblAdmission6 = new JLabel("공석");
		lblCharge6 = new JLabel("0 ");
		taTable6 = new JTextArea();

		panelTable7 = new JPanel();
		lblAdmission7 = new JLabel("공석");
		lblCharge7 = new JLabel("0 ");
		taTable7 = new JTextArea();
		panelTableHeader7 = new JPanel();
		lblTable7 = new JLabel("7");

		panelTable8 = new JPanel();
		panelTableHeader8 = new JPanel();
		lblTable8 = new JLabel("8");
		lblAdmission8 = new JLabel("공석");
		lblCharge8 = new JLabel("0 ");
		taTable8 = new JTextArea();

		panelRight = new JPanel();
		panelOrder = new JPanel();
		panelOrder.setBorder(new MatteBorder(0, 1, 1, 0, (Color) new Color(0, 0, 0)));
		lblUpdateTable = new JLabel("번 테이블");
		lblUpdateTable.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateTable.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAdults = new JLabel("성인");
		lblKids = new JLabel("어린이");
		tfAdults = new JTextField();
		tfAdults.setHorizontalAlignment(SwingConstants.TRAILING);
		tfAdults.setText("0");
		tfKids = new JTextField();
		tfKids.setHorizontalAlignment(SwingConstants.TRAILING);
		tfKids.setText("0");
		btnAdmission = new JButton("입장");
		lblSoju = new JLabel("소주");
		lblBeer = new JLabel("맥주");
		tfSoju = new JTextField();
		tfSoju.setText("0");
		tfSoju.setHorizontalAlignment(SwingConstants.TRAILING);
		tfBeer = new JTextField();
		tfBeer.setText("0");
		tfBeer.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBeverage = new JLabel("음료수");
		lblSoup = new JLabel("된장찌개");
		tfBeverage = new JTextField();
		tfBeverage.setText("0");
		tfBeverage.setHorizontalAlignment(SwingConstants.TRAILING);
		tfSoup = new JTextField();
		tfSoup.setText("0");
		tfSoup.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDessert = new JLabel("냉면");
		tfDessert = new JTextField();
		tfDessert.setText("0");
		tfDessert.setHorizontalAlignment(SwingConstants.TRAILING);
		btnRenewOrder = new JButton("주문 갱신");
		btnAdmissionCancel = new JButton("입장 취소");
		btnPayment = new JButton("결제하기");

	}

	private void setComponents() {

		setClock();
		clearTableBorder();

		panelMain.setSize(WIDTH, HEIGHT);
		panelMain.setLayout(new BorderLayout(0, 0));
		panelMain.add(panelHeader, BorderLayout.NORTH);
		panelMain.add(panelFooter, BorderLayout.SOUTH);
		panelMain.add(panelBody, BorderLayout.CENTER);

		panelHeader.setLayout(new BorderLayout(0, 0));
		lblMainView.setFont(new Font("굴림", Font.BOLD, 25));
		panelHeader.add(lblMainView, BorderLayout.CENTER);

		lblCurrentTime = new JLabel("");
		lblCurrentTime.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCurrentTime.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCurrentTime.setFont(new Font("굴림", Font.BOLD, 15));
		panelHeader.add(lblCurrentTime, BorderLayout.EAST);

		panelBody.setLayout(new BorderLayout(0, 0));
		panelBody.add(panelLeft, BorderLayout.WEST);
		panelLeft.setLayout(new BorderLayout(0, 0));
		panelLeft.add(panelTableView);
		panelTableView.setPreferredSize(new Dimension(850, 300));
		panelTableView.setLayout(null);

		panelTable1.setBounds(61, 76, 143, 190);
		panelTableView.add(panelTable1);
		panelTable1.setLayout(new BorderLayout(0, 0));
		panelTable1.add(panelTableHeader1, BorderLayout.NORTH);
		panelTableHeader1.setLayout(new BorderLayout(0, 0));
		lblTable1.setFont(new Font("굴림", Font.BOLD, 20));
		panelTableHeader1.add(lblTable1, BorderLayout.NORTH);
		lblAdmission1.setFont(new Font("굴림", Font.PLAIN, 13));
		lblAdmission1.setHorizontalAlignment(SwingConstants.TRAILING);
		panelTableHeader1.add(lblAdmission1, BorderLayout.SOUTH);

		lblCno1 = new JLabel("손님번호");
		lblCno1.setFont(new Font("굴림", Font.PLAIN, 12));
		panelTableHeader1.add(lblCno1, BorderLayout.WEST);

		lblGetCno1 = new JLabel("");
		lblGetCno1.setFont(new Font("굴림", Font.PLAIN, 12));
		lblGetCno1.setHorizontalAlignment(SwingConstants.CENTER);
		panelTableHeader1.add(lblGetCno1, BorderLayout.CENTER);
		lblCharge1.setFont(new Font("굴림", Font.BOLD, 12));
		lblCharge1.setHorizontalAlignment(SwingConstants.TRAILING);
		panelTable1.add(lblCharge1, BorderLayout.SOUTH);
		panelTable1.add(taTable1, BorderLayout.CENTER);

		panelTable2.setBounds(256, 76, 143, 190);
		panelTableView.add(panelTable2);
		panelTable2.setLayout(new BorderLayout(0, 0));
		panelTable2.add(panelTableHeader2, BorderLayout.NORTH);
		panelTableHeader2.setLayout(new BorderLayout(0, 0));
		lblTable2.setFont(new Font("굴림", Font.BOLD, 20));
		panelTableHeader2.add(lblTable2, BorderLayout.NORTH);
		lblAdmission2.setFont(new Font("굴림", Font.PLAIN, 13));
		lblAdmission2.setHorizontalAlignment(SwingConstants.TRAILING);
		panelTableHeader2.add(lblAdmission2, BorderLayout.SOUTH);

		lblCno2 = new JLabel("손님번호");
		lblCno2.setFont(new Font("굴림", Font.PLAIN, 12));
		panelTableHeader2.add(lblCno2, BorderLayout.WEST);

		lblGetCno2 = new JLabel("");
		lblGetCno2.setHorizontalAlignment(SwingConstants.CENTER);
		lblGetCno2.setFont(new Font("굴림", Font.PLAIN, 12));
		panelTableHeader2.add(lblGetCno2, BorderLayout.CENTER);
		lblCharge2.setFont(new Font("굴림", Font.BOLD, 12));
		lblCharge2.setHorizontalAlignment(SwingConstants.TRAILING);
		panelTable2.add(lblCharge2, BorderLayout.SOUTH);
		panelTable2.add(taTable2, BorderLayout.CENTER);

		panelTable3.setBounds(444, 76, 143, 190);
		panelTableView.add(panelTable3);
		panelTable3.setLayout(new BorderLayout(0, 0));
		panelTable3.add(panelTableHeader3, BorderLayout.NORTH);
		panelTableHeader3.setLayout(new BorderLayout(0, 0));
		lblTable3.setFont(new Font("굴림", Font.BOLD, 20));
		panelTableHeader3.add(lblTable3, BorderLayout.NORTH);
		lblAdmission3.setFont(new Font("굴림", Font.PLAIN, 13));
		lblAdmission3.setHorizontalAlignment(SwingConstants.TRAILING);
		panelTableHeader3.add(lblAdmission3, BorderLayout.SOUTH);

		lblCno3 = new JLabel("손님번호");
		lblCno3.setFont(new Font("굴림", Font.PLAIN, 12));
		panelTableHeader3.add(lblCno3, BorderLayout.WEST);

		lblGetCno3 = new JLabel("");
		lblGetCno3.setHorizontalAlignment(SwingConstants.CENTER);
		lblGetCno3.setFont(new Font("굴림", Font.PLAIN, 12));
		panelTableHeader3.add(lblGetCno3, BorderLayout.CENTER);
		lblCharge3.setFont(new Font("굴림", Font.BOLD, 12));
		lblCharge3.setHorizontalAlignment(SwingConstants.TRAILING);
		panelTable3.add(lblCharge3, BorderLayout.SOUTH);
		panelTable3.add(taTable3, BorderLayout.CENTER);

		panelTable4.setBounds(640, 76, 143, 190);
		panelTableView.add(panelTable4);
		panelTable4.setLayout(new BorderLayout(0, 0));
		panelTable4.add(panelTableHeader4, BorderLayout.NORTH);
		panelTableHeader4.setLayout(new BorderLayout(0, 0));
		lblTable4.setFont(new Font("굴림", Font.BOLD, 20));
		panelTableHeader4.add(lblTable4, BorderLayout.NORTH);
		lblAdmission4.setFont(new Font("굴림", Font.PLAIN, 13));
		lblAdmission4.setHorizontalAlignment(SwingConstants.TRAILING);
		panelTableHeader4.add(lblAdmission4, BorderLayout.SOUTH);

		lblCno4 = new JLabel("손님번호");
		lblCno4.setFont(new Font("굴림", Font.PLAIN, 12));
		panelTableHeader4.add(lblCno4, BorderLayout.WEST);

		lblGetCno4 = new JLabel("");
		lblGetCno4.setHorizontalAlignment(SwingConstants.CENTER);
		lblGetCno4.setFont(new Font("굴림", Font.PLAIN, 12));
		panelTableHeader4.add(lblGetCno4, BorderLayout.CENTER);
		lblCharge4.setFont(new Font("굴림", Font.BOLD, 12));
		lblCharge4.setHorizontalAlignment(SwingConstants.TRAILING);
		panelTable4.add(lblCharge4, BorderLayout.SOUTH);
		panelTable4.add(taTable4, BorderLayout.CENTER);

		panelTable5.setBounds(61, 338, 143, 190);
		panelTableView.add(panelTable5);
		panelTable5.setLayout(new BorderLayout(0, 0));
		panelTable5.add(panelTableHeader5, BorderLayout.NORTH);
		panelTableHeader5.setLayout(new BorderLayout(0, 0));
		lblTable5.setFont(new Font("굴림", Font.BOLD, 20));
		panelTableHeader5.add(lblTable5, BorderLayout.NORTH);
		lblAdmission5.setFont(new Font("굴림", Font.PLAIN, 13));
		lblAdmission5.setHorizontalAlignment(SwingConstants.TRAILING);
		panelTableHeader5.add(lblAdmission5, BorderLayout.SOUTH);

		lblCno5 = new JLabel("손님번호");
		lblCno5.setFont(new Font("굴림", Font.PLAIN, 12));
		panelTableHeader5.add(lblCno5, BorderLayout.WEST);

		lblGetCno5 = new JLabel("");
		lblGetCno5.setHorizontalAlignment(SwingConstants.CENTER);
		lblGetCno5.setFont(new Font("굴림", Font.PLAIN, 12));
		panelTableHeader5.add(lblGetCno5, BorderLayout.CENTER);
		lblCharge5.setFont(new Font("굴림", Font.BOLD, 12));
		lblCharge5.setHorizontalAlignment(SwingConstants.TRAILING);
		panelTable5.add(lblCharge5, BorderLayout.SOUTH);

		panelTable5.add(taTable5, BorderLayout.CENTER);

		panelTable6.setBounds(256, 338, 143, 190);
		panelTableView.add(panelTable6);
		panelTable6.setLayout(new BorderLayout(0, 0));
		panelTable6.add(panelTableHeader6, BorderLayout.NORTH);
		panelTableHeader6.setLayout(new BorderLayout(0, 0));
		lblTable6.setFont(new Font("굴림", Font.BOLD, 20));
		panelTableHeader6.add(lblTable6, BorderLayout.NORTH);
		lblAdmission6.setFont(new Font("굴림", Font.PLAIN, 13));
		lblAdmission6.setHorizontalAlignment(SwingConstants.TRAILING);
		panelTableHeader6.add(lblAdmission6, BorderLayout.SOUTH);

		lblCno6 = new JLabel("손님번호");
		lblCno6.setFont(new Font("굴림", Font.PLAIN, 12));
		panelTableHeader6.add(lblCno6, BorderLayout.WEST);

		lblGetCno6 = new JLabel("");
		lblGetCno6.setHorizontalAlignment(SwingConstants.CENTER);
		lblGetCno6.setFont(new Font("굴림", Font.PLAIN, 12));
		panelTableHeader6.add(lblGetCno6, BorderLayout.CENTER);
		lblCharge6.setFont(new Font("굴림", Font.BOLD, 12));
		lblCharge6.setHorizontalAlignment(SwingConstants.TRAILING);
		panelTable6.add(lblCharge6, BorderLayout.SOUTH);

		panelTable6.add(taTable6, BorderLayout.CENTER);

		panelTable7.setBounds(444, 338, 143, 190);
		panelTableView.add(panelTable7);
		panelTable7.setLayout(new BorderLayout(0, 0));
		panelTable7.add(panelTableHeader7, BorderLayout.NORTH);
		panelTableHeader7.setLayout(new BorderLayout(0, 0));
		lblTable7.setFont(new Font("굴림", Font.BOLD, 20));
		panelTableHeader7.add(lblTable7, BorderLayout.NORTH);
		lblAdmission7.setFont(new Font("굴림", Font.PLAIN, 13));
		lblAdmission7.setHorizontalAlignment(SwingConstants.TRAILING);
		panelTableHeader7.add(lblAdmission7, BorderLayout.SOUTH);

		lblCno7 = new JLabel("손님번호");
		lblCno7.setFont(new Font("굴림", Font.PLAIN, 12));
		panelTableHeader7.add(lblCno7, BorderLayout.WEST);

		lblGetCno7 = new JLabel("");
		lblGetCno7.setHorizontalAlignment(SwingConstants.CENTER);
		lblGetCno7.setFont(new Font("굴림", Font.PLAIN, 12));
		panelTableHeader7.add(lblGetCno7, BorderLayout.CENTER);
		lblCharge7.setFont(new Font("굴림", Font.BOLD, 12));
		lblCharge7.setHorizontalAlignment(SwingConstants.TRAILING);
		panelTable7.add(lblCharge7, BorderLayout.SOUTH);
		panelTable7.add(taTable7, BorderLayout.CENTER);

		panelTable8.setBounds(640, 338, 143, 190);
		panelTableView.add(panelTable8);
		panelTable8.setLayout(new BorderLayout(0, 0));
		panelTable8.add(panelTableHeader8, BorderLayout.NORTH);
		panelTableHeader8.setLayout(new BorderLayout(0, 0));
		lblTable8.setFont(new Font("굴림", Font.BOLD, 20));
		panelTableHeader8.add(lblTable8, BorderLayout.NORTH);
		lblAdmission8.setFont(new Font("굴림", Font.PLAIN, 13));
		lblAdmission8.setHorizontalAlignment(SwingConstants.TRAILING);
		panelTableHeader8.add(lblAdmission8, BorderLayout.SOUTH);

		lblCno8 = new JLabel("손님번호");
		lblCno8.setFont(new Font("굴림", Font.PLAIN, 12));
		panelTableHeader8.add(lblCno8, BorderLayout.WEST);

		lblGetCno8 = new JLabel("");
		lblGetCno8.setHorizontalAlignment(SwingConstants.CENTER);
		lblGetCno8.setFont(new Font("굴림", Font.PLAIN, 12));
		panelTableHeader8.add(lblGetCno8, BorderLayout.CENTER);
		lblCharge8.setFont(new Font("굴림", Font.BOLD, 12));
		lblCharge8.setHorizontalAlignment(SwingConstants.TRAILING);
		panelTable8.add(lblCharge8, BorderLayout.SOUTH);
		panelTable8.add(taTable8, BorderLayout.CENTER);

		panelBody.add(panelRight, BorderLayout.CENTER);
		panelRight.setLayout(new BorderLayout(0, 0));
		panelRight.add(panelOrder, BorderLayout.CENTER);
		panelOrder.setLayout(null);
		lblUpdateTable.setBounds(132, 31, 98, 28);
		panelOrder.add(lblUpdateTable);
		lblAdults.setBounds(61, 96, 55, 18);
		panelOrder.add(lblAdults);
		lblKids.setBounds(61, 126, 55, 18);
		panelOrder.add(lblKids);
		tfAdults.setBounds(134, 94, 44, 22);
		panelOrder.add(tfAdults);
		tfAdults.setColumns(10);
		tfKids.setColumns(10);
		tfKids.setBounds(134, 124, 44, 22);
		panelOrder.add(tfKids);
		btnAdmission.setBounds(38, 171, 98, 28);
		panelOrder.add(btnAdmission);
		lblSoju.setBounds(61, 251, 55, 18);
		panelOrder.add(lblSoju);
		lblBeer.setBounds(61, 286, 55, 18);
		panelOrder.add(lblBeer);
		tfSoju.setColumns(10);
		tfSoju.setBounds(134, 249, 44, 22);
		panelOrder.add(tfSoju);
		tfBeer.setColumns(10);
		tfBeer.setBounds(134, 284, 44, 22);
		panelOrder.add(tfBeer);
		lblBeverage.setBounds(61, 319, 55, 18);
		panelOrder.add(lblBeverage);
		lblSoup.setBounds(61, 351, 55, 18);
		panelOrder.add(lblSoup);
		tfBeverage.setColumns(10);
		tfBeverage.setBounds(134, 317, 44, 22);
		panelOrder.add(tfBeverage);
		tfSoup.setColumns(10);
		tfSoup.setBounds(134, 349, 44, 22);
		panelOrder.add(tfSoup);
		lblDessert.setBounds(61, 384, 55, 18);
		panelOrder.add(lblDessert);
		tfDessert.setColumns(10);
		tfDessert.setBounds(134, 382, 44, 22);
		panelOrder.add(tfDessert);
		btnRenewOrder.setBounds(162, 422, 98, 28);
		panelOrder.add(btnRenewOrder);
		btnAdmissionCancel.setBounds(162, 171, 98, 28);
		panelOrder.add(btnAdmissionCancel);
		btnPayment.setBounds(162, 512, 98, 28);
		panelOrder.add(btnPayment);

		btnAdultsUp = new JButton("🔺");
		btnAdultsUp.setBounds(190, 94, 44, 23);
		panelOrder.add(btnAdultsUp);

		btnAdultsDown = new JButton("🔻");
		btnAdultsDown.setBounds(237, 94, 44, 23);
		panelOrder.add(btnAdultsDown);

		btnKidsUp = new JButton("🔺");
		btnKidsUp.setBounds(190, 123, 44, 23);
		panelOrder.add(btnKidsUp);

		btnSojuUp = new JButton("🔺");
		btnSojuUp.setBounds(190, 248, 44, 23);
		panelOrder.add(btnSojuUp);

		btnBeerUp = new JButton("🔺");
		btnBeerUp.setBounds(190, 281, 44, 23);
		panelOrder.add(btnBeerUp);

		btnBeverageUp = new JButton("🔺");
		btnBeverageUp.setBounds(190, 316, 44, 23);
		panelOrder.add(btnBeverageUp);

		btnSoupUp = new JButton("🔺");
		btnSoupUp.setBounds(190, 349, 44, 23);
		panelOrder.add(btnSoupUp);

		btnDessertUp = new JButton("🔺");
		btnDessertUp.setBounds(190, 381, 44, 23);
		panelOrder.add(btnDessertUp);

		btnKidsDown = new JButton("🔻");
		btnKidsDown.setBounds(237, 123, 44, 23);
		panelOrder.add(btnKidsDown);

		btnSojuDown = new JButton("🔻");
		btnSojuDown.setBounds(237, 248, 44, 23);
		panelOrder.add(btnSojuDown);

		btnBeerDown = new JButton("🔻");
		btnBeerDown.setBounds(237, 281, 44, 23);
		panelOrder.add(btnBeerDown);

		btnBeverageDown = new JButton("🔻");
		btnBeverageDown.setBounds(237, 316, 44, 23);
		panelOrder.add(btnBeverageDown);

		btnSoupDown = new JButton("🔻");
		btnSoupDown.setBounds(237, 349, 44, 23);
		panelOrder.add(btnSoupDown);

		btnDessertDown = new JButton("🔻");
		btnDessertDown.setBounds(237, 381, 44, 23);
		panelOrder.add(btnDessertDown);

		lblSelectedNum = new JLabel("");
		lblSelectedNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectedNum.setFont(new Font("Dialog", Font.BOLD, 20));
		lblSelectedNum.setBounds(88, 31, 32, 28);
		panelOrder.add(lblSelectedNum);

		lblGetCno = new JLabel("손님번호");
		lblGetCno.setBounds(61, 66, 55, 18);
		panelOrder.add(lblGetCno);

		tfGetCno = new JTextField();
		tfGetCno.setText("");
		tfGetCno.setEnabled(false);
		tfGetCno.setHorizontalAlignment(SwingConstants.TRAILING);
		tfGetCno.setColumns(10);
		tfGetCno.setBounds(134, 64, 44, 22);
		panelOrder.add(tfGetCno);

		taTable1.setEnabled(false);
		taTable2.setEnabled(false);
		taTable3.setEnabled(false);
		taTable4.setEnabled(false);
		taTable5.setEnabled(false);
		taTable6.setEnabled(false);
		taTable7.setEnabled(false);
		taTable8.setEnabled(false);

	}

	private void clearTableBorder() {
		panelTable1.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panelTable2.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panelTable3.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panelTable4.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panelTable5.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panelTable6.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panelTable7.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panelTable8.setBorder(UIManager.getBorder("DesktopIcon.border"));
	}

	private void setClock() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	private void addListener() {

		setBtnUpDownListener();

		selectTableListener();

		clickAdmissionListener();

		btnAdmissionCancel.addActionListener(e -> {
			String cno = tfGetCno.getText();

			if (cno.equals("")) {
				JOptionPane.showMessageDialog(btnAdmissionCancel, "이미 공석입니다", "Message",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				int result = JOptionPane.showConfirmDialog(btnAdmissionCancel, "입장취소 하겠습니까?", "Confirm",
						JOptionPane.YES_NO_OPTION);

				if (result == JOptionPane.YES_OPTION) {
					customerDAO.deleteCustomerByCno(cno);
					clearTable();
					clearOrderBoard();
				} else
					return;
			}

		});

	}// end of addListener

	private void clearOrderBoard() {
		tfGetCno.setText("");
		tfAdults.setText("0");
		tfKids.setText("0");
		btnAdmission.setEnabled(true);
		tfSoju.setText("0");
		tfBeer.setText("0");
		tfBeverage.setText("0");
		tfSoup.setText("0");
		tfDessert.setText("0");

	}

	private void clearTable() {
		String num = lblSelectedNum.getText();

		switch (num) {
		case "1":
			lblGetCno1.setText("");
			lblAdmission1.setText("공석");
			lblAdmission1.setForeground(Color.black);
			taTable1.setText("");
			lblCharge1.setText("0");
			lblCharge1.setForeground(Color.black);
			break;
		case "2":
			lblGetCno2.setText("");
			lblAdmission2.setText("공석");
			lblAdmission2.setForeground(Color.black);
			taTable2.setText("");
			lblCharge2.setText("0");
			lblCharge2.setForeground(Color.black);
			break;
		}
	}

	private void clickAdmissionListener() {
		btnAdmission.addActionListener(e -> {
			String adult = tfAdults.getText();
			String kid = tfKids.getText();
			String tableNum = lblSelectedNum.getText();
			String currentTime = String.valueOf(new Timestamp(System.currentTimeMillis()));
			String admission;
			String cno;
			String ta = "성인 \t" + adult + "명\n" + "어린이\t" + kid + "명\n";

			CustomerVO customerVO = new CustomerVO();
			customerVO.setAdult(Integer.parseInt(adult));
			customerVO.setKid(Integer.parseInt(kid));
			customerVO.setAdmission(currentTime);
			customerVO.setTableNum(tableNum);

			if (lblSelectedNum.getText().equals("")) {
				JOptionPane.showMessageDialog(btnAdmission, "테이블을 선택해주세요", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				customerDAO.insertCustomer(customerVO);
				btnAdmission.setEnabled(false);
			}
			admission = customerVO.getAdmission();

			cno = customerDAO.getCnoByAdmission(admission);

			tfGetCno.setText(cno);

			int charge = Integer.parseInt(adult) * CHARGE_ADULT + Integer.parseInt(kid) * CHARGE_KID;

			switch (tableNum) {
			case "1":
				lblGetCno1.setText(cno);
				lblAdmission1.setText(String.valueOf(new Time(System.currentTimeMillis())));
				lblAdmission1.setForeground(Color.blue);
				taTable1.setText(ta);
				lblCharge1.setText(String.valueOf(charge));
				lblCharge1.setForeground(Color.red);
				break;
			case "2":
				lblGetCno2.setText(cno);
				lblAdmission2.setText(String.valueOf(new Time(System.currentTimeMillis())));
				lblAdmission2.setForeground(Color.blue);
				taTable2.setText(ta);
				lblCharge2.setText(String.valueOf(charge));
				lblCharge2.setForeground(Color.red);
				break;
			}

		});
	}// clickAdmissionListener

	private void selectTableListener() {
		taTable1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearTableBorder();
				ifSelectEmptyTable(lblAdmission1);
				panelTable1.setBorder(BorderFactory.createLineBorder(Color.red, 3));
				lblSelectedNum.setText("1");

				ifSelectTableAgain(lblGetCno1);

			}

		});

		taTable2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearTableBorder();
				ifSelectEmptyTable(lblAdmission2);
				panelTable2.setBorder(BorderFactory.createLineBorder(Color.red, 3));
				lblSelectedNum.setText("2");

				ifSelectTableAgain(lblGetCno2);
			}
		});
	}// selectTableListener

	private void ifSelectTableAgain(JLabel lblGetCno) {
		int adult;
		int kid;

		if (lblGetCno.getText().equals("")) {
			btnAdmission.setEnabled(true);
		} else {
			tfGetCno.setText(lblGetCno.getText());
			adult = customerDAO.getAdultByCno(tfGetCno.getText());
			tfAdults.setText(String.valueOf(adult));
			kid = customerDAO.getKidByCno(tfGetCno.getText());
			tfKids.setText(String.valueOf(kid));
			btnAdmission.setEnabled(false);
		}
	}

	private void ifSelectEmptyTable(JLabel lblAdmission) {
		if (lblAdmission.getText().equals("공석")) {
			btnAdmission.setEnabled(true);
			tfGetCno.setText("");
			tfAdults.setText("0");
			tfKids.setText("0");
		} else
			return;
	}

	private void setBtnUpDownListener() {
		btnAdultsUp.addActionListener(e -> {
			int num = Integer.parseInt(tfAdults.getText());
			num += 1;
			tfAdults.setText(String.valueOf(num));
		});
		btnAdultsDown.addActionListener(e -> {
			int num = Integer.parseInt(tfAdults.getText());
			if (num > 0) {
				num -= 1;
				tfAdults.setText(String.valueOf(num));
			} else
				return;
		});
		btnKidsUp.addActionListener(e -> {
			int num = Integer.parseInt(tfKids.getText());
			num += 1;
			tfKids.setText(String.valueOf(num));
		});
		btnKidsDown.addActionListener(e -> {
			int num = Integer.parseInt(tfKids.getText());
			if (num > 0) {
				num -= 1;
				tfKids.setText(String.valueOf(num));
			} else
				return;
		});
	}
}
