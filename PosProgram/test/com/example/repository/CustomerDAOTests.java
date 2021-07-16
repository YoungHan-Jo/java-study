package com.example.repository;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Timestamp;

import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

import com.example.domain.CustomerVO;

public class CustomerDAOTests {

	private CustomerDAO customerDAO;

	private CustomerVO customerVO01;
	private CustomerVO customerVO02;

	@Before
	public void setUp() {
		customerDAO = CustomerDAO.getInstance();

		customerVO01 = new CustomerVO();
		customerVO01.setCno("1");
		customerVO01.setAdult(2);
		customerVO01.setKid(2);
		customerVO01.setAdmission(String.valueOf(new Timestamp(System.currentTimeMillis())));
		customerVO01.setTableNum("1");
		customerVO01.setPayment(44000);
		customerVO01.setExitTime(String.valueOf(new Timestamp(System.currentTimeMillis())));
		
		customerVO02 = new CustomerVO();
		customerVO02.setCno("2");
		customerVO02.setAdult(4);
		customerVO02.setKid(0);
		customerVO02.setAdmission(String.valueOf(new Timestamp(System.currentTimeMillis())));
		customerVO02.setTableNum("2");
		customerVO02.setPayment(28000);
		customerVO02.setExitTime(String.valueOf(new Timestamp(System.currentTimeMillis())));
	}

	@Test
	public void testConnection() {

		String URL = "jdbc:oracle:thin:@localhost:1521:xe";
		String USER = "mypos";
		String PASSWD = "1234";

		Connection con = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PASSWD);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertNotNull(con);

	} // test getConnection

	

	@Test
	public void testDeleteAllAndGetCountAll() {
		customerDAO.deleteAll();

		int count = customerDAO.getCountAll();

		assertEquals(0, count);
	}// test deleteAll() and getCountAll()
	
	@Test
	public void testInsertCustomer() {
		customerDAO.deleteAll();

		customerDAO.insertCustomer(customerVO01);
		customerDAO.insertCustomer(customerVO02);

		int count = customerDAO.getCountAll();

		assertEquals(2, count);

	}// test insertCustomer() 
	
	@Test
	public void testUpdatePayment() {
		customerDAO.deleteAll();
		
		customerDAO.insertCustomer(customerVO01);
		customerDAO.insertCustomer(customerVO02);
		
		System.out.println("행 수 : " + customerDAO.getCountAll());
		System.out.println(customerVO01.toString());
		System.out.println(customerVO02.toString());
		
		String cno = customerVO02.getCno();
		System.out.println("cno : " + cno);
		JLabel lblCharge = new JLabel();
		lblCharge.setText("60000");
		
		String lbl = lblCharge.getText();
		System.out.println("lbl = " + lbl);
		
		customerDAO.updatePayment(cno, lblCharge);
		
		System.out.println(customerVO02.toString());
		
		assertEquals(60000, customerVO02.getPayment());
		
		
	}// test updatePayment()
	
	

}// end of CustomerDAOTests
