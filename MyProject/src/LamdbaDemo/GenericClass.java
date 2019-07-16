package LamdbaDemo;
import com.visa.training.shape.*;
public class GenericClass {
		public static <T> T betterEntry(T s1, T s2, GenericInterface<T> function) {
			boolean bool = function.isBetter(s1,s2);
			if(bool)
				return s1;
			return s2;
		}
		
		public static void main(String[] args) {
			System.out.println(GenericClass.betterEntry("Hello", "Hi", (s1, s2) -> s1.length() > s2.length()));
			System.out.println(GenericClass.betterEntry(new Circle(5), new Circle(6), (c1, c2) -> c1.radius > c2.radius));
		}

	}


