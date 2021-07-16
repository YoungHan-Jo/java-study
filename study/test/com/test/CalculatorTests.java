package com.test;



import static org.junit.Assert.*;
// Assert 클래스에 있는 모든 스태틱을 임포트. 클래스명 생략하고 바로 쓸 수 있음.

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 	
 	
  */


public class CalculatorTests {

	private Calculator calc;

	@BeforeClass
	public static void beforeTest() { // 스태틱으로
		System.out.println("@BeforeClass - beforeTest() : 테스트 클래스 로딩 후 객체생성 전에 먼저 호출됨.");
	}
	
	
	
	//@test보다 먼저 호출됨 // test 할때 마다 테스트 하기 전에 호출됨.
		@Before
	public void setUp() { 
		System.out.println("@Before - setUp() : 테스트 클래스 객체 생성 후 먼저 호출 됨.");
		
		calc = new Calculator();
	}
	
	@Test
	public void testSum() {
		System.out.println("@Test - testSum()");
				
		assertEquals(30, calc.sum(20, 10));
	}
	
	@Test
	public void testSub() {
		System.out.println("@Test - testSub()");
		
		assertEquals(10, calc.sub(20, 10));
	}
	
	@Test
	public void testMul() {
		System.out.println("@Test - testMul()");
		
		assertEquals(200, calc.mul(20, 10));
	}
	
	@Test
	public void testDiv() {
		System.out.println("@Test - testDiv()");
		
		assertEquals(2, calc.div(20, 10));
	}
	
	@After
	public void tearDown() {
		System.out.println("@After - tearDown() : 테스트 호출 후 정리작업 위해 호출됨. 다음 테스트를 위해 현재 Calculator 객체를 폐기함.");
	}

	@AfterClass
	public static void afterTest() {
		System.out.println("@AfterClass - afterTest() : 테스트클래스가 메모리에서 해제되기 전에 정리작업 위해 마지막으로 호출됨");
	}
}
