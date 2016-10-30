package com.example.billingservice;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bill for ordered items
 * @author Tony
 *
 */
public class Bill {
	
	private List<MenuItem> items = new ArrayList<MenuItem>() ;
	private boolean containsFood = false;

	/**
	 * Add a menu item to bill
	 * @param item The item to add
	 */
	public void addItem(MenuItem item) {
		
		items.add(item);
		if(item.isFood()) this.containsFood  = true;		
		
	}

	/**
	 * Get the list of menu items added to this bill
	 * @return The list of items
	 */
	public List<MenuItem> getItems() {
		
		return items;
	}

	/**
	 * Return a string containing the current items in the bill
	 * @return The string list of items
	 */
	public String printItems() {
		
		String billStr = "";
		
		for(MenuItem item : items){
			
			billStr = billStr + "Item: "+item.getName() + "\t" + item.getPrice()+"\n";
			
		}
		
		return billStr;
	}

	/**
	 * Get the total cost of items added to bill prior to any service charge
	 * @return The cost
	 */
	public double getSubTotal() {
		
		double total = 0;
		
		for(MenuItem item : items){
			
			total += item.getPrice();
		}
		
		return total;
	}

	/**
	 * Get the service charge if the bill contains food
	 * @return
	 */
	public double getServiceCharge() {

		if(this.containsFood){
			
			return this.getSubTotal() * 0.1;
		}
		
		return 0;
	}

}
