/*
 * 
 */
package com.nagarro.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.nagarro.dataStore.Constants;
import com.nagarro.exception.WrongInputException;

/**
 * The Class Parser.
 */
public class Parser {
	
	/**
	 * Creates the tokens.
	 *
	 * @param input            the input
	 * @return the list
	 * @throws WrongInputException the wrong input exception
	 */
	public List<String> parsing(String input) throws WrongInputException {
		List<String> inputString = new ArrayList<>();
		if (checkNotNull(input)) {
			StringTokenizer st = new StringTokenizer(input);
			inputString.clear();
			while (st.hasMoreTokens())
				inputString.add(st.nextToken());
		}
		inputString = nameParsing(inputString);
		return inputString;
	}

	/**
	 * Name parsing.
	 *
	 * @param inputString the input string
	 * @return the list
	 */
	private List<String> nameParsing(List<String> inputString) {
		int locNameValues = 1, locateField, locName;
		while (true) {
			if (inputString.get(locNameValues).charAt(0) == Constants.SYMBOL) {
				for (locateField = 1; locateField < Constants.FIELDS_NAME.length; locateField++) {
					if (inputString.get(locNameValues).equalsIgnoreCase(
							Constants.FIELDS_NAME[locateField])) {
						break;
					}
				}
				if (!(locateField == Constants.FIELDS_NAME.length)) {
					break;
				}
			}
			locNameValues++;
		}
		for (locName = 2; locName < locNameValues; locName++) {
			inputString.set(1, inputString.get(1) + " " + inputString.get(2));
			inputString.remove(2);
		}
		return inputString;
	}

	/**
	 * Check not null.
	 *
	 * @param input the input
	 * @return true, if successful
	 * @throws WrongInputException the wrong input exception
	 */
	private boolean checkNotNull(String input) throws WrongInputException {
		if (input.equals(""))
			throw new WrongInputException(
					"Wrong Input entered. String cannot be empty");
		return true;
	}
}