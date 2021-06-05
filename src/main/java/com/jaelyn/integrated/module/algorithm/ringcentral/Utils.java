package com.jaelyn.integrated.module.algorithm.ringcentral;

import com.google.common.util.concurrent.RateLimiter;

import java.util.List;
import java.util.UUID;

public class Utils {
	public static void main(String[] args) throws Exception{
		UUID.randomUUID();
		RateLimiter limiter = RateLimiter.create(10);
		System.out.println(Utils.class);
		Class<?> t = Class.forName("com.jaelyn.integrated.module.algorithm.ringcentral.Utils");
		System.out.println(t);
	}

	/**
	 * Question1, sort by firstName + lastName + ext,
	 * if firstName is the same then sort by lastName and
	 * ext, please note lastName and ext can be empty
	 * string or null.
	 *
	 **/
	public static List<Extension> sortByName(List<Extension> extensions) {
		return null;
	}


	/**
	 * Question2, sort extType, extType is a string and can
	 * be "User", "Dept", "AO", "TMO", "Other",
	 * sort by User > Dept > AO > TMO > Other;
	 *
	 **/
	public static List<Extension> sortByExtType(List<Extension> extensions) {
		return null;
	}

	/**
	 * Question3, sum all sales items by quarter
	 *
	 **/
	public static List<QuarterSalesItem> sumByQuarter(List<SaleItem> saleItems) {
		return null;
	}

	/**
	 * Question4, max all sales items by quarter
	 *
	 **/
	public static List<QuarterSalesItem> maxByQuarter(List<SaleItem> saleItems) {
		return null;
	}

	/**
	 * We have all Keys: 0-9;
	 * usedKeys is an array to store all used keys like :
	 * [2,3,4];
	 * We want to get all unused keys, in this example it
	 * would be: [0,1,5,6,7,8,9,]
	 */
	public static int[] getUnUsedKeys(int[] allKeys, int[] usedKeys) {
		return null;
	}

}
