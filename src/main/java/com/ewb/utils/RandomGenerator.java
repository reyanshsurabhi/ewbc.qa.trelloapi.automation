package com.ewb.utils;

import java.util.Random;

/**
 * @author Raj Surabhi
 * @date 09-March-2018
 */

public class RandomGenerator {

	/**
	 * This method generates random string
	 * 
	 * @return
	 */
	public static String randomString(int length) {
		Random r = new Random(); // perhaps make it a class variable so you don't make a new one every time
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			char c = (char) (r.nextInt((int) (Character.MAX_VALUE)));
			sb.append(c);
		}
		return sb.toString();
	}

	/**
	 * This method generates random numbers
	 * 
	 * @return int
	 */
	public static int getRandomNumber() {
		int rNumber = 0;
		rNumber = (int) ((Math.random() * 9000000) + 1000000);
		System.out.print((rNumber));
		return rNumber;
	}
}
