/*
 * 
 */
package com.nagarro.modal;

/**
 * The Class Order.
 */
public class Order {
	
	/** The item. */
	private Item item = new Item();
	
	/** The item quantity. */
	private int itemQuantity;

	/**
	 * Gets the item.
	 *
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * Sets the item.
	 *
	 * @param item the new item
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * Gets the item quantity.
	 *
	 * @return the item quantity
	 */
	public int getItemQuantity() {
		return itemQuantity;
	}

	/**
	 * Sets the item quantity.
	 *
	 * @param itemQuantity the new item quantity
	 */
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

}