import java.util.List;

public class FP02StreamOperations {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		
		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");
		
		// distinct remove duplicates
		System.out.println("distinct remove duplicates");
		numbers.stream()
			.distinct()
			.forEach(x->System.out.println(x));
		
		System.out.println();
		
		// sorted sorts items
		System.out.println("sorted sorts items");
		numbers.stream()
		.sorted()
		.forEach(System.out::println);
		
		System.out.println();
		
		//of course you can combine
		System.out.println("of course you can combine");
		numbers.stream()
		.distinct()
		.sorted()
		.forEach(System.out::println);
		
		System.out.println();
		
		//sort works also with strings
		
		System.out.println("sort works also with strings");
		courses.stream()
		.sorted()
		.forEach(System.out::println);
		
		
		
		
	}

}
