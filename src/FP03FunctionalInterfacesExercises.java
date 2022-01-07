import java.util.List;
import java.util.function.BinaryOperator;

public class FP03FunctionalInterfacesExercises {


	//Exercise find the functional interface behind Integer.sum
	public static void main(String[] args) {	
		
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		

		BinaryOperator<Integer> sumBinaryOperator = Integer::sum;
		int sum = numbers.stream() .reduce(0, sumBinaryOperator);
		
		System.out.println(sum);
		
		
		BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer t, Integer u) {
				
				return t+u;
			}
		};
		
		int sum2 = numbers.stream() .reduce(0, sumBinaryOperator2);
		
		System.out.println(sum2);
		

	}
		
		
		
	
	

	
	
	
	
}
