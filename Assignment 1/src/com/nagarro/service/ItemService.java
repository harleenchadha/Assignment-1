/*
 * 
 */
package com.nagarro.service;

import java.util.List;

import com.nagarro.modal.Order;

/**
 * The Interface ItemService.
 */
public interface ItemService {

	/**
	 * Sets the order service.
	 *
	 * @param order
	 *            the new order service
	 */
	public void setOrderService(Order order);

	/**
	 * Gets the order service.
	 *
	 * @return the order service
	 */
	public List<Order> getOrderService();
}