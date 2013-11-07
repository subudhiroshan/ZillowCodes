package com.zillow;

/* Author: Roshan Subudhi
 * Purpose: Zillow Interview 
 * Date: 11/07/2013
 * Web: www.roshansubudhi.wordpress.co
 */

public class ZillowLong {

	static long stringToLong(String s)throws NumberFormatException{
		boolean sign = true; // sign of number, default positive
		long longNum = 0L;

		if (s.substring(0,1).equals("-")){
			sign = false;
		}

		for(int i = sign?0:1; i<s.length(); i++){ //handling the '-'(minus)
			longNum = longNum*10 + Integer.parseInt(s.substring(i, i+1));
		}

		if (sign){
			return longNum;
		}else{
			return longNum * -1;
		}
	}

	public static void main(String[] args) {
		long i;
		try{
			i = stringToLong("-123");

			if (i==-123){
				System.out.println("Success");
			}else{
				System.out.println("Failure");
			}
		}catch(NumberFormatException nfe){
			System.out.println("Only digits allowed");
		}
	}
}
