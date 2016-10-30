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
		MenuItem cheeseSandwich = new MenuItem("Cheese Sandwich", 2.0, true);
		bill.addItem(cheeseSandwich);
		MenuItem steakSandwich = new MenuItem("Steak Sandwich", 4.5, true);
		bill.addItem(steakSandwich);
		assertEquals(bill.printItems(), 
				"Item: Cola\t0.5\nItem: Coffee\t1.0\nItem: Cheese Sandwich\t2.0\nItem: Steak Sandwich\t4.5\n");
		System.out.println("List Items");
		System.out.println(bill.printItems());
	}
	
	@Test
	public void testSubTotalItems(){
		
		Bill bill = new Bill();
		
		MenuItem cola = new MenuItem("Cola", 0.5);
		bill.addItem(cola);
		assertEquals(bill.getSubTotal(), 0.5, 0.00);
		MenuItem coffee = new MenuItem("Coffee", 1.0);
		bill.addItem(coffee);
		assertEquals(bill.getSubTotal(), 1.5, 0.00);
		MenuItem cheeseSandwich = new MenuItem("Cheese Sandwich", 2.0, true);
		bill.addItem(cheeseSandwich);
		MenuItem steakSandwich = new MenuItem("Steak Sandwich", 4.5,true);
		bill.addItem(steakSandwich);
		assertEquals(bill.getSubTotal(), 8.0, 0.00);
		System.out.println("List Items & Sub Total");
		System.out.println(bill.printItems());
		System.out.println("Sub Total:\t"+bill.getSubTotal()+"\n");
	}
	
	@Test
	public void testGetServiceCharge(){
		
		Bill bill = new Bill();
		
		MenuItem cola = new MenuItem("Cola", 0.5);
		bill.addItem(cola);
		assertEquals(bill.getServiceCharge(), 0, 0.00);
		
		MenuItem cheeseSandwich = new MenuItem("Cheese Sandwich", 2.0, true);
		bill.addItem(cheeseSandwich);
		assertEquals(bill.getServiceCharge(), 0.25, 0.00);
		
	}

}
