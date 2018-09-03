package com.caller;

public class Test {
	public static void main(String[] args) {
		Caller caller=new Caller();
		caller.setCallFunc(new Boss());
		caller.call();
	}
	
}
