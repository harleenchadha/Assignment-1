/*
 * 
 */
package com.nagarro.service;

import java.util.List;

import com.nagarro.dao.ItemDao;
import com.nagarro.dao.ItemDaoImpl;
import com.nagarro.modal.Order;

/**
 * The Class ItemServiceImpl.
 */
public class ItemServiceImpl implements ItemService {

	/** The item dao. */
	ItemDao itemDao = new ItemDaoImpl();

	@Override
	public List<Order> getOrderService() {
		return itemDao.getOrderDao();
	}

	@Override
	public void setOrderService(Order order) {
		itemDao.setOrderDao(order);
	}
}