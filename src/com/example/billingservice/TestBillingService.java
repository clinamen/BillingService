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
	
	/* Test to print out the items added
	 * 
	 */
	@Test
	public void testPrintItems() {
		
		Bill bill = new Bill();
	
		MenuItem cola = new MenuItem("Cola", 0.5);
		bill.addItem(cola);
		MenuItem coffee = new MenuItem("Coffee", 1.0);
		bill.addItem(coffee);
		assertEquals(bill.printItems(), 
				"Item: Cola\t0.5\nItem: Coffee\t1.0\n");
		MenuItem cheeseSandwich = new MenuItem("Cheese Sandwich", 2.0);
		bill.addItem(cheeseSandwich);
		MenuItem steakSandwich = new MenuItem("Steak Sandwich", 4.5);
		bill.addItem(steakSandwich);
		assertEquals(bill.printItems(), 
				"Item: Cola\t0.5\nItem: Coffee\t1.0\nItem: Cheese Sandwich\t2.0\nItem: Steak Sandwich\t4.5\n");
		System.out.println("List Items");
		System.out.println(bill.printItems());
	}
	
	@Test
	public void testTotalItems(){
		
		Bill bill = new Bill();
		
		MenuItem cola = new MenuItem("Cola", 0.5);
		bill.addItem(cola);
		assertEquals(bill.getTotal(), 0.5, 0.00);
		MenuItem coffee = new MenuItem("Coffee", 1.0);
		bill.addItem(coffee);
		assertEquals(bill.getTotal(), 1.5, 0.00);
		MenuItem cheeseSandwich = new MenuItem("Cheese Sandwich", 2.0);
		bill.addItem(cheeseSandwich);
		MenuItem steakSandwich = new MenuItem("Steak Sandwich", 4.5);
		bill.addItem(steakSandwich);
		assertEquals(bill.getTotal(), 8.0, 0.00);
		System.out.println("List Items & Total");
		System.out.println(bill.printItems());
		System.out.println("Total:\t"+bill.getTotal()+"\n");
	}

}
