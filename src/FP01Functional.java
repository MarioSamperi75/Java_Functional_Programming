// example of functional programming
// We will write a simple program displaying all the numbers in a List
// first in a structured(traditional) way 
// and then with functional programming

import java.util.List;

public class FP01Functional {

	public static void main(String[] args) {
		printAllNumbersInListFunctional((List.of(23,12,5,14,11,24,18,9,5)));
		//you can use also Arrays.asList
	}

	// to semplify the code	
	// we have deleted our print method 
	// and used the System.out.println() method directly in the for each
	private static void printAllNumbersInListFunctional(List<Integer> numbers) {	
		//we convert the array to a stream!
		numbers.stream().
		forEach(System.out::println);
		//Method reference (nameOfTheClass::nameOfTheMethod)
	}

}
