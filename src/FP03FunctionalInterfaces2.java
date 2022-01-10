import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;	
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
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
		
		System.out.println("Supplier - random 0-999");
		System.out.println(randomIntegerSupplier.get());
		System.out.println();
		
		//UnaryOperator
		UnaryOperator<Integer> squareUnaryOperator = x -> x*x;
		
		System.out.println("UnaryOperator");
		System.out.println(squareUnaryOperator.apply(9));
		System.out.println();
		
		

		
		// BiPredicate - the same of Predicate with 2 paratemters - two inputs and a boolean back!
		BiPredicate<Integer, String> biPredicate = (x, y) -> {
			return x < 10 && y.length() > 5;
		};
		
		System.out.println("BiPredicate");
		System.out.println(biPredicate.test(5, "Mario Samperi"));
		System.out.println();
		
		//Bifunction - the same of function with 2 parameters - two inputs and a any type back
		// we can try to "translate" the previous bipredicate in a bifunction - as a function that returns a boolean
		
		BiFunction<Integer, String, Boolean> biFunction = (x, y) -> {
			return x < 10 && y.length() > 5;
		};

		System.out.println("BiFunction returning Boolean");
		System.out.println(biFunction.apply(5, "Mario Samperi"));
		System.out.println();
		
		//but of course with using function we can customize our types - ex return String
		
		BiFunction<Integer, String, String> biFunction2 = (x, y) -> {
			return x  + " " + y;
		};

		System.out.println("BiFunction returning String");
		System.out.println(biFunction2.apply(5, "Mario Samperi"));
		System.out.println();
		
		//Biconsumer - 2 input nothing back
		BiConsumer<Integer, String> biConsumer = (x, y) -> {
			System.out.println( x  + " " + y);
		};
		
		System.out.println("BiConsumer");
		//nosysout needed, our biConsumer IS a sysout
		biConsumer.accept(88, "Mario Samperi");
		System.out.println();
		
		
		//if you are working with primitiv type is more efficient to use these functions
		IntBinaryOperator intBinaryOperatorSum = (x, y) -> x + y;
		
		System.out.println("intBinaryOperator");
		System.out.println(intBinaryOperatorSum.applyAsInt(3, 2));
		System.out.println();
		
		
		//primitive specific functional interfarces
		//IntBinaryOperator:   same result as BinaryOperator<Integer> but more efficient!
		//IntConsumer
		//IntFunction
		//IntPredicate
		//IntSupplier
		//IntToDoubleFunction
		//IntToLongFunction
		
		//
		
		
		
		
		
		
		
		
	}	
}
