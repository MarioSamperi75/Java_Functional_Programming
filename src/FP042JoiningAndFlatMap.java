import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FP042JoiningAndFlatMap {


	public static void main(String[] args) {
		
		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");
		
		// use joining to create a single string from many strings
		// the argument of joining is the separator
		System.out.println(courses.stream().collect(Collectors.joining(",")));
		
		// split: to get one by one the element of a list
		
		System.out.println(courses.stream().map(course -> course.split("")).collect(Collectors.toList())); 
		//	[[Ljava.lang.String;@3e3abc88, [Ljava.lang.String;@6ce253f1, [Ljava.lang.String;@53d8d10a, 
		//	[Ljava.lang.String;@e9e54c2, [Ljava.lang.String;@65ab7765, [Ljava.lang.String;@1b28cdfa,
		// 	How to go from a stream of arrays to a stream of strings? 
		// 	-> flatMap!!!!
		
		
		System.out.println(courses.stream().map(course -> course.split("")).flatMap(Arrays::stream).collect(Collectors.toList())); 
		// [S, p, r, i, n, g, S, p, r, i, n, g,  , B, o, o, t, A, P, I, M, i, c, r, o, s, e, r, v, i, c, e, s, A, W, S, P, C, F, A, z, u, r, e, D, o, c, k, e, r, K, u, b, e, r, n, e, t, e, s]

		// we can avoid duplicate by using distinct
		System.out.println(courses.stream().map(course -> course.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList())); 
		// [S, p, r, i, n, g,  , B, o, t, A, P, I, M, c, s, e, v, W, C, F, z, u, D, k, K, b]
		
		
		
		// Excercise creating tuples of the courses that has the same lenght
		// Strategy 
		// - 1) we duplicate the list
		// - 2) we maps every element of a list with every element of the other one
		// - 3) we remove (filter) all the elements that is associated with the the equivalent one (Spring, Spring) ...
		// - 4) we filter the mappings that contains elements with the same length
		
		
		//  1)
		List<String> courses2 = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");
		
		//	2) Creating ALL the tuples
		System.out.println(
				
				courses.stream().flatMap(course -> courses2.stream().map(course2 -> List.of(course, course2))).collect(Collectors.toList())
				
				);	// 	[[Spring, Spring], [Spring, Spring Boot], [Spring, API], [Spring, Microservices], [Spring, AWS], 
					//	[Spring, PCF], [Spring, Azure], [Spring, Docker], [Spring, Kubernetes], 
					//	[Spring Boot, Spring], [Spring Boot, Spring Boot], [Spring Boot, API], [Spring Boot, Microservices], [Spring Boot, AWS], 
					//	[Spring Boot, PCF], [Spring Boot, Azure], [Spring Boot, Docker], [Spring Boot, Kubernetes], 
					//	[API, Spring], [API, Spring Boot], [API, API], [API, Microservices], [API, AWS], 
					//	[API, PCF], [API, Azure], [API, Docker], [API, Kubernetes], 
					//	[Microservices, Spring], [Microservices, Spring Boot], [Microservices, API], [Microservices, Microservices], [Microservices, AWS], 
					//	[Microservices, PCF], [Microservices, Azure], [Microservices, Docker], [Microservices, Kubernetes], 
					//	[AWS, Spring], [AWS, Spring Boot], [AWS, API], [AWS, Microservices], [AWS, AWS], 
					//	[AWS, PCF], [AWS, Azure], [AWS, Docker], [AWS, Kubernetes], 
					//	[PCF, Spring], [PCF, Spring Boot], [PCF, API], [PCF, Microservices], [PCF, AWS], 
					//	[PCF, PCF], [PCF, Azure], [PCF, Docker], [PCF, Kubernetes], 
					//	[Azure, Spring], [Azure, Spring Boot], [Azure, API], [Azure, Microservices], 
					//	[Azure, AWS], [Azure, PCF], [Azure, Azure], [Azure, Docker], [Azure, Kubernetes], 
					//	[Docker, Spring], [Docker, Spring Boot], [Docker, API], [Docker, Microservices], 
					//	[Docker, AWS], [Docker, PCF], [Docker, Azure], [Docker, Docker], [Docker, Kubernetes], 
					//	[Kubernetes, Spring], [Kubernetes, Spring Boot], [Kubernetes, API], [Kubernetes, Microservices], 
					//	[Kubernetes, AWS], [Kubernetes, PCF], [Kubernetes, Azure], [Kubernetes, Docker], [Kubernetes, Kubernetes]]

					//	NOTICE how to use map in to map to perform a loop into a loop!!!
		
		
		//	3) eliminate all the tuples in which the element s repeated twice
		
		System.out.println(
				
				courses.stream().flatMap(course -> courses2.stream().map(course2 -> List.of(course, course2)))
				.filter(list -> !(list.get(0).equals(list.get(1)))).collect(Collectors.toList())
				
				);	//	[[Spring, Spring Boot], [Spring, API], [Spring, Microservices], [Spring, AWS], 
					//	[Spring, PCF], [Spring, Azure], [Spring, Docker], [Spring, Kubernetes], 
					//	[Spring Boot, Spring], [Spring Boot, API], [Spring Boot, Microservices], [Spring Boot, AWS], 
					//	[Spring Boot, PCF], [Spring Boot, Azure], [Spring Boot, Docker], [Spring Boot, Kubernetes], 
					//	[API, Spring], [API, Spring Boot], [API, Microservices], [API, AWS], 
					//	[API, PCF], [API, Azure], [API, Docker], [API, Kubernetes], 
					//	[Microservices, Spring], [Microservices, Spring Boot], [Microservices, API], [Microservices, AWS], 
					//	[Microservices, PCF], [Microservices, Azure], [Microservices, Docker], [Microservices, Kubernetes], 
					//	[AWS, Spring], [AWS, Spring Boot], [AWS, API], [AWS, Microservices], 
					//	[AWS, PCF], [AWS, Azure], [AWS, Docker], [AWS, Kubernetes], 
					//	[PCF, Spring], [PCF, Spring Boot], [PCF, API], [PCF, Microservices], 
					//	[PCF, AWS], [PCF, Azure], [PCF, Docker], [PCF, Kubernetes], 
					//	[Azure, Spring], [Azure, Spring Boot], [Azure, API], [Azure, Microservices], 
					//	[Azure, AWS], [Azure, PCF], [Azure, Docker], [Azure, Kubernetes], 
					//	[Docker, Spring], [Docker, Spring Boot], [Docker, API], [Docker, Microservices], 
					//	[Docker, AWS], [Docker, PCF], [Docker, Azure], [Docker, Kubernetes], 
					//	[Kubernetes, Spring], [Kubernetes, Spring Boot], [Kubernetes, API], [Kubernetes, Microservices], 
					//	[Kubernetes, AWS], [Kubernetes, PCF], [Kubernetes, Azure], [Kubernetes, Docker]]

		// - 4) we filter the mappings that contains elements with the same length
		
		
	System.out.println(
				
				courses.stream().flatMap(course -> courses2.stream().filter(course2 -> course2.length()==course.length()).map(course2 -> List.of(course, course2)))
				.filter(list -> !(list.get(0).equals(list.get(1)))).collect(Collectors.toList())
				
				); // [[Spring, Docker], [API, AWS], [API, PCF], [AWS, API], [AWS, PCF], [PCF, API], [PCF, AWS], [Docker, Spring]]
		
		
	}

}