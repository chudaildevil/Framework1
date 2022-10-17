package com.crm.generic_utilities;

import java.util.Random;

public class Java_Utility {
	
	/**
	 * this method is used to avoid duplicate
	 * @return
	 * "author Divya
	 */
	public int getRandomNum() {
		Random ran= new Random();
		int RanNum=ran.nextInt(1000);
		return RanNum;
	}

	
}
