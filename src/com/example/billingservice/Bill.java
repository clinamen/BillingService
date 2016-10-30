package com.example.billingservice;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bill for ordered items
 * @author Tony
 *
 */
public class Bill {
	
	public static double SERVICE_CHARGE_FOOD = 0.1;
	public static double SERVICE_CHARGE_HOT_FOOD = 0.2;
	public static double SERVICE_CHARGE_MAX = 20;
	
	private List<MenuItem> items = new ArrayList<MenuItem>() ;
	private boolean containsFood = false;
	private boolean containsHotFood;
	
	private DecimalFormat currencyFormat = new DecimalFormat("0.00");

	/**
	 * Add a menu item to bill
	 * @param item The item to add
	 */
	public void addItem(MenuItem item) {
		
		items.add(item);
		if(item.isFood()) this.containsFood  = true;
		if(item.isHotFood()) this.containsHotFood  = true;
		
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
			
			billStr = billStr + "Item: "+item.getName() + "\t" + currencyFormat.format(item.getPrice())+"\n";
			
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
	 * Get the service charge if the bill contains food.
	 * Different rates are charged for cold food and hot food.
	 * A maximum charge applies
	 * @return
	 */
	public double getServiceCharge() {
		
		double serviceCharge = 0;

		if(this.containsHotFood){
			
			serviceCharge = roundDouble(this.getSubTotal() * SERVICE_CHARGE_HOT_FOOD);
		}
		else if(this.containsFood){
			
			serviceCharge = roundDouble(this.getSubTotal() * SERVICE_CHARGE_FOOD);
		}
		 
		if(serviceCharge > SERVICE_CHARGE_MAX) {
			serviceCharge = SERVICE_CHARGE_MAX;
		}
		
		return serviceCharge;
	}
	
	/*
	 * Utility method to round a double value to 2 decimal places
	 */
	private double roundDouble(double d){
		
		BigDecimal bd = new BigDecimal(d).setScale(2, RoundingMode.HALF_EVEN);
		return bd.doubleValue();
	}

}
