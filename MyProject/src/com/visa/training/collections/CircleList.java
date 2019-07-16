package com.visa.training.collections;

import com.visa.training.shape.Circle;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CircleList {
	private List<Circle> cl;
	
	public CircleList()
	{
		cl = new ArrayList<Circle>();
	}
	public void createCircles() {
		while(true) {
			double temp = Math.random();
			if(temp < 0.01) {
				break;
			}
			Circle c = new Circle(temp);
			cl.add(c);
		}
		
		System.out.println(" The number of circles created are "+ cl.size());
		for(Circle c: cl) {
			System.out.println("The area of the circle with radius "+ c.radius + " is "+ c.computeArea());
		}
	}
	
	public void removeCircles() {
		Iterator <Circle> i = cl.iterator();
		while(i.hasNext()) {
			Circle c = (Circle) i.next();
			if(c.radius < 0.5)
				//cl.remove(cl.indexOf(c));
				i.remove();
		}
		System.out.println("The number of circles after deletion are "+ cl.size());
		
	}
	
	public static void main(String[] args) {
		CircleList cl = new CircleList();
		cl.createCircles();
		Collections.sort(cl.cl);
		for (Circle c: cl.cl) {
			System.out.println(c.radius);
		}
		//System.out.println(cl.cl);
		cl.removeCircles();
	}
}
