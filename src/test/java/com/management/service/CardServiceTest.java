package com.management.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CardServiceTest {
	
	@Autowired
	private CardService cs;
	
	@Test
	public void testone()
	{
		boolean b = cs.validateCardNumber("1234567");
		assertEquals(true,b);
	}

 
}



