// We want to display just the even the numbers in a List
// first in a structured(traditional) way 
// and then with functional programming

import java.util.List;

public class FP01Structured {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(23,12,5,14,11,24,18,9,5);
		//printAllNumbersInListStructured(numbers);
		printEvenNumbersInListStructured(numbers);
	
	}

	private static void printEvenNumbersInListStructured(List<Integer> numbers) {
		for(int number:numbers) {
			if (number%2==0) {
				System.out.println(number);
			}
		}		
	}

}
