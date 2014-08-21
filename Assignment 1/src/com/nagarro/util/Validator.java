/*
 * 
 */
package com.nagarro.util;

import java.util.List;

import com.nagarro.dataStore.Constants;
import com.nagarro.exception.WrongInputException;
import com.nagarro.modal.Item;
import com.nagarro.modal.Order;

/**
 * The Class Validator.
 */
public class Validator {

	/**
	 * Validate string.
	 *
	 * @param inputString
	 *            the input string
	 * @return the order
	 * @throws WrongInputException
	 *             the wrong input exception
	 */
	public Order validateString(List<String> inputString)
			throws WrongInputException {
		Order order = new Order();
		Item item = new Item();
		// size of input string should be equal to twice the number of fields
		if (inputString.size() != (Constants.FIELDS_NAME.length * 2)) {
			throw new WrongInputException(
					"Wrong Input entered. Input should contain all the fields along with values");
		} else {
			if (!inputString.get(0).equalsIgnoreCase(Constants.FIRST_FIELD)) {
				throw new WrongInputException(
						"Wrong Input entered. Input should start with "
								+ Constants.FIRST_FIELD);
			} else {
				item.setItemName(inputString.get(1));
				for (int traverseInput = 2; traverseInput < inputString.size() - 1; traverseInput = traverseInput + 2) {
					checkField(inputString.get(traverseInput));

					if (inputString.get(traverseInput).equalsIgnoreCase(
							Constants.TYPE_KEY)) {
						item = checkAndSetTypeValue(item,
								inputString.get(traverseInput + 1));
					} else if (inputString.get(traverseInput).equalsIgnoreCase(
							Constants.QUANTITY_KEY)) {
						order = checkAndSetQuantityValue(order,
								inputString.get(traverseInput + 1));
					} else if (inputString.get(traverseInput).equalsIgnoreCase(
							Constants.PRICE_KEY)) {
						item = checkAndSetPriceValue(item,
								inputString.get(traverseInput + 1));
					}
				}
			}
		}
		order.setItem(item);
		return order;
	}

	/**
	 * Check field.
	 *
	 * @param field
	 *            the field
	 * @throws WrongInputException
	 *             the wrong input exception
	 */
	public void checkField(String field) throws WrongInputException {
		int traverseFields = 1;
		while (traverseFields < Constants.FIELDS_NAME.length) {
			if (Constants.FIELDS_NAME[traverseFields].equalsIgnoreCase(field)) {
				break;
			}
			traverseFields++;
		}
		// if some fields are missing or misspelled
		if (traverseFields == Constants.FIELDS_NAME.length) {
			throw new WrongInputException(
					"Wrong Input entered. Input should contain all the fields along with values");
		}
	}

	/**
	 * Check and set quantity value.
	 *
	 * @param order
	 *            the order
	 * @param quantityValue
	 *            the quantity value
	 * @return the order
	 * @throws WrongInputException
	 *             the wrong input exception
	 */
	public Order checkAndSetQuantityValue(Order order, String quantityValue)
			throws WrongInputException {
		if (!quantityValue.matches("[0-9]+")) {
			throw new WrongInputException("Invalid Item Quantity entered.");
		} else {
			if (Integer.parseInt(quantityValue) == 0) {
				throw new WrongInputException(
						"Invalid Item Quantity entered. Quantity cannot be 0.");
			}
			order.setItemQuantity(Integer.parseInt(quantityValue));
		}
		return order;
	}

	/**
	 * Check and set price value.
	 *
	 * @param item
	 *            the item
	 * @param priceValue
	 *            the price value
	 * @return the item
	 * @throws WrongInputException
	 *             the wrong input exception
	 */
	public Item checkAndSetPriceValue(Item item, String priceValue)
			throws WrongInputException {
		if (!(priceValue.matches("[0-9]+") || priceValue
				.matches("[0-9]+\\.[0-9]+"))) {
			throw new WrongInputException("Invalid Item Price entered.");
		} else {

			if (Double.parseDouble(priceValue) == 0) {
				throw new WrongInputException(
						"Invalid Item Price entered. Price cannot be 0.");
			}
			item.setItemPrice(Double.parseDouble(priceValue));
		}
		return item;
	}

	/**
	 * l Check and set type value.
	 *
	 * @param item
	 *            the item
	 * @param typeValue
	 *            the type value
	 * @return the item
	 * @throws WrongInputException
	 *             the wrong input exception
	 */
	public Item checkAndSetTypeValue(Item item, String typeValue)
			throws WrongInputException {
		boolean validType = false;
		for (ItemType itemType : ItemType.values()) {
			if (itemType.toString().equalsIgnoreCase(typeValue)) {
				validType = true;
				break;
			}
		}
		if (!validType) {
			throw new WrongInputException(
					"Invalid Item Type entered. Please enter the input again with Item Type either of them Raw/Manufactured/Imported");
		} else {
			item.setItemType(ItemType.valueOf(typeValue.toLowerCase()));
		}
		return item;
	}
}