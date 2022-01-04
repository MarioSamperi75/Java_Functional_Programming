// We want to display just the even the numbers in a List
// first in a structured(traditional) way 
// and then with functional programming

import java.util.List;

public class FP02Structured {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(23,12,5,14,11,24,18,9,5);
		
		int sum = addListStructured(numbers);
		System.out.println(sum);
	}

	private static int addListStructured(List<Integer> numbers) {
		int sum = 0;
		for (int number:numbers) {
			sum += number;
		}
		return sum;
	}


				
	

}
