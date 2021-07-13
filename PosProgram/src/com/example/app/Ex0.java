package com.example.app;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.example.domain.CustomerVO;
import com.example.repository.CustomerDAO;

public class Ex0 extends JFrame {

	CustomerDAO customerDAO = CustomerDAO.getInstance();
	
	JTable table;
	Container container = getContentPane();
	DefaultTableModel tmGetCustomer;
	
	public Ex0() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1080, 500);
		setLocationByPlatform(true);
		
		
		
		
		List<CustomerVO> list = customerDAO.getCustomers();

		Vector<Vector<Object>> vector = getVectorFromList(list);

		Vector<String> columnNamesCustomer = new Vector<>();
		columnNamesCustomer.add("손님번호");
		columnNamesCustomer.add("성인 인원");
		columnNamesCustomer.add("어린이 인원");
		columnNamesCustomer.add("결제금액");
		columnNamesCustomer.add("내점시간");
		columnNamesCustomer.add("앉은 테이블 번호");
		columnNamesCustomer.add("퇴점시간");
		
		
		tmGetCustomer = new DefaultTableModel(vector,columnNamesCustomer);
		
		table = new JTable(tmGetCustomer);
		
		
		container.add(new JScrollPane(table), BorderLayout.CENTER );
		
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex0();
	}
	
	private Vector<Vector<Object>> getVectorFromList(List<CustomerVO> list) {
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
