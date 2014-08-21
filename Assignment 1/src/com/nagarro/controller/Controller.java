/*
 * 
 */
package com.nagarro.controller;

import com.nagarro.dataStore.Constants;
import com.nagarro.exception.WrongInputException;
import com.nagarro.modal.Order;
import com.nagarro.service.ItemService;
import com.nagarro.service.ItemServiceImpl;
import com.nagarro.util.Parser;
import com.nagarro.util.Validator;
import com.nagarro.view.InputData;
import com.nagarro.view.Invoice;

/**
 * The Class Controller.
 */
public class Controller {

	/** The input data. */
	private InputData inputData;

	/** The parser. */
	private Parser parser;

	/** The validator. */
	private Validator validator;

	/** The itemservice. */
	private ItemService itemservice;

	/** The invoice. */
	private Invoice invoice;

	/** The order. */
	private Order order;

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		inputData = new InputData();
		parser = new Parser();
		validator = new Validator();
		itemservice = new ItemServiceImpl();
		invoice = new Invoice();
		System.out.println(Constants.INPUT_FORMAT);
	}

	/**
	 * Control.
	 */
	public void control() {
		String input;
		do {
			try {
				input = inputData.enterDetails();
				order = validator.validateString(parser.parsing(input));
				itemservice.setOrderService(order);
				if (!inputData.enterChoice()) {
					break;
				}
			} catch (WrongInputException wie) {
				WrongInputException.DisplayException(wie.getMessage());
			}

		} while (true);

		invoice.display(itemservice.getOrderService());
	}
}