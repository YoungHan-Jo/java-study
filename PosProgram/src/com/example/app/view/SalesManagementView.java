package com.example.app.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.example.app.StoreManager;
import com.example.domain.CustomerVO;
import com.example.domain.OrderListVO;
import com.example.repository.CustomerDAO;
import com.example.repository.OrderListDAO;

import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class SalesManagementView implements Viewable {

	CustomerDAO customerDAO = CustomerDAO.getInstance();
	OrderListDAO orderListDAO = OrderListDAO.getInstance();

	public static final String VIEW_NAME = "sales management";

	private CardLayout cardLayout;
	private Container container;
	private StoreManager frame;

	private JPanel panelSalesManagement;
	private JPanel panelLeft;
	private JPanel panelRight;
	private JTable table1;
	private JTable table2;
	private JPanel panelJTable2;
	private JPanel panelEmptySpace;

	private JPanel panelJTable1;
	private DefaultTableModel tmGetCustomers;

	public SalesManagementView(CardLayout cardLayout, Container container, StoreManager frame) {
		this.cardLayout = cardLayout;
		this.container = container;
		this.frame = frame;

		init();
		setComponents();
		addListener();
	}

	@Override
	public JPanel getView() {
		return panelSalesManagement;
	}

	private void init() {

		panelSalesManagement = new JPanel();
		panelSalesManagement.setLayout(new BorderLayout(0, 0));
		panelSalesManagement.setSize(MainView.PANEL_LEFT_WIDTH, MainView.PANEL_LEFT_HEIGHT);

		panelLeft = new JPanel();
		panelSalesManagement.add(panelLeft, BorderLayout.WEST);

		panelRight = new JPanel();
		panelSalesManagement.add(panelRight, BorderLayout.CENTER);

		panelLeft.setLayout(new BorderLayout(0, 0));

		panelJTable1 = new JPanel();
		panelJTable1.setLayout(new BorderLayout(0, 0));
		panelJTable1.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelJTable1.setPreferredSize(new Dimension(1080, 400));
		panelLeft.add(panelJTable1, BorderLayout.NORTH);

		getCustomer();

		panelEmptySpace = new JPanel();
		panelEmptySpace.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelEmptySpace.setPreferredSize(new Dimension(1080, 30));
		panelLeft.add(panelEmptySpace, BorderLayout.CENTER);

		getOrderList();

	}

	private void getOrderList() {
		panelJTable2 = new JPanel();
		panelJTable2.setLayout(new BorderLayout(0, 0));
		panelJTable2.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelLeft.add(panelJTable2, BorderLayout.SOUTH);

		List<OrderListVO> orderList = orderListDAO.getOrderList();

		Vector<Vector<Object>> vector = getOrderListVectorFromList(orderList);

		Vector<String> columnNamesOrderList = new Vector<>();
		columnNamesOrderList.add("주문번호");
		columnNamesOrderList.add("손님번호");
		columnNamesOrderList.add("메뉴");
		columnNamesOrderList.add("수량");
		columnNamesOrderList.add("주문가격");
		columnNamesOrderList.add("주문시간");

		tmGetCustomers = new DefaultTableModel(vector, columnNamesOrderList);

		table2 = new JTable(tmGetCustomers);
		panelJTable2.add(new JScrollPane(table2), BorderLayout.CENTER);
	}

	private void getCustomer() {
		List<CustomerVO> customerList = customerDAO.getCustomers();

		Vector<Vector<Object>> vector = getCustomerVectorFromList(customerList);

		Vector<String> columnNamesCustomer = new Vector<>();
		columnNamesCustomer.add("손님번호");
		columnNamesCustomer.add("성인 인원 수");
		columnNamesCustomer.add("어린이 인원 수");
		columnNamesCustomer.add("결제금액");
		columnNamesCustomer.add("입장시간");
		columnNamesCustomer.add("테이블 번호");
		columnNamesCustomer.add("결제시간");

		tmGetCustomers = new DefaultTableModel(vector, columnNamesCustomer);

		table1 = new JTable(tmGetCustomers);
		panelJTable1.add(new JScrollPane(table1), BorderLayout.CENTER);
	}

	private Vector<Vector<Object>> getOrderListVectorFromList(List<OrderListVO> list) {
		Vector<Vector<Object>> vector = new Vector<>();

		for (OrderListVO orderList : list) {
			Vector<Object> rowVector = new Vector<>();
			rowVector.add(orderList.getOrderNum());
			rowVector.add(orderList.getCno());
			rowVector.add(orderList.getMenu());
			rowVector.add(orderList.getQuantity());
			rowVector.add(orderList.getPrice());
			rowVector.add(orderList.getOrderTime());

			vector.add(rowVector);
		}

		return vector;
	}

	private Vector<Vector<Object>> getCustomerVectorFromList(List<CustomerVO> list) {
		Vector<Vector<Object>> vector = new Vector<>();

		for (CustomerVO customer : list) {
			Vector<Object> rowVector = new Vector<>();
			rowVector.add(customer.getCno());
			rowVector.add(customer.getAdult());
			rowVector.add(customer.getKid());
			rowVector.add(customer.getPayment());
			rowVector.add(customer.getAdmission());
			rowVector.add(customer.getTableNum());
			rowVector.add(customer.getExitTime());

			vector.add(rowVector);
		}

		return vector;
	}

	private void setComponents() {

	}

	private void addListener() {

	}

}
