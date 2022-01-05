// We want to display just the even the numbers in a List
// first in a structured(traditional) way 
// and then with functional programming

import java.util.List;

public class FP02Exercises {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(23,12,5,14,11,24,18,9,4);
		
		int sumOfSquares = addSquaresList(numbers);
		System.out.println(sumOfSquares);
		
		System.out.println();
		
		int sumOfCubes = addCubesList(numbers);
		System.out.println(sumOfCubes);
		
		System.out.println();
		
		int sumOfOdds = addOddsList(numbers);
		System.out.println(sumOfOdds);
	}	




	private static int addSquaresList(List<Integer> numbers) {
	
		return numbers.stream()

		// in this case we have not to square the accumulator!!!
		// just nextNumber!
		.reduce(0, (x,y)-> x + (y*y) );
		
		//alternative: you can use first map and then reduce!
		//		.map(x -> x*x)
		//		.reduce(0, (x,y)-> x + y );
		
	}
	
	private static int addCubesList(List<Integer> numbers) {
		
		return numbers.stream()
		.reduce(0, (x,y)-> x + (y*y*y) );
		
		//alternative: you can use first map and then reduce!
		//		.map(x -> x*x*x)
		//		.reduce(0, (x,y)-> x + y );
		
	}
	
	private static int addOddsList(List<Integer> numbers) {
		return numbers.stream()
				.filter(x->x%2 != 0 )
				.reduce(0, (x,y)-> x + y );
	
	}

	
	
	
	
}
