package com.visa.training.stack;

public class FixedArrayStack implements Stack{

	private Object values[];
	private int top;
	
	FixedArrayStack(){
		values = new Object[100];
		top = -1;
	}
	
	@Override
	public void push(Object o) throws StackFullException{
		if(top == 99)
			throw new StackFullException("Stack Full Exception");
		top += 1;
		values[top] = o;
		
	}

	@Override
	public Object pop(){
		Object o = new Object();
		try {
		o =  values[top--];
		}
		catch(ArrayIndexOutOfBoundsException np) {
			System.out.println("Null pointer exception has occured");
		}
		return o;
	}
	
	public void printStack() {
		for(int i = top;i >= 0;i--)
			System.out.println(values[i].toString());
	}
	
}
