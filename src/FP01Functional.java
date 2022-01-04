// We want to display just the even the numbers in a List
// first in a structured(traditional) way 
// and then with functional programming

import java.util.List;

public class FP01Functional {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(23,12,5,14,11,24,18,9,5);
		//printAllNumbersInListFunctional(numbers);
		//printEvenNumbersInListFunctional(numbers);
		printSquaresOfEvenNumbersInListFunctional(numbers);
		
	}



	private static void printAllNumbersInListFunctional(List<Integer> numbers) {	
		numbers.stream().
		forEach(System.out::println);
	}
	
	private static void printEvenNumbersInListFunctional(List<Integer> numbers) {	
		numbers.stream()
		//.filter(FP01Functional::isEven)	// Filter - only allow even numbers
		.filter(number -> number%2 == 0 )	// Lambda expression
		.forEach(System.out::println);
	}
	
	private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers) {	
		numbers.stream()
		// with map we create a new array 
		// and we have the possibility to trasform every item
		.filter(number -> number%2 == 0 )
		.map(number -> number * number) 
		.forEach(System.out::println);
	}


}

// filter do a check: only if the number is even, it's included in the forEach   
