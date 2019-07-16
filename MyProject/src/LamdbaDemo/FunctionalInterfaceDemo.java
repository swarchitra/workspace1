package LamdbaDemo;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.BinaryOperator;

public class FunctionalInterfaceDemo {
	
	public static String betterString(String s1, String s2, StringInterface function) {
		boolean bool = function.isBetter(s1,s2);
		if(bool)
			return s1;
		return s2;
	}
	
	//PART 2 - 1
	public static List<String> allMatches(List<String> strings, Predicate<String> condition) {
		List<String> newList = new ArrayList<>();
		for(String word: strings) {
			if(condition.test(word))
				newList.add(word);
		}
		return newList;
	}
	
	//PART2 - 2
	
	public static <T> List<T> allMatches1(List<T> strings, Predicate<T> condition) {
		List<T> newList = new ArrayList<>();
		for(T word: strings) {
			if(condition.test(word))
				newList.add(word);
		}
		return newList;
	}
	
	//PART2_3
	
	/*public static List<String> transformedList(List<String> strings, Function<String, String> function){
		List<String> newString = new ArrayList<>();
		for(String string: strings) {
			newString.add(function.apply(string));
		}
		return newString;
	}*/
	public static <T,R> List<R> transformedList(List<T> strings, Function<T, R> function){
		List<R> newString = new ArrayList<>();
		for(T string: strings) {
			newString.add(function.apply(string));
		}
		return newString;
	}
	

	public static void part2_3() {
		List<String> s1,s2;
		String[] words = {"all","matches","list","strings", "bangalore", "balloon"};
		s1 = Arrays.asList(words);
		s2 = transformedList(s1, s-> s + "!");
		System.out.println(s2);
		s2 = transformedList(s1, s-> s.replace("i", "eye"));
		System.out.println(s2);
		s2 = transformedList(s1, String::toUpperCase);
		System.out.println(s2);
		List<Integer> il;
		il = transformedList(s1, String::length);
		System.out.println(il);
		List<Boolean> bl;
		bl = transformedList(s1, s -> s.contains("i"));
		System.out.println(bl);
		
	}
	public static void part2_1() {
		List<String> s1,s2;
		String[] words = {"all","matches","list","strings", "bangalore", "balloon"};
		s1 = Arrays.asList(words);
		s2 = allMatches1(s1, s -> s.length() < 4);
		System.out.println(s2);
		s2 = allMatches1(s1, s->s.contains("b"));
		System.out.println(s2);
		s2 = allMatches1(s1, s->s.length()%2 == 0);
		System.out.println(s2);
		Integer[] numbers = {100, 570, 3050, 400, 2500, 600};
		List<Integer> il = Arrays.asList(numbers);
		List<Integer> il1;
		il1 = allMatches1(il, num -> num > 500);
		System.out.println(il1);
		Predicate<String> p1 = s -> s.length() < 4;
		Predicate<String> p2 = s-> (s.contains("a"));
		s2 = allMatches(s1, p1.or(p2));
		System.out.println(s2);
	}
	public static <T>  T operate2Ele(T l1, T l2,  BinaryOperator<T> combiner){
		T l3;
		l3 = combiner.apply(l1, l2);
		return l3;
		
	}
	public static void main(String[] args) {
		/*System.out.println(FunctionalInterfaceDemo.betterString("Hello", "Hi", (s1, s2) -> s1.length() > s2.length()));
		System.out.println(FunctionalInterfaceDemo.betterString("Hello", "Hi", (s1, s2) -> false));
		*/
		part2_1();
		Integer i1 = new Integer(5);
		Integer i2 = new Integer(6);
		BinaryOperator<Integer> bOp = (a, b) -> a + b;
		System.out.println(operate2Ele(i1, i2, bOp));
		bOp = (a, b) -> a * b;
		System.out.println(operate2Ele(i1, i2, bOp));
		Integer[] numbers = {1,2,3,4,5};
		List<Integer> nums = new ArrayList<>();
		nums = Arrays.asList(numbers);
		nums.set(0, 100);
		}
	
}
