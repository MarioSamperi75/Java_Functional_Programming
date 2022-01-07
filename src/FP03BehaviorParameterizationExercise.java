import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03BehaviorParameterizationExercise {


	//Exercise find the functional interface behind Integer.sum
	public static void main(String[] args) {	
		
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		
		
		List<Integer> add2List = mapToList(numbers, x->x+2);
		List<Integer> cubesList = mapToList(numbers, x->x*x*x);
		
		System.out.println(add2List);
		System.out.println(cubesList);
	}

	private static List<Integer> mapToList(List<Integer> numbers, Function<? super Integer, ? extends Integer> function) {
		return numbers.stream().map(function) .collect(Collectors.toList());
	}

}
