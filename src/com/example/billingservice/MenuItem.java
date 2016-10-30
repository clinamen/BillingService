package com.example.billingservice;
/**
 * Represents a menu item
 * @author Tony
 *
 */
public class MenuItem {

	private String name;
	private double price;

	/**
	 * Construct a new menu item
	 * @param name	The name of the menu item
	 * @param price	The price of the menu item
	 */
	public MenuItem(String name, double price) {
		this.name = name;
		this.price = price;
	}

}
