package com.regular;

public class RegExpTest {

	public static void main(String[] args) {
		String reg = "1(3|5|6|7|8|9)[0-9]{9}";
		System.out.println("13057561292".matches(reg));
	}

}
