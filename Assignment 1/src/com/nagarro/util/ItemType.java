/*
 * 
 */
package com.nagarro.util;

import com.nagarro.dataStore.Constants;

/**
 * The Enum ItemType.
 */
public enum ItemType {

	/** The raw. */
	raw {

		@Override
		public double getSalesTax(double itemPrice) {
			return ((Constants.TAX_PERCENT * itemPrice) / 100);
		}

	},

	/** The manufactured. */
	manufactured {

		@Override
		public double getSalesTax(double itemPrice) {
			return ((Constants.TAX_PERCENT * itemPrice) / 100)
					+ ((2 * (itemPrice + ((Constants.TAX_PERCENT * itemPrice) / 100))) / 100);
		}

	},

	/** The imported. */
	imported {

		@Override
		public double getSalesTax(double itemPrice) {
			double finalCost = ((10 * itemPrice) / 100) + itemPrice
					+ ((Constants.TAX_PERCENT * itemPrice) / 100);
			double salesTax = 0.0;

			if (finalCost <= 100) {
				salesTax = finalCost + 5;
			} else if (finalCost > 100 && finalCost <= 200) {
				salesTax = finalCost + 10;
			} else if (finalCost > 200) {
				salesTax = finalCost + ((5 * finalCost) / 100);
			}
			return salesTax;
		}

	};

	/**
	 * Gets the sales tax.
	 *
	 * @param itemPrice
	 *            the item price
	 * @return the sales tax
	 */
	public abstract double getSalesTax(double itemPrice);
}