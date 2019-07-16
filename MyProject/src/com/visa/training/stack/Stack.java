package com.visa.training.stack;

public interface Stack {
	public void push(Object o) throws StackFullException;
	public Object pop();
}
