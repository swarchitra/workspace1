package LamdbaDemo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.*;

public class BasicLambda {
	
	public static int eChecker(String s1, String s2) {
		if(s1.contains("e") && !(s2.contains("e")))
			return -1;
		else if(s2.contains("e"))
			return 1;
		return 0;
	}
	public static void main(String[] args) {
		String[] words = {"make", "an", "array", "containing", "a"};
		//BasicLambda bl = new BasicLambda();
		//     if EChecker is not static then bl::eChecker
		List<String> list = Arrays.asList(words);
		Collections.sort(list, (s1, s2) -> s1.length() - s2.length() );
		System.out.println("Shortest to longest");
		System.out.println(list);
		System.out.println("Longest to shortest");
		Collections.sort(list, (s1, s2) -> s2.length() - s1.length() );
		System.out.println(list);
		System.out.println("Alphabetically");
		Collections.sort(list, (s1, s2) -> s1.charAt(0) - s2.charAt(0) );
		System.out.println(list);
		System.out.println(" E comes first");
		/*Collections.sort(list, (s1, s2) -> {
			if(s1.contains("e") || s1.contains("E"))
				return -1;
			else
				return 1;
		} );
		System.out.println(list); */
		Collections.sort(list, BasicLambda :: eChecker );
		System.out.println(list);
	}

}
