/*
 * 
 */
package com.nagarro.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The Class InputData.
 */
public class InputData {

	/**
	 * Enter details.
	 *
	 * @return the string
	 */
	private BufferedReader br;

	public InputData() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * Enter details.
	 *
	 * @return the string
	 */
	public String enterDetails() {
		String input = "";
		System.out.println("Enter String: ");
		try {
			input = br.readLine().trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input;
	}

	/**
	 * Enter choice.
	 *
	 * @return true, if successful
	 */
	public boolean enterChoice() {
		String ch = "";
		Boolean valid = true;
		System.out
				.println("Do you want to enter details of any other item (y/n):");
		try {
			ch = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (ch.equalsIgnoreCase("n")) {
			valid = false;
		} else if (!ch.equalsIgnoreCase("y")) {
			System.out
					.println("Wrong Input entered. Please enter either y or n.");
			valid = enterChoice();
		}
		return valid;
	}

	@Override
	protected void finalize() throws Throwable {
		br.close();
	}
}