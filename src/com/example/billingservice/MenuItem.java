package com.example.billingservice;

/**
 * Represents a menu item
 * @author Tony
 *
 */
public class MenuItem {

	private String name;
	private double price;
	private boolean food = false;
	private boolean hotFood = false;


	/**
	 * Construct a new non food menu item
	 * @param name	The name of the menu item
	 * @param price	The price of the menu item
	 */
	public MenuItem(String name, double price) {
		this.name = name;
		this.price = price;

	}
	
	/**
	 * Construct a new menu item
	 * @param name	The name of the menu item
	 * @param price	The price of the menu item
	 * @param food True is item is food
	 */
	public MenuItem(String name, double price, boolean food) {
		this.name = name;
		this.price = price;
		this.food = food;
	}
	
	/**
	 * Construct a new menu item
	 * @param name	The name of the menu item
	 * @param price	The price of the menu item
	 * @param food True is item is food
	 * @param hotFood True is item is hot food
	 */
	public MenuItem(String name, double price, boolean food, boolean hotFood) {
		this.name = name;
		this.price = price;
		this.food = food;
		this.hotFood  = hotFood;
	}
	
	/**
	 * Is the menu item hot food
	 * @return True if is food
	 */
	public boolean isHotFood() {
		return hotFood;
	}

	/**
	 * Is the menu item food
	 * @return True if is food
	 */
	public boolean isFood() {
		return food;
	}

	/**
	 * Get the name of the item
	 * @return The name of the menu item
	 */
	public String getName() {
		
		return this.name;
	}

	/**
	 * Get the price of the item
	 * @return The price of the menu item
	 */
	public double getPrice() {
		
		return this.price;
	}

}
