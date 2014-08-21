/*
 * 
 */
package com.nagarro.view;

import java.util.List;

import com.nagarro.modal.Order;

/**
 * The Class Invoice.
 */
public class Invoice {

	/**
	 * Display.
	 *
	 * @param order
	 *            the order
	 */
	public void display(List<Order> order) {
		double salesTax, totalPrice = 0, finalPrice;
		for (int ouputTraverse = 0; ouputTraverse < order.size(); ouputTraverse++) {
			salesTax = order
					.get(ouputTraverse)
					.getItem()
					.getItemType()
					.getSalesTax(
							order.get(ouputTraverse).getItem().getItemPrice());
			finalPrice = order.get(ouputTraverse).getItemQuantity()
					* (salesTax + order.get(ouputTraverse).getItem()
							.getItemPrice());
			totalPrice = totalPrice + finalPrice;
			System.out.print("\nItem Name: "
					+ order.get(ouputTraverse).getItem().getItemName());
			System.out.print("\tItem Price: "
					+ order.get(ouputTraverse).getItem().getItemPrice());
			System.out.print("\tSales Tax: " + salesTax);
			System.out.print("\tFinal Price: "
					+ String.format("%.2f", finalPrice));
		}
		System.out.println("\nTotal Price: "
				+ String.format("%.2f", totalPrice));
	}
}