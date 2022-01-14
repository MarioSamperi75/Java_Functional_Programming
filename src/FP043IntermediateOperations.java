import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FP043IntermediateOperations {


	public static void main(String[] args) {
		
		//we want to do an Uppercase to the first element with length > 11
		
		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");
		
		courses.stream().peek(System.out::println).filter(course -> course.length()>11).map(String::toUpperCase).peek(System.out::println).findFirst();
		
	} 	//Spring
		//Spring Boot
		//API
		//Microservices
		//MICROSERVICES
	
	
		// Functional programming is efficient because all the intermediate operations are lazy! 
		// Before doing something FP wait the terminal operation (findFirst)
		// FP doesn't need to go through all the elements, because it know (in this case) that we need just the first occurrence
	
		// FP : go through the elements until it find the first that has length > 11 (microservices)
		//		It performs the upperCase and STOP.
		// Very efficient!
		

}