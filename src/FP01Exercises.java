// We want to display just the even the numbers in a List
// first in a structured(traditional) way 
// and then with functional programming

import java.util.List;

public class FP01Exercises {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(23,12,5,14,11,24,18,9,5);
		System.out.println("\nExcercise1\n");
		printOddNumbersInListFunctional(numbers);

		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");
		System.out.println("\nExcercise2");
		printAllCourses(courses);
	
		System.out.println("\nExcercise3");
		printAllSpringCourses(courses);
		
		System.out.println("\nExcercise4");
		printAllCourseMoreThan4Letters(courses);
		
		System.out.println("\nExcercise5");
		printTheCubeOfOddNumbers(numbers);
		
		System.out.println("\nExcercise6");
		printLengthOfCoursesName(courses);
	}
	



	private static void printOddNumbersInListFunctional(List<Integer> numbers) {	
		numbers.stream()
		//.filter(FP01Functional::isEven)	// Filter - only allow even numbers
		.filter(number -> number%2 != 0 )	// Lambda expression
		.forEach(System.out::println);
	}
	
	private static void printAllCourses(List<String> courses) {	
		courses.stream()
		.forEach(System.out::println);
	}
	
	private static void printAllSpringCourses(List<String> courses) {	
		courses.stream()
		.filter(course -> course.contains("Spring"))
		.forEach(System.out::println);
	}
	
	private static void printAllCourseMoreThan4Letters(List<String> courses) {	
		courses.stream()
		.filter(course -> course.length() >= 4)
		.forEach(System.out::println);
	}
	
	private static void printTheCubeOfOddNumbers(List<Integer> numbers) {
		numbers.stream()
		.filter(number -> number%2 != 0 )
		.map(number -> number * number * number)
		.forEach(System.out::println);		
	}
	
	
	private static void printLengthOfCoursesName(List<String> courses) {
		courses.stream()
		.map(course -> course + " " + course.length())
		.forEach(System.out::println);
		
	}

	

}
