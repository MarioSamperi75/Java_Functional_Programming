import java.util.Comparator;
import java.util.List;

public class FP02StreamOperations {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		
		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");
		
		// distinct remove duplicates
		System.out.println("distinct remove duplicates:");
		numbers.stream()
			.distinct()
			.forEach(x->System.out.println(x));
		
		System.out.println();
		
		// sorted sorts items
		System.out.println("sorted sorts items:");
		numbers.stream()
		.sorted()
		.forEach(System.out::println);
		
		System.out.println();
		
		//of course you can combine
		System.out.println("of course you can combine:");
		numbers.stream()
		.distinct()
		.sorted()
		.forEach(System.out::println);
		
		System.out.println();
		
		//sort works also with strings
		System.out.println("sort works also with strings:");
		courses.stream()
		.sorted()
		.forEach(System.out::println);
		
		System.out.println();
		
		//you can use Comparator class to perform many operations
		//reverseOrder
		System.out.println("reverse order:");
		courses.stream()
		.sorted(Comparator.reverseOrder())  //the default is Comparator.naturalOrder()
		.forEach(System.out::println);
		
		System.out.println();
		
		//Comparator.comparing(lambda expression)
		System.out.println("sorted by the length of the string:");
		courses.stream()
		.sorted(Comparator.comparing(str -> str.length()))
		.forEach(System.out::println);	
		
		
		
		
	}

}
