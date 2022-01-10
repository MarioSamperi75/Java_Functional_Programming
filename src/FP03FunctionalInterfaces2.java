import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FP03FunctionalInterfaces2 {

	
	public static void main(String[] args) {	
		
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		
		Predicate<Integer> isEvenPredicate = x -> x%2==0;
		
		// First argument is the input, the other is the output
		Function<Integer, Integer> squareFunction = x -> x * x;
		
		// We can use different types
		Function<Integer, String> fromNumberFunctionToString = x -> x + " ";
		
		Consumer<Integer> sysoutConsumer = x -> System.out.println(x);
		
		BinaryOperator<Integer> sumBinaryOperator = (x, y) -> x + y;
		
		// Supplier: take no input and return something ex.random, date, factory pattern, system stuffs
		// we will use lambda with multiple lines of code: add braces and return! 
		Supplier<Integer> randomIntegerSupplier = () -> {
			Random random = new Random();
			return random.nextInt(1000);
		};
		
		System.out.println(randomIntegerSupplier.get());
		System.out.println();
		
		//UnaryOperator
		UnaryOperator<Integer> squareUnaryOperator = x -> x*x;
		
		System.out.println(squareUnaryOperator.apply(9));
		

		
		
	
	}
		
		
		
	
	

	
	
	
	
}
