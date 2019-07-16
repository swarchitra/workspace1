package com.visa.training.stack;

public class StackApp {
	public static void main(String[] args) {
		StackUser user = new StackUser();
		Stack s = new FixedArrayStack();
		user.fillStack(s);
		user.emptyStack(s);
	}
	
}
