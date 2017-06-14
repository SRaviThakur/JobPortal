package com.galaxe.rst;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestJUnit {
	
	 EmployeeService empService = new EmployeeServiceImpl();
	

	@Before
	public void setUp() throws Exception {
		System.out.println("asfas");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("dsafj");
	}

	@Test
	public void testHome() {
		

			System.out.println("Success");
	}



}
