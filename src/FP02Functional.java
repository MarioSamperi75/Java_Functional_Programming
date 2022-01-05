// We want to display just the even the numbers in a List
// first in a structured(traditional) way 
// and then with functional programming

import java.util.List;

public class FP02Functional {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(23,12,5,14,11,24,18,9,5);
		
		int sum = addListStructured(numbers);
		System.out.println(sum);
	}
	
//	private static int sum (int aggregate, int nextNumber) {
//		System.out.println(aggregate + " " + nextNumber);
//		int sum = aggregate + nextNumber;
//		return sum;
		
//	This is the result of the sysout,
// it's easy to understand how the accumulator works
		
//		0 23
//		23 12
//		35 5
//		40 14
//		54 11
//		65 24
//		89 18
//		107 9
//		116 5
//		121
//	}

	
	
	//instead of the sum method we can easuly use a lambda expression!
	private static int addListStructured(List<Integer> numbers) {
		
		// reduce: from a stream of number to a single value, one result
		// two argument the accumulator and the operation
		// we have to add the starting value of the accumulator as first argument
		return numbers.stream()
		//.reduce(0, FP02Functional::sum );
		.reduce(0, (x,y) -> x + y );
	}
	
}
