package com.visa.training.collections;

import java.util.*;

class MyComparator implements Comparator <String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.length() - o2.length();
	}
}

public class SortDemo {
	public <T> void sort(List<T> l, Comparator<? super T> c){
		
	}
	
	public <T> T findMax( List<T> l){
		return null;
	}
	
	
	public static void demo() {
		String[] words = {"hello","bye"};
		List<String> l = Arrays.asList(words);
		//Collections.sort(l, new MyComparator());
		Collections.sort (l, new Comparator<String>() {
			public int compare( String s1, String s2) {
				return s1.length() - s2.length();
			}
		});
		Collections.sort(l , (s1, s2) -> 1);
		System.out.println(l);
	}
	public static void main(String[] args) {
		SortDemo sd = new SortDemo();
		demo();
	}
	
}
