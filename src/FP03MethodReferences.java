// use collect(Collectors.toList()) to create a new list from an existing one

// stream operations summary:
// itemediate operations - takes a stream and returns a stream - map, filter, sorted, distinct
// terminal operation - takes a stream and returns something different - forEach, reduce, collect


import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FP03MethodReferences {

	
	private static void print (String s) {
		System.out.println(s);	
	}
		
	

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");
		
		courses.stream()
		.map(str->str.toUpperCase())
		.forEach(str -> System.out.println(str));
		System.out.println();
		
		//we can use Method reference with any static method provided by Java
		courses.stream()
		.map(str->str.toUpperCase())
		.forEach(System.out::println);
		System.out.println();
		
		//we can also use method references with a static method that we created in our class
		courses.stream()
		.map(str->str.toUpperCase())
		.forEach(FP03MethodReferences::print);
		System.out.println();
		
		//method references with instances variables (str in map, we use the name of the class)
		courses.stream()
		.map(String::toUpperCase)
		.forEach(FP03MethodReferences::print);
		System.out.println();
		
		// method references for constructor references
		// when we need to create a new object
		Supplier<String> supplier = () -> new String();
		//becomes
		Supplier<String> supplier2 = String::new;
		
	}

}