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
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

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
	private JPanel panelSearchByCno;

	private JPanel panelJTable1;
	private DefaultTableModel tmGetCustomers;
	private DefaultTableModel tmGetOrderLists;
	private JPanel panelSearchLeft;
	private JButton btnShowTotal;
	private JPanel panelSearchCenter;
	private JPanel panelSearchRight;
	private JLabel lblSearchByCno;
	private JTextField tfSearchByCno;
	private JButton btnSearchByCno;
	private JLabel lblSearchByDate;
	private JTextField tfSearchByDate;
	private JButton btnSearchByDate;
	private JLabel lblSalesTotal;
	private JTextField tfSalesTotal;
	private JLabel lblSalesMonth;
	private JTextField tfSalesMonth;
	private JLabel lblSalesDay;
	private JTextField tfSalesDay;

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

		panelLeft = new JPanel();

		panelRight = new JPanel();

		lblSalesTotal = new JLabel("?????? ??????");
		tfSalesTotal = new JTextField();
		lblSalesMonth = new JLabel("?????? ??????");
		tfSalesMonth = new JTextField();
		lblSalesDay = new JLabel("?????? ??????");
		tfSalesDay = new JTextField();

		panelJTable1 = new JPanel();

		panelJTable2 = new JPanel();

		panelSearchByCno = new JPanel();

		panelSearchLeft = new JPanel();

		btnShowTotal = new JButton("????????????");

		panelSearchCenter = new JPanel();

		lblSearchByCno = new JLabel("??????????????? ??????");

		tfSearchByCno = new JTextField();

		btnSearchByCno = new JButton("??????");

		panelSearchRight = new JPanel();

		lblSearchByDate = new JLabel("????????? ??????");

		tfSearchByDate = new JTextField();

		btnSearchByDate = new JButton("??????");
	}

	private void setComponents() {

		panelSalesManagement.setLayout(new BorderLayout(0, 0));
		panelSalesManagement.setSize(MainView.PANEL_LEFT_WIDTH, MainView.PANEL_LEFT_HEIGHT);
		panelSalesManagement.add(panelLeft, BorderLayout.WEST);
		panelSalesManagement.add(panelRight, BorderLayout.CENTER);
		panelLeft.setLayout(new BorderLayout(0, 0));

		panelJTable1.setLayout(new BorderLayout(0, 0));
		panelJTable1.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelJTable1.setPreferredSize(new Dimension(1080, 400));
		panelLeft.add(panelJTable1, BorderLayout.NORTH);

		panelJTable2.setLayout(new BorderLayout(0, 0));
		panelJTable2.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelLeft.add(panelJTable2, BorderLayout.SOUTH);

		panelSearchByCno.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelLeft.add(panelSearchByCno, BorderLayout.CENTER);
		panelSearchByCno.setLayout(new BorderLayout(0, 0));
		panelSearchByCno.add(panelSearchLeft, BorderLayout.WEST);
		panelSearchLeft.add(btnShowTotal);

		panelSearchByCno.add(panelSearchCenter, BorderLayout.CENTER);
		panelSearchCenter.add(lblSearchByCno);

		panelSearchCenter.add(tfSearchByCno);
		tfSearchByCno.setColumns(10);
		panelSearchCenter.add(btnSearchByCno);

		panelSearchByCno.add(panelSearchRight, BorderLayout.EAST);
		panelSearchRight.add(lblSearchByDate);
		tfSearchByDate.setColumns(10);
		panelSearchRight.add(tfSearchByDate);
		panelSearchRight.add(btnSearchByDate);

		panelRight.setPreferredSize(new Dimension(2000, 500));
		panelRight.setLayout(null);
		lblSalesTotal.setBounds(40, 65, 55, 18);
		panelRight.add(lblSalesTotal);

		tfSalesTotal.setEnabled(false);
		tfSalesTotal.setHorizontalAlignment(SwingConstants.TRAILING);
		tfSalesTotal.setText(customerDAO.getSalesTotal());
		tfSalesTotal.setBounds(113, 63, 114, 22);
		panelRight.add(tfSalesTotal);
		tfSalesTotal.setColumns(10);

		lblSalesMonth.setBounds(40, 95, 55, 18);
		panelRight.add(lblSalesMonth);

		tfSalesMonth.setEnabled(false);
		tfSalesMonth.setHorizontalAlignment(SwingConstants.TRAILING);
		tfSalesMonth.setText(customerDAO.getSalesMonth());
		tfSalesMonth.setBounds(113, 93, 114, 22);
		panelRight.add(tfSalesMonth);
		tfSalesMonth.setColumns(10);

		lblSalesDay.setBounds(40, 125, 55, 18);
		panelRight.add(lblSalesDay);

		tfSalesDay.setEnabled(false);
		tfSalesDay.setHorizontalAlignment(SwingConstants.TRAILING);
		tfSalesDay.setText(customerDAO.getSalesDay());
		tfSalesDay.setBounds(113, 123, 114, 22);
		panelRight.add(tfSalesDay);
		tfSalesDay.setColumns(10);

	}

	private void addListener() {
		btnShowTotal.addActionListener(e -> {

			List<CustomerVO> customerList = customerDAO.getCustomers();
			getCustomer(customerList);

			List<OrderListVO> orderList = orderListDAO.getOrderList();
			getOrderList(orderList);
			
			tfSalesTotal.setText(customerDAO.getSalesTotal());
			tfSalesMonth.setText(customerDAO.getSalesMonth());
			tfSalesDay.setText(customerDAO.getSalesDay());
			
		});

		btnSearchByCno.addActionListener(e -> {
			String cno = tfSearchByCno.getText();

			List<CustomerVO> customerList = customerDAO.getCustomerByCno(cno);
			getCustomer(customerList);

			List<OrderListVO> orderList = orderListDAO.getOrderListByCno(cno);
			getOrderList(orderList);

		});

		btnSearchByDate.addActionListener(e -> {
			String date = tfSearchByDate.getText();

			List<CustomerVO> customerList = customerDAO.getCustomerByDate(date);
			getCustomer(customerList);

			List<OrderListVO> orderList = orderListDAO.getOrderListByDate(date);
			getOrderList(orderList);

		});

	}

	public void getOrderList(List<OrderListVO> orderList) {

		Vector<Vector<Object>> vector = getOrderListVectorFromList(orderList);

		Vector<String> columnNamesOrderList = new Vector<>();
		columnNamesOrderList.add("????????????");
		columnNamesOrderList.add("????????????");
		columnNamesOrderList.add("??????");
		columnNamesOrderList.add("??????");
		columnNamesOrderList.add("????????????");
		columnNamesOrderList.add("????????????");

		tmGetOrderLists = new DefaultTableModel(vector, columnNamesOrderList);

		table2 = new JTable(tmGetOrderLists);
		tmGetOrderLists.fireTableDataChanged();
		JScrollPane jsPane = new JScrollPane(table2);
		panelJTable2.add(jsPane, BorderLayout.CENTER);

		frame.setVisible(true);
	}

	private void getCustomer(List<CustomerVO> customerList) {

		Vector<Vector<Object>> vector = getCustomerVectorFromList(customerList);

		Vector<String> columnNamesCustomer = new Vector<>();
		columnNamesCustomer.add("????????????");
		columnNamesCustomer.add("?????? ?????? ???");
		columnNamesCustomer.add("????????? ?????? ???");
		columnNamesCustomer.add("????????????");
		columnNamesCustomer.add("????????????");
		columnNamesCustomer.add("????????? ??????");
		columnNamesCustomer.add("????????????");

		tmGetCustomers = new DefaultTableModel(vector, columnNamesCustomer);

		table1 = new JTable(tmGetCustomers);
		tmGetCustomers.fireTableDataChanged();
		panelJTable1.add(new JScrollPane(table1), BorderLayout.CENTER);

		frame.setVisible(true);
	}

	private Vector<Vector<Object>> getOrderListVectorFromList(List<OrderListVO> list) {
		Vector<Vector<Object>> vector = new Vector<>();
		vector.clear();
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
}
