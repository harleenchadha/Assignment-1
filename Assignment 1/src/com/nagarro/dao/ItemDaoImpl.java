/*
 * 
 */
package com.nagarro.dao;

import java.util.ArrayList;
import java.util.List;

import com.nagarro.modal.Order;

/**
 * The Class ItemDaoImpl.
 */
public class ItemDaoImpl implements ItemDao {

	/** The order. */
	List<Order> order = new ArrayList<>();

	@Override
	public void setOrderDao(Order order) {
		this.order.add(order);
	}

	@Override
	public List<Order> getOrderDao() {
		return order;
	}
}
