package com.example.billingservice;

import static org.junit.Assert.*;

import java.text.DecimalFormat;

import org.junit.Test;

public class TestBillingService {
	
	private DecimalFormat currencyFormat = new DecimalFormat("0.00");

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
				"Item: Cola\t0.50\nItem: Coffee\t1.00\n");
		MenuItem cheeseSandwich = new MenuItem("Cheese Sandwich", 2.0, true);
		bill.addItem(cheeseSandwich);
		MenuItem steakSandwich = new MenuItem("Steak Sandwich", 4.5, true, true);
		bill.addItem(steakSandwich);
		assertEquals(bill.printItems(), 
				"Item: Cola\t0.50\nItem: Coffee\t1.00\nItem: Cheese Sandwich\t2.00\nItem: Steak Sandwich\t4.50\n");
		
		System.out.println("***List Items***");
		System.out.println(bill.printItems());
	}
	
	/* Test calculation of total before service charge
	 * 
	 */
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
		MenuItem steakSandwich = new MenuItem("Steak Sandwich", 4.5,true, true);
		bill.addItem(steakSandwich);
		assertEquals(bill.getSubTotal(), 8.0, 0.00);
		
		System.out.println("***List Items & Sub Total***");
		System.out.println(bill.printItems());
		System.out.println("Sub Total:\t"+currencyFormat.format(bill.getSubTotal())+"\n");
	}
	
	/* Test calculation of service charge
	 * 
	 */
	@Test
	public void testGetServiceCharge(){
		
		Bill bill = new Bill();
		
		MenuItem cola = new MenuItem("Cola", 0.5);
		bill.addItem(cola);
		assertEquals(bill.getServiceCharge(), 0, 0.00);
		
		MenuItem cheeseSandwich = new MenuItem("Cheese Sandwich", 2.0, true);
		bill.addItem(cheeseSandwich);
		assertEquals(bill.getServiceCharge(), 0.25, 0.00);
		
		MenuItem steakSandwich = new MenuItem("Steak Sandwich", 4.5, true, true);
		bill.addItem(steakSandwich);
		assertEquals(bill.getServiceCharge(), 1.4, 0.00);
		
		System.out.println("***List Items, Sub Total & Service Charge***");
		System.out.println(bill.printItems());
		System.out.println("Sub Total:\t"+currencyFormat.format(bill.getSubTotal())+"\n");
		System.out.println("Service Charge: "+currencyFormat.format(bill.getServiceCharge()) +"\n");
	}
	
	/*
	 * Test the service charge cannot exceed 20.00
	 */
	@Test
	public void testMaxServiceCharge(){
		
		Bill bill = new Bill();
		// Add 30 steak sandwiches - total 135.00, service charge @ 20% = 27.00
		for(int i=0; i < 30; i++){
			
			MenuItem steakSandwich = new MenuItem("Steak Sandwich", 4.5, true, true);
			bill.addItem(steakSandwich);
			
		}
		// Should not exceed 20.0
		assertEquals(bill.getServiceCharge(), 20.0, 0.00);
	}
	
	/* Test to print out the items added
	 * 
	 */
	@Test
	public void testPrintBill() {
		
		Bill bill = new Bill();
	
		MenuItem cola1 = new MenuItem("Cola", 0.5);
		bill.addItem(cola1);
		MenuItem cola2 = new MenuItem("Cola", 0.5);
		bill.addItem(cola2);
		MenuItem coffee = new MenuItem("Coffee", 1.0);
		bill.addItem(coffee);
		MenuItem cheeseSandwich = new MenuItem("Cheese Sandwich", 2.0, true);
		bill.addItem(cheeseSandwich);
		MenuItem steakSandwich = new MenuItem("Steak Sandwich", 4.5, true, true);
		bill.addItem(steakSandwich);
		assertEquals(bill.printBill(), 
				"Item: Cola\t0.50\nItem: Cola\t0.50\nItem: Coffee\t1.00\n"
				+ "Item: Cheese Sandwich\t2.00\nItem: Steak Sandwich\t4.50\n"
				+ "Sub Total:\t"+currencyFormat.format(bill.getSubTotal())+"\n"
				+ "Service Charge:\t"+currencyFormat.format(bill.getServiceCharge()) +"\n"
				+ "Grand Total:\t"+currencyFormat.format(bill.getGrandTotal()) +"\n");
		
		System.out.println("***Show Bill***");
		System.out.println(bill.printItems());
		System.out.println("Sub Total:\t"+currencyFormat.format(bill.getSubTotal())+"\n");
		System.out.println("Service Charge: "+currencyFormat.format(bill.getServiceCharge()) +"\n");
		System.out.println("Grand Total:\t"+currencyFormat.format(bill.getGrandTotal())+"\n");
	}
}
