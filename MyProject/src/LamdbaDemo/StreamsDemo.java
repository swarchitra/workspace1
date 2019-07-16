package LamdbaDemo;

import java.util.Arrays;
import java.util.*;
//import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
public class StreamsDemo {
	
	static void ex1() {
		List<String> words = Arrays.asList("hi", "hello", "how", "are", "you", "stream");
		words.stream().forEach( s -> System.out.println("  "+ s));	
	}
	
	static void ex2() {
		List<String> words = Arrays.asList("hi", "hello", "how", "are", "you", "stream");
		words.stream().forEach(System.out::println);
	}
	
	static void ex3() {
		List<String> words = Arrays.asList("hi", "hello", "how", "are", "you", "stream");
		//String[] excitingWords = (String[]) words.stream().map( s -> s.concat("!")).toArray();
		List<String> excitingWords = words.stream().map( s -> s.concat("!")).collect(Collectors.toList());
		List<String> eyeWords = words.stream().map( s -> s.replace("i", "eye")).collect(Collectors.toList());
		List<String> upperCaseWords = words.stream().map(String:: toUpperCase).collect(Collectors.toList());
		System.out.println(excitingWords);
		System.out.println(eyeWords);
		System.out.println(upperCaseWords);
	}
	
	static void ex4() {
		List<String> words = Arrays.asList("hi", "hello", "box", "are", "you", "stream");
		//String[] excitingWords = (String[]) words.stream().map( s -> s.concat("!")).toArray();
		List<String> excitingWords = words.stream().filter(s-> s.length() < 4).collect(Collectors.toList());
		List<String> eyeWords = words.stream().filter( s -> s.contains("b")).collect(Collectors.toList());
		List<String> upperCaseWords = words.stream().filter(s -> s.length()%2 == 0).collect(Collectors.toList());
		System.out.println(excitingWords);
		System.out.println(eyeWords);
		System.out.println(upperCaseWords);
	}
	
	//// PART 2
	
	static void ex5() {
		List<String> words = Arrays.asList("hi", "hello", "box", "are", "you", "stream");
		String concattedString = words.stream().reduce("", (s1,s2) -> s1.toUpperCase() + s2.toUpperCase());
		System.out.println(concattedString);
		concattedString = words.stream().map(String::toUpperCase).reduce("", String::concat);
		System.out.println(concattedString);
		String opString = words.stream().reduce((s1,s2) -> s1.toUpperCase() + "," + s2.toUpperCase()).get();
		System.out.println(opString.toString());

	}
	//PART3
	
	static void ex6() {
		double[] array = new Random().doubles(1000).toArray();
		//double[] array = {4, 16};
		double sumOfSQRT = DoubleStream.of(array).map(n -> Math.sqrt(n)).reduce((n1, n2)-> n1 + n2).getAsDouble() ;
		System.out.println(sumOfSQRT);
		sumOfSQRT = DoubleStream.of(array).parallel().map(n -> Math.sqrt(n)).reduce((n1, n2)-> n1 + n2).getAsDouble() ;
		System.out.println(sumOfSQRT);
		sumOfSQRT = DoubleStream.of(array).reduce((n1, n2)-> Math.sqrt(n1) + Math.sqrt(n2)).getAsDouble() ;
		System.out.println(sumOfSQRT);
	}
	
	
	
	
	
	public static void main(String[] args) {
		//ex1();
		//ex2();
		//ex3()'
		//ex4();
		//ex5();
		ex6();
	}

}
