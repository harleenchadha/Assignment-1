/*
 * 
 */
package com.nagarro.dataStore;

/**
 * The Class Constants.
 */
public class Constants {

	/** The Constant SYMBOL. */
	public final static char SYMBOL = '-';

	/** The Constant INPUT_FORMAT. */
	public final static String INPUT_FORMAT = "Enter details in the following format:\n -name value -price value -quantity value -type raw/manufactured/imported \n -name should be the first element";

	/** The Constant FIRST_FIELD. */
	public final static String FIRST_FIELD = SYMBOL + "name";

	/** The Constant NAME_KEY. */
	public final static String NAME_KEY = SYMBOL + "name";

	/** The Constant TYPE_KEY. */
	public final static String TYPE_KEY = SYMBOL + "type";

	/** The Constant QUANTITY_KEY. */
	public final static String QUANTITY_KEY = SYMBOL + "quantity";

	/** The Constant PRICE_KEY. */
	public final static String PRICE_KEY = SYMBOL + "price";

	/** The Constant FIELDS_NAME. */
	public final static String FIELDS_NAME[] = { NAME_KEY, TYPE_KEY,
			QUANTITY_KEY, PRICE_KEY };

	/** The Constant TAX_PERCENT. */
	public final static double TAX_PERCENT = 12.5;

	/**
	 * Instantiates a new constants.
	 */
	private Constants() {

	}
}