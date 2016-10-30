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

	/**
	 * Add a menu item to bill
	 * @param item The item to add
	 */
	public void addItem(MenuItem item) {
		
		items.add(item);
		
	}

	/**
	 * Get the list of menu items added to this bill
	 * @return The list of items
	 */
	public List<MenuItem> getItems() {
		// TODO Auto-generated method stub
		return items;
	}

}
