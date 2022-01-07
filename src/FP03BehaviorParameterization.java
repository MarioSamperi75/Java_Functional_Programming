import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class FP03BehaviorParameterization {


	//Exercise find the functional interface behind Integer.sum
	public static void main(String[] args) {	
		
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		
		System.out.println("\neven numbers");
		numbers.stream()
		.filter(x->x%2==0)
		.forEach(System.out::println);
		
		
		System.out.println("\nodd numbers");
		numbers.stream()
		.filter(x->x%2!=0)
		.forEach(System.out::println);
		
		//  to create a single method that has as parameters the logic, the behavior (and the numbers of course)
		// 	how to add the specific operation you have to perform AS ARGUMENT in the call?
		// ----> behavior parameterisaton
		
		
		
		Predicate<? super Integer> oddPredicate = x->x%2!=0;
		
		Predicate<? super Integer> evenPredicate = x->x%2==0;
		
		
		System.out.println("\neven numbers");
		filterAndPrint(numbers,evenPredicate);
		
		System.out.println("\nodd numbers");
		filterAndPrint(numbers, oddPredicate);
		
		
		// now we can also create our specific predicate just inline (with a lambda!)
		
		System.out.println("\ndivisible by three");
		filterAndPrint(numbers, x->x%3==0);
		

	}

	private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
		numbers.stream()
		.filter(predicate)
		.forEach(System.out::println);
	}

}
