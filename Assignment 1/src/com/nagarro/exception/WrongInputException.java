/*
 * 
 */
package com.nagarro.exception;

/**
 * The Class WrongInputException.
 */
@SuppressWarnings("serial")
public class WrongInputException extends Exception {

	/**
	 * Instantiates a new wrong input exception.
	 *
	 * @param s
	 *            the s
	 */
	public WrongInputException(String s) {
		super(s);
	}

	/**
	 * Display exception.
	 *
	 * @param s
	 *            the s
	 */
	public static void DisplayException(String s) {
		System.out.println(s);
	}
}