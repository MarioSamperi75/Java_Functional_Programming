// example of functional programming
// We will write a simple program displaying all the numbers in a List
// first in a structured(traditional) way 
// and then with functional programming

import java.util.List;

public class FP01Structured {

	public static void main(String[] args) {
		printAllNumbersInListStructured((List.of(23,12,5,14,11,24,18,9,5)));
		//you can use also Arrays.asList
	}

	private static void printAllNumbersInListStructured(List<Integer> numbers) {
		for(int number:numbers) {
			System.out.println(number);
		}		
	}

}
