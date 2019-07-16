package com.visa.training.stack;

public class GenericStack <E>{
	private E[] elements;
	private int top;
	GenericStack(){
		top = -1;
	}
	
	
	void push(E element) {
		elements[++top] = element;
	}
	
	E pop() {
		System.out.println(elements[top] + " --> is popped!");
		return elements[top--];
	}
	
	public static void main(String[] args) {
		GenericStack<Integer> is;
	}
	
}
