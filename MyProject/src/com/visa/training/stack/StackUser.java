package com.visa.training.stack;

public class StackUser {
	
	public void fillStack(Stack stack) {
		for(int i = 0; i < 101; i++) {
			try {
			stack.push(Math.random());
			}
			catch(StackFullException s) {
				System.out.println("Stack is already full!!");
			}
		}
	}
	
	public void emptyStack(Stack stack) {
		
		for(int i = 0; i< 102; i++) {
			System.out.println(stack.pop() + " is popped ");
		}
	}
	
	
	
}
