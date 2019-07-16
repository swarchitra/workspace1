package com.visa.training.collections;

import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

import java.util.*;

public class DemoSet {
	private Set<String> set;
	private SortedSet<String> sortedSet;

	DemoSet() {
		set = new HashSet<String>();
		//set = new TreeSet<String> (); for sorting
		// set = new LinkedHashSet<String> (); // for remembering the insertion order
	}
	
	
	public void getValues() {
		Scanner scan  = new Scanner(System.in);
		String temp;
		int count = 0;
		while( count != 5) {
			temp = scan.next();
			if( !set.add(temp))
				System.out.println("Duplicate detected");
			else
				count++;
		}
		for( String s: set) {
			System.out.println(s);
		}
	}
	public static void main(String[] args) {
		DemoSet ds = new DemoSet();
		ds.getValues();
	}
}
