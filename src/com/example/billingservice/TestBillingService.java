package com.example.billingservice;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestBillingService {

	/* Test to ensure items are correctly added to bill
	 * 
	 */
	@Test
	public void testAdditem() {

		Bill bill = new Bill();
		
		MenuItem cola = new MenuItem("Cola", 0.5);
		bill.addItem(cola);
		assertTrue(bill.getItems().contains(cola));
		
		MenuItem coffee = new MenuItem("Coffee", 1.0);
		bill.addItem(coffee);
		assertTrue(bill.getItems().contains(coffee));
		
		assertEquals(bill.getItems().size(), 2);
	}

}
