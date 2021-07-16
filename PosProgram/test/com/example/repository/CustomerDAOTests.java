package com.example.repository;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.domain.CustomerVO;

public class CustomerDAOTests {

	private CustomerDAO customerDAO;
	private OrderListDAO orderListDAO;

	private CustomerVO customerVO01;
	private CustomerVO customerVO02;

	private String admission;

	List<CustomerVO> list;

	@BeforeClass
	public static void beforeTest() { // 스태틱으로
		System.out.println("테스트 시작");
	}

	@Before
	public void setUp() {
		customerDAO = CustomerDAO.getInstance();
		orderListDAO = OrderListDAO.getInstance();

		admission = String.valueOf(new Timestamp(System.currentTimeMillis()));

		customerVO01 = new CustomerVO();
		customerVO01.setAdult(2);
		customerVO01.setKid(1);
		customerVO01.setAdmission(admission);
		customerVO01.setTableNum("1");

		customerVO02 = new CustomerVO();
		customerVO02.setAdult(2);
		customerVO02.setKid(0);
		customerVO02.setAdmission(admission);
		customerVO02.setTableNum("2");

	}

	@Test
	public void testConnection() { // 접속 테스트

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
	public void testDeleteAllAndGetCountAll() { // delete 테스트
		orderListDAO.deleteAll(); // 무결성 제약조건
		customerDAO.deleteAll();

		int count = customerDAO.getCountAll();

		assertEquals(0, count);

	}// test deleteAll() and getCountAll()

	@Test
	public void testInsertCustomer() { // insert 테스트
		orderListDAO.deleteAll(); // 무결성 제약조건
		customerDAO.deleteAll();

		customerDAO.insertCustomer(customerVO01);
		customerDAO.insertCustomer(customerVO02);

		int count = customerDAO.getCountAll();

		assertEquals(2, count);

	}// test insertCustomer()

	@Test
	public void testGetCustomerByAdmissionAndTNum() { // select 테스트
		orderListDAO.deleteAll(); // 무결성 제약조건
		customerDAO.deleteAll();

		customerDAO.insertCustomer(customerVO01);
		customerDAO.insertCustomer(customerVO02);

		CustomerVO dbCustomer = customerDAO.getCustomerByAdmissionAndTNum(admission, "2");

		assertEquals(customerVO02.getAdmission(), dbCustomer.getAdmission());
		assertNotNull(dbCustomer);

	}// test getCustomerByAdmissionAndTNum()

	@Test
	public void testUpdatePayment() { // update 테스트
		orderListDAO.deleteAll(); // 무결성 제약조건
		customerDAO.deleteAll();

		customerDAO.insertCustomer(customerVO01);
		customerDAO.insertCustomer(customerVO02);

		CustomerVO customerBefore = customerDAO.getCustomerByAdmissionAndTNum(admission, "2");

		String cno = customerBefore.getCno();
		String payment = "60000";

		customerDAO.updatePayment(cno, payment);

		CustomerVO customerAfter = customerDAO.getCustomerByAdmissionAndTNum(admission, "2");

		assertEquals(60000, customerAfter.getPayment());

	}// test updatePayment()

	@Test
	public void testGetCnoByAdmission() {
		orderListDAO.deleteAll(); // 무결성 제약조건
		customerDAO.deleteAll();

		customerDAO.insertCustomer(customerVO01);
		customerDAO.insertCustomer(customerVO02);

		CustomerVO dbCustomer = customerDAO.getCustomerByAdmissionAndTNum(admission, "2");

		String cno = customerDAO.getCnoByAdmission(admission, "2");

		assertEquals(cno, dbCustomer.getCno());

	} // test getCnoByAdmission

	@Test
	public void testDeleteCustomerByCno() {
		orderListDAO.deleteAll(); // 무결성 제약조건
		customerDAO.deleteAll();

		customerDAO.insertCustomer(customerVO01);
		customerDAO.insertCustomer(customerVO02);

		String cno = customerDAO.getCnoByAdmission(admission, "2");

		customerDAO.deleteCustomerByCno(cno);

		int count = customerDAO.getCountAll();

		assertEquals(1, count);

	}// test deleteCustomerByCno

	@Test
	public void testGetAdultsByCno() {
		orderListDAO.deleteAll(); // 무결성 제약조건
		customerDAO.deleteAll();

		customerDAO.insertCustomer(customerVO01);
		customerDAO.insertCustomer(customerVO02);

		String cno = customerDAO.getCnoByAdmission(admission, "2");

		CustomerVO dbCustomer = customerDAO.getCustomerByAdmissionAndTNum(admission, "2");

		int adults = customerDAO.getAdultsByCno(cno);

		assertEquals(adults, dbCustomer.getAdult());

	}// test getAdultsByCno

	@Test
	public void testGetKidsByCno() {
		orderListDAO.deleteAll(); // 무결성 제약조건
		customerDAO.deleteAll();

		customerDAO.insertCustomer(customerVO01);
		customerDAO.insertCustomer(customerVO02);

		String cno = customerDAO.getCnoByAdmission(admission, "2");

		CustomerVO dbCustomer = customerDAO.getCustomerByAdmissionAndTNum(admission, "2");

		int kids = customerDAO.getKidsByCno(cno);

		assertEquals(kids, dbCustomer.getKid());

	}// test getKidsByCno

	@Test
	public void testGetCustomers() {
		orderListDAO.deleteAll(); // 무결성 제약조건
		customerDAO.deleteAll();

		customerDAO.insertCustomer(customerVO01);
		customerDAO.insertCustomer(customerVO02);

		list = new ArrayList<>();
		list.add(customerDAO.getCustomerByAdmissionAndTNum(admission, "1"));
		list.add(customerDAO.getCustomerByAdmissionAndTNum(admission, "2"));

		List<CustomerVO> getList = customerDAO.getCustomers();

		assertEquals(list, getList);

	}// test getCustomers

	@Test
	public void testGetCustomerByCno() {
		orderListDAO.deleteAll(); // 무결성 제약조건
		customerDAO.deleteAll();

		customerDAO.insertCustomer(customerVO01);
		customerDAO.insertCustomer(customerVO02);

		list = new ArrayList<>();
		list.add(customerDAO.getCustomerByAdmissionAndTNum(admission, "2"));

		String cno = customerDAO.getCnoByAdmission(admission, "2");

		List<CustomerVO> getList = customerDAO.getCustomerByCno(cno);

		assertEquals(list, getList);
	}// test getCustomerByCno

	@After
	public void tearDown() {
	}

	@AfterClass
	public static void afterTest() {
		System.out.println("테스트 종료");
	}

}// end of CustomerDAOTests
