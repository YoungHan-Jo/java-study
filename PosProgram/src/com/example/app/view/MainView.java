package com.example.app.view;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.example.app.StoreManager;
import com.example.domain.CustomerVO;
import com.example.domain.OrderListVO;
import com.example.domain.ShareData;
import com.example.repository.CustomerDAO;
import com.example.repository.OrderListDAO;

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
import java.awt.Component;

import javax.swing.border.MatteBorder;

public class MainView implements Viewable {

	CustomerDAO customerDAO = CustomerDAO.getInstance();
	OrderListDAO orderListDAO = OrderListDAO.getInstance();

	public static final String VIEW_NAME = "main";
	public static final int PANEL_LEFT_WIDTH = 1080;
	public static final int PANEL_LEFT_HEIGHT = 1200;

	public static final int CHARGE_ADULT = 14000;
	public static final int CHARGE_KID = 8000;

	public static final int CHARGE_SOJU = 4000;
	public static final int CHARGE_BEER = 4000;
	public static final int CHARGE_BEVERAGE = 2000;
	public static final int CHARGE_SOUP = 2000;
	public static final int CHARGE_DESSERT = 4000;

	public static final int TABLE_NUMBER = 20;

	private CardLayout cardLayout;
	private Container container;
	private StoreManager frame;

	private JPanel panelMainView;

	private JPanel panelLeft;
	private JPanel panelRight;

	private JScrollPane scrollPane;
	private JPanel panelTables;

	private JPanel[] panelTable = new JPanel[TABLE_NUMBER];
	private JPanel[] panelTableHeader = new JPanel[TABLE_NUMBER];
	private JLabel[] lblTableCharge = new JLabel[TABLE_NUMBER];
	private JTextArea[] taTableOrderList = new JTextArea[TABLE_NUMBER];
	private JLabel[] lblTableNum = new JLabel[TABLE_NUMBER];
	private JLabel[] lblTableAdmission = new JLabel[TABLE_NUMBER];
	private JLabel[] lblTableCno = new JLabel[TABLE_NUMBER];
	private JLabel[] lblTableGetCno = new JLabel[TABLE_NUMBER];

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
	private JButton btnOrder;
	private JButton btnAdmissionCancel;
	private JButton btnPayment;

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

	private JLabel lblGetCno;
	private JTextField tfGetCno;
	private JButton btnOrderCancel;

	private JLabel lblNumOfTables;
	private JLabel lblGetNumOfTables;
	private JButton btnTableUp;
	private JButton btnTableDown;

	List<JPanel> tableList = new ArrayList<>();

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
		return panelMainView;
	}

	private void init() {

		panelMainView = new JPanel();
		panelLeft = new JPanel();

		scrollPane = new JScrollPane();

		panelTables = new JPanel();

		lblNumOfTables = new JLabel("????????? ???");
		lblGetNumOfTables = new JLabel(String.valueOf(TABLE_NUMBER));
		btnTableUp = new JButton("????");
		btnTableDown = new JButton("????");

		for (int i = 0; i < TABLE_NUMBER; ++i) {
			int row = i / 5;
			int column = i % 5;
			int x = column * 195 + 60;
			int y = row * 260 + 75;

			panelTable[i] = new JPanel();
			panelTable[i].setBounds(x, y, 143, 190);
			panelTable[i].setBorder(UIManager.getBorder("DesktopIcon.border"));
			panelTables.add(panelTable[i]);
			panelTable[i].setLayout(new BorderLayout(0, 0));

			panelTableHeader[i] = new JPanel();
			panelTableHeader[i].setName("panelHeader");
			panelTable[i].add(panelTableHeader[i], BorderLayout.NORTH);
			panelTableHeader[i].setLayout(new BorderLayout(0, 0));

			lblTableNum[i] = new JLabel(String.valueOf(i + 1));
			lblTableNum[i].setName("lblTableNum");
			lblTableNum[i].setFont(new Font("??????", Font.BOLD, 20));
			panelTableHeader[i].add(lblTableNum[i], BorderLayout.NORTH);

			lblTableAdmission[i] = new JLabel("??????");
			lblTableAdmission[i].setName("lblTableAdmission"); // ??????????????? ?????? ??????
			lblTableAdmission[i].setFont(new Font("??????", Font.PLAIN, 13));
			lblTableAdmission[i].setHorizontalAlignment(SwingConstants.RIGHT);
			panelTableHeader[i].add(lblTableAdmission[i], BorderLayout.SOUTH);

			lblTableCno[i] = new JLabel("????????????");
			lblTableCno[i].setFont(new Font("??????", Font.PLAIN, 12));
			panelTableHeader[i].add(lblTableCno[i], BorderLayout.WEST);

			lblTableGetCno[i] = new JLabel("");
			lblTableGetCno[i].setName("lblTableGetCno");
			lblTableGetCno[i].setFont(new Font("??????", Font.PLAIN, 12));
			panelTableHeader[i].add(lblTableGetCno[i], BorderLayout.EAST);

			lblTableCharge[i] = new JLabel("0");
			lblTableCharge[i].setFont(new Font("??????", Font.BOLD, 12));
			lblTableCharge[i].setHorizontalAlignment(SwingConstants.RIGHT);
			panelTable[i].add(lblTableCharge[i], BorderLayout.SOUTH);

			taTableOrderList[i] = new JTextArea();
			panelTable[i].add(taTableOrderList[i], BorderLayout.CENTER);

			tableList.add(panelTable[i]);
		}

		panelRight = new JPanel();
		panelOrder = new JPanel();
		lblUpdateTable = new JLabel("??? ?????????");
		lblAdults = new JLabel("??????");
		lblKids = new JLabel("?????????");
		tfAdults = new JTextField();
		tfKids = new JTextField();
		btnAdmission = new JButton("??????");
		lblSoju = new JLabel("??????");
		lblBeer = new JLabel("??????");
		tfSoju = new JTextField();
		tfBeer = new JTextField();
		lblBeverage = new JLabel("?????????");
		lblSoup = new JLabel("????????????");
		tfBeverage = new JTextField();
		tfSoup = new JTextField();
		lblDessert = new JLabel("??????");
		tfDessert = new JTextField();
		btnOrder = new JButton("??????");
		btnAdmissionCancel = new JButton("?????? ??????");
		btnPayment = new JButton("????????????");

		btnAdultsUp = new JButton("????");
		btnAdultsDown = new JButton("????");
		btnKidsUp = new JButton("????");
		btnSojuUp = new JButton("????");
		btnBeerUp = new JButton("????");
		btnBeverageUp = new JButton("????");
		btnSoupUp = new JButton("????");
		btnDessertUp = new JButton("????");
		btnKidsDown = new JButton("????");
		btnSojuDown = new JButton("????");
		btnBeerDown = new JButton("????");
		btnBeverageDown = new JButton("????");
		btnSoupDown = new JButton("????");
		btnDessertDown = new JButton("????");
		lblSelectedNum = new JLabel("");
		lblGetCno = new JLabel("????????????");
		tfGetCno = new JTextField();
		btnOrderCancel = new JButton("?????? ??????");
	}

	private void setComponents() {

		clearTableBorder();

		scrollPane.setBounds(0, 0, 850, 630);
		scrollPane.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		panelTables.setPreferredSize(new Dimension(PANEL_LEFT_WIDTH, PANEL_LEFT_HEIGHT));
		panelTables.setBackground(Color.white);
		scrollPane.setViewportView(panelTables);
		panelTables.setLayout(null);

		panelMainView.setLayout(new BorderLayout(0, 0));
		panelMainView.add(panelLeft, BorderLayout.WEST);
		panelLeft.setLayout(new BorderLayout(0, 0));
		panelLeft.add(scrollPane);

		lblNumOfTables.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNumOfTables.setBounds(12, 12, 92, 18);
		panelTables.add(lblNumOfTables);

		btnTableUp.setBounds(189, 7, 44, 28);
		panelTables.add(btnTableUp);

		btnTableDown.setBounds(245, 7, 44, 28);
		panelTables.add(btnTableDown);

		lblGetNumOfTables.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGetNumOfTables.setFont(new Font("Dialog", Font.BOLD, 20));
		lblGetNumOfTables.setBounds(116, 12, 55, 18);
		panelTables.add(lblGetNumOfTables);

		panelMainView.add(panelRight, BorderLayout.CENTER);
		panelRight.setLayout(new BorderLayout(0, 0));
		panelRight.add(panelOrder, BorderLayout.CENTER);
		panelOrder.setLayout(null);
		lblUpdateTable.setBounds(132, 31, 98, 28);
		panelOrder.add(lblUpdateTable);
		lblAdults.setBounds(40, 95, 55, 18);
		panelOrder.add(lblAdults);
		lblKids.setBounds(40, 125, 55, 18);
		panelOrder.add(lblKids);
		tfAdults.setBounds(113, 93, 44, 22);
		panelOrder.add(tfAdults);
		tfAdults.setColumns(10);
		tfKids.setColumns(10);
		tfKids.setBounds(113, 123, 44, 22);
		panelOrder.add(tfKids);
		btnAdmission.setBounds(38, 171, 98, 28);
		panelOrder.add(btnAdmission);
		lblSoju.setBounds(40, 250, 55, 18);
		panelOrder.add(lblSoju);
		lblBeer.setBounds(40, 285, 55, 18);
		panelOrder.add(lblBeer);
		tfSoju.setColumns(10);
		tfSoju.setBounds(113, 248, 44, 22);
		panelOrder.add(tfSoju);
		tfBeer.setColumns(10);
		tfBeer.setBounds(113, 283, 44, 22);
		panelOrder.add(tfBeer);
		lblBeverage.setBounds(40, 318, 55, 18);
		panelOrder.add(lblBeverage);
		lblSoup.setBounds(40, 350, 55, 18);
		panelOrder.add(lblSoup);
		tfBeverage.setColumns(10);
		tfBeverage.setBounds(113, 316, 44, 22);
		panelOrder.add(tfBeverage);
		tfSoup.setColumns(10);
		tfSoup.setBounds(113, 348, 44, 22);
		panelOrder.add(tfSoup);
		lblDessert.setBounds(40, 383, 55, 18);
		panelOrder.add(lblDessert);
		tfDessert.setColumns(10);
		tfDessert.setBounds(113, 381, 44, 22);
		panelOrder.add(tfDessert);
		btnOrder.setBounds(38, 426, 98, 28);
		panelOrder.add(btnOrder);
		btnAdmissionCancel.setBounds(162, 171, 98, 28);
		panelOrder.add(btnAdmissionCancel);
		btnPayment.setBounds(162, 512, 98, 28);
		panelOrder.add(btnPayment);
		lblUpdateTable.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateTable.setFont(new Font("Dialog", Font.BOLD, 20));
		panelOrder.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		tfAdults.setHorizontalAlignment(SwingConstants.TRAILING);
		tfAdults.setText("0");
		tfKids.setHorizontalAlignment(SwingConstants.TRAILING);
		tfKids.setText("0");
		tfSoju.setText("0");
		tfSoju.setHorizontalAlignment(SwingConstants.TRAILING);
		tfBeer.setText("0");
		tfBeer.setHorizontalAlignment(SwingConstants.TRAILING);
		tfBeverage.setText("0");
		tfBeverage.setHorizontalAlignment(SwingConstants.TRAILING);
		tfSoup.setText("0");
		tfSoup.setHorizontalAlignment(SwingConstants.TRAILING);
		tfDessert.setText("0");
		tfDessert.setHorizontalAlignment(SwingConstants.TRAILING);
		btnAdultsUp.setBounds(169, 93, 44, 23);
		panelOrder.add(btnAdultsUp);

		btnAdultsDown.setBounds(216, 93, 44, 23);
		panelOrder.add(btnAdultsDown);

		btnKidsUp.setBounds(169, 122, 44, 23);
		panelOrder.add(btnKidsUp);

		btnSojuUp.setBounds(169, 247, 44, 23);
		panelOrder.add(btnSojuUp);

		btnBeerUp.setBounds(169, 280, 44, 23);
		panelOrder.add(btnBeerUp);

		btnBeverageUp.setBounds(169, 315, 44, 23);
		panelOrder.add(btnBeverageUp);

		btnSoupUp.setBounds(169, 348, 44, 23);
		panelOrder.add(btnSoupUp);

		btnDessertUp.setBounds(169, 380, 44, 23);
		panelOrder.add(btnDessertUp);

		btnKidsDown.setBounds(216, 122, 44, 23);
		panelOrder.add(btnKidsDown);

		btnSojuDown.setBounds(216, 247, 44, 23);
		panelOrder.add(btnSojuDown);

		btnBeerDown.setBounds(216, 280, 44, 23);
		panelOrder.add(btnBeerDown);

		btnBeverageDown.setBounds(216, 315, 44, 23);
		panelOrder.add(btnBeverageDown);

		btnSoupDown.setBounds(216, 348, 44, 23);
		panelOrder.add(btnSoupDown);

		btnDessertDown.setBounds(216, 380, 44, 23);
		panelOrder.add(btnDessertDown);

		lblSelectedNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectedNum.setFont(new Font("Dialog", Font.BOLD, 20));
		lblSelectedNum.setBounds(88, 31, 32, 28);
		panelOrder.add(lblSelectedNum);

		lblGetCno.setBounds(40, 65, 55, 18);
		panelOrder.add(lblGetCno);
		tfGetCno.setText("");
		tfGetCno.setEnabled(false);
		tfGetCno.setHorizontalAlignment(SwingConstants.TRAILING);
		tfGetCno.setColumns(10);
		tfGetCno.setBounds(113, 63, 44, 22);
		panelOrder.add(tfGetCno);

		btnOrderCancel.setBounds(162, 426, 98, 28);
		panelOrder.add(btnOrderCancel);

		for (JTextArea table : taTableOrderList)
			table.setEnabled(false);

	}

	private void clearTableBorder() {
		for (int i = 0; i < TABLE_NUMBER; ++i)
			panelTable[i].setBorder(UIManager.getBorder("DesktopIcon.border"));
	}

	private void addListener() {

		selectTableListener();

		setBtnUpDownListener();

		clickAdmissionListener();

		clickAdmissionCancelListener();

		clickBtnOrderListener();

		clickBtnOrderCancelListener();

		clickBtnPaymentListener();

		clickBtnTableUpDown();

	}// end of addListener

	private void clickBtnTableUpDown() {
		btnTableUp.addActionListener(e -> {
			int num = Integer.parseInt(lblGetNumOfTables.getText());
			if (num >= TABLE_NUMBER) {
				return;
			} else {
				num += 1;
				lblGetNumOfTables.setText(String.valueOf(num));
			}
			changeTables(num);
		});

		btnTableDown.addActionListener(e -> {
			int num = Integer.parseInt(lblGetNumOfTables.getText());
			if (num <= 1) {
				return;
			} else {
				num -= 1;
				lblGetNumOfTables.setText(String.valueOf(num));
			}

			changeTables(num);
		});

	}

	private void changeTables(int num) {

		for (int i = 0; i < num; ++i) {
			panelTable[i].setVisible(true);
		}

		for (int i = num; i < TABLE_NUMBER; ++i) {
			panelTable[i].setVisible(false);
		}

	}

	private void clickBtnPaymentListener() {
		btnPayment.addActionListener(e -> {
			confirmPayment();
			clearTable();
			clearOrderBoard();
		});
	}

	private void confirmPayment() {
		String cno = tfGetCno.getText();
		int tableNum = Integer.valueOf(lblSelectedNum.getText());
		String payment = lblTableCharge[tableNum - 1].getText();

		customerDAO.updatePayment(cno, payment);

		JOptionPane.showMessageDialog(btnPayment, "?????? ??????", "Message", JOptionPane.INFORMATION_MESSAGE);
	}

	private void clickBtnOrderCancelListener() {
		btnOrderCancel.addActionListener(e -> {
			takeOrders(-1);
			clearMenuBoard();
			paintTable();
		});
	}

	private void clickBtnOrderListener() {
		btnOrder.addActionListener(e -> {
			takeOrders(1);
			clearMenuBoard();
			paintTable();
		});
	}

	private void paintTable() {

		int tableNum = Integer.valueOf(lblSelectedNum.getText());

		paintTextArea(taTableOrderList[tableNum - 1]);
		paintlblCharge(lblTableCharge[tableNum - 1]);
	}

	private void paintlblCharge(JLabel lblCharge) {
		int adults = Integer.parseInt(tfAdults.getText());
		int kids = Integer.parseInt(tfKids.getText());

		int soju = orderListDAO.getQuantityByCno(tfGetCno.getText(), lblSoju.getText());
		int beer = orderListDAO.getQuantityByCno(tfGetCno.getText(), lblBeer.getText());
		int beverage = orderListDAO.getQuantityByCno(tfGetCno.getText(), lblBeverage.getText());
		int soup = orderListDAO.getQuantityByCno(tfGetCno.getText(), lblSoup.getText());
		int dessert = orderListDAO.getQuantityByCno(tfGetCno.getText(), lblDessert.getText());

		int charge = adults * CHARGE_ADULT + kids * CHARGE_KID + soju * CHARGE_SOJU + beer * CHARGE_BEER
				+ beverage * CHARGE_BEVERAGE + soup * CHARGE_SOUP + dessert * CHARGE_DESSERT;
		lblCharge.setText(String.valueOf(charge));
	}

	private void paintTextArea(JTextArea taTable) {

		int adults = Integer.parseInt(tfAdults.getText());
		int kids = Integer.parseInt(tfKids.getText());

		int soju = orderListDAO.getQuantityByCno(tfGetCno.getText(), lblSoju.getText());
		int beer = orderListDAO.getQuantityByCno(tfGetCno.getText(), lblBeer.getText());
		int beverage = orderListDAO.getQuantityByCno(tfGetCno.getText(), lblBeverage.getText());
		int soup = orderListDAO.getQuantityByCno(tfGetCno.getText(), lblSoup.getText());
		int dessert = orderListDAO.getQuantityByCno(tfGetCno.getText(), lblDessert.getText());

		String ta = "??????\t" + adults + "???\n" + "?????????\t" + kids + "???\n" + "??????\t" + soju + "???\n" + "??????\t" + beer + "???\n"
				+ "?????????\t" + beverage + "???\n" + "????????????\t" + soup + "???\n" + "??????\t" + dessert + "???\n";

		taTable.setText(ta);
	}

	private void clearMenuBoard() {
		tfSoju.setText("0");
		tfBeer.setText("0");
		tfBeverage.setText("0");
		tfSoup.setText("0");
		tfDessert.setText("0");
	}

	private void takeOrders(int i) {
		String cno = tfGetCno.getText();
		String menu;
		int quantity;
		int price;
		String orderTime = String.valueOf(new Timestamp(System.currentTimeMillis()));

		if (!tfSoju.getText().equals("0")) {
			menu = "??????";
			quantity = i * Integer.parseInt(tfSoju.getText());
			price = CHARGE_SOJU * quantity;

			OrderListVO orderListVO = new OrderListVO();
			orderListVO.setCno(cno);
			orderListVO.setMenu(menu);
			orderListVO.setQuantity(quantity);
			orderListVO.setPrice(price);
			orderListVO.setOrderTime(orderTime);

			orderListDAO.insertOrderList(orderListVO);
		}

		if (!tfBeer.getText().equals("0")) {
			menu = "??????";
			quantity = i * Integer.parseInt(tfBeer.getText());
			price = CHARGE_BEER * quantity;

			OrderListVO orderListVO = new OrderListVO();
			orderListVO.setCno(cno);
			orderListVO.setMenu(menu);
			orderListVO.setQuantity(quantity);
			orderListVO.setPrice(price);
			orderListVO.setOrderTime(orderTime);

			orderListDAO.insertOrderList(orderListVO);
		}

		if (!tfBeverage.getText().equals("0")) {
			menu = "?????????";
			quantity = i * Integer.parseInt(tfBeverage.getText());
			price = CHARGE_BEVERAGE * quantity;

			OrderListVO orderListVO = new OrderListVO();
			orderListVO.setCno(cno);
			orderListVO.setMenu(menu);
			orderListVO.setQuantity(quantity);
			orderListVO.setPrice(price);
			orderListVO.setOrderTime(orderTime);

			orderListDAO.insertOrderList(orderListVO);
		}

		if (!tfSoup.getText().equals("0")) {
			menu = "????????????";
			quantity = i * Integer.parseInt(tfSoup.getText());
			price = CHARGE_SOUP * quantity;

			OrderListVO orderListVO = new OrderListVO();
			orderListVO.setCno(cno);
			orderListVO.setMenu(menu);
			orderListVO.setQuantity(quantity);
			orderListVO.setPrice(price);
			orderListVO.setOrderTime(orderTime);

			orderListDAO.insertOrderList(orderListVO);
		}

		if (!tfDessert.getText().equals("0")) {
			menu = "??????";
			quantity = i * Integer.parseInt(tfDessert.getText());
			price = CHARGE_DESSERT * quantity;

			OrderListVO orderListVO = new OrderListVO();
			orderListVO.setCno(cno);
			orderListVO.setMenu(menu);
			orderListVO.setQuantity(quantity);
			orderListVO.setPrice(price);
			orderListVO.setOrderTime(orderTime);

			orderListDAO.insertOrderList(orderListVO);
		}

		if (i == 1) {
			JOptionPane.showMessageDialog(btnOrder, "????????????", "Message", JOptionPane.INFORMATION_MESSAGE);
		} else if (i == -1) {
			JOptionPane.showMessageDialog(btnOrder, "???????????? ??????", "Message", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void clickAdmissionCancelListener() {
		btnAdmissionCancel.addActionListener(e -> {
			String cno = tfGetCno.getText();

			if (cno.equals("")) {
				JOptionPane.showMessageDialog(btnAdmissionCancel, "?????? ???????????????", "Message",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				int result = JOptionPane.showConfirmDialog(btnAdmissionCancel, "???????????? ????????????????", "Confirm",
						JOptionPane.YES_NO_OPTION);

				if (result == JOptionPane.YES_OPTION) {
					customerDAO.deleteCustomerByCno(cno);
					clearTable();
					clearOrderBoard();
				} else
					return;
			}
		});
	}

	private void clearOrderBoard() {
		tfGetCno.setText("");
		tfAdults.setText("0");
		tfKids.setText("0");
		btnAdmission.setEnabled(true);

		clearMenuBoard();
	}

	private void clearTable() {
		int tableNum = Integer.valueOf(lblSelectedNum.getText());

		lblTableGetCno[tableNum - 1].setText("");
		lblTableAdmission[tableNum - 1].setText("??????");
		lblTableAdmission[tableNum - 1].setForeground(Color.black);
		taTableOrderList[tableNum - 1].setText("");
		lblTableCharge[tableNum - 1].setText("0");
		lblTableCharge[tableNum - 1].setForeground(Color.black);
	}

	private void clickAdmissionListener() {
		btnAdmission.addActionListener(e -> {
			String adults = tfAdults.getText();
			String kids = tfKids.getText();
			String tableNum = lblSelectedNum.getText();
			String currentTime = String.valueOf(new Timestamp(System.currentTimeMillis()));
			String admission;
			String cno;
			String ta = "?????? \t" + adults + "???\n" + "?????????\t" + kids + "???\n";

			CustomerVO customerVO = new CustomerVO();
			customerVO.setAdult(Integer.parseInt(adults));
			customerVO.setKid(Integer.parseInt(kids));
			customerVO.setAdmission(currentTime);
			customerVO.setTableNum(tableNum);

			if (lblSelectedNum.getText().equals("")) {
				JOptionPane.showMessageDialog(btnAdmission, "???????????? ??????????????????", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				customerDAO.insertCustomer(customerVO);
				btnAdmission.setEnabled(false);
			}
			admission = customerVO.getAdmission();

			cno = customerDAO.getCnoByAdmission(admission, tableNum);

			tfGetCno.setText(cno);

			int charge = Integer.parseInt(adults) * CHARGE_ADULT + Integer.parseInt(kids) * CHARGE_KID;

			int index = Integer.valueOf(tableNum) - 1;

			lblTableGetCno[index].setText(cno);
			lblTableAdmission[index].setText(String.valueOf(new Time(System.currentTimeMillis())));
			lblTableAdmission[index].setForeground(Color.blue);
			taTableOrderList[index].setText(ta);
			lblTableCharge[index].setText(String.valueOf(charge));
			lblTableCharge[index].setForeground(Color.red);

		});
	}// clickAdmissionListener

	private void selectTableListener() {

		for (index = 0; index < TABLE_NUMBER; index++) {

			taTableOrderList[index].addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {

					clearTableBorder();

					JTextArea ta = (JTextArea) e.getSource();
					JPanel panelParent = (JPanel) ta.getParent();
					panelParent.setBorder(BorderFactory.createLineBorder(Color.red, 3));

					Component[] componentsChild = panelParent.getComponents();

					for (Component component : componentsChild) {

						if (component instanceof JPanel) {
							JPanel panelChild = (JPanel) component;

							Component[] componentsGrandChild = panelChild.getComponents();

							for (Component LabelGrandChild : componentsGrandChild) {
								if (LabelGrandChild instanceof JLabel) {
									JLabel label = (JLabel) LabelGrandChild;
									String labelName = label.getName();
									if (labelName != null && labelName.equals("lblTableAdmission")) {
										ifSelectEmptyTable(label);
									}

									if (labelName != null && labelName.equals("lblTableNum")) {
										String tableNum = label.getText();
										lblSelectedNum.setText(tableNum);
									}
									if (labelName != null && labelName.equals("lblTableGetCno")) {
										ifSelectTableAgain(label);
									}
								}
							}
						}
					} // for
				}
			});

		} // for

	}// selectTableListener

	private int index = 0;

	private void ifSelectTableAgain(JLabel lblGetCno) {
		int adult;
		int kid;

		if (lblGetCno.getText().equals("")) {
			btnAdmission.setEnabled(true);
		} else {
			tfGetCno.setText(lblGetCno.getText());
			adult = customerDAO.getAdultsByCno(tfGetCno.getText());
			tfAdults.setText(String.valueOf(adult));
			kid = customerDAO.getKidsByCno(tfGetCno.getText());
			tfKids.setText(String.valueOf(kid));
			btnAdmission.setEnabled(false);
		}
	}

	private void ifSelectEmptyTable(JLabel lblAdmission) {
		if (lblAdmission.getText().equals("??????")) {
			btnAdmission.setEnabled(true);
			tfGetCno.setText("");
			tfAdults.setText("0");
			tfKids.setText("0");
		} else
			return;
	}

	private void setBtnUpDownListener() {
		btnAdultsUp.addActionListener(e -> {
			btnUpCondition(tfAdults);
		});
		btnAdultsDown.addActionListener(e -> {
			btnDownCondition(tfAdults);
		});
		btnKidsUp.addActionListener(e -> {
			btnUpCondition(tfKids);
		});
		btnKidsDown.addActionListener(e -> {
			btnDownCondition(tfKids);
		});
		btnSojuUp.addActionListener(e -> {
			btnUpCondition(tfSoju);
		});
		btnSojuDown.addActionListener(e -> {
			btnDownCondition(tfSoju);
		});
		btnBeerUp.addActionListener(e -> {
			btnUpCondition(tfBeer);
		});
		btnBeerDown.addActionListener(e -> {
			btnDownCondition(tfBeer);
		});
		btnBeverageUp.addActionListener(e -> {
			btnUpCondition(tfBeverage);
		});
		btnBeverageDown.addActionListener(e -> {
			btnDownCondition(tfBeverage);
		});
		btnSoupUp.addActionListener(e -> {
			btnUpCondition(tfSoup);
		});
		btnSoupDown.addActionListener(e -> {
			btnDownCondition(tfSoup);
		});
		btnDessertUp.addActionListener(e -> {
			btnUpCondition(tfDessert);
		});
		btnDessertDown.addActionListener(e -> {
			btnDownCondition(tfDessert);
		});
	}

	private void btnDownCondition(JTextField tf) {
		int num = Integer.parseInt(tf.getText());
		if (num > 0) {
			num -= 1;
			tf.setText(String.valueOf(num));
		} else
			return;
	}

	private void btnUpCondition(JTextField tf) {
		if (tf.getText().equals("")) {
			tf.setText("1");
		} else {
			int num = Integer.parseInt(tf.getText());
			num += 1;
			tf.setText(String.valueOf(num));
		}
	}
}
