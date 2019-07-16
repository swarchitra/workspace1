package com.visa.training.shape;

public class Circle implements Comparable <Circle>{

	public double radius;
	final double PI = 3.14d; 
	
	public Circle(double radius){
		this.radius = radius;
	}
	
	String getShape() {
		return "Circle";
	}
	
	public int compareTo(Circle c) {
		return (this.radius > c.radius)? 1: -1;
	}
	
	public double computeArea() {
		return this.radius * radius * PI;
	}
	
	public static void main(String[] args) {
		Circle c1 = new Circle(5);
		Circle c2 = new Circle(10);
		System.out.println(c1.computeArea());
		System.out.println(c2.computeArea());
		System.out.println(c1.getShape());

	}

}
