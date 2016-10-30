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
	}

}
