package com.visa.training.shape;

public class Rectangle {
	private int width;
	private int height;
	
	Rectangle(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	String getShape() {
		return "Rectangle";
	}
	
	int computeArea() {
		return this.width * this.height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public void showDetails() {
		System.out.println("The rectangle of height "+ this.getHeight() + " and width "+ this.getWidth() + " has area of "+ this.computeArea());
	}
	
}
