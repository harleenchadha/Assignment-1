/*
 * 
 */
package com.nagarro.dao;

import java.util.List;

import com.nagarro.modal.Order;

/**
 * The Interface ItemDao.
 */
public interface ItemDao {

	/**
	 * Sets the order dao.
	 *
	 * @param order
	 *            the new order dao
	 */
	public void setOrderDao(Order order);

	/**
	 * Gets the order dao.
	 *
	 * @return the order dao
	 */
	public List<Order> getOrderDao();
}
