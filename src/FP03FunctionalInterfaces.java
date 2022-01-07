import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03FunctionalInterfaces {

	@SuppressWarnings("unused")
	static boolean isEven (int num) {
		return num%2==0;
	}
	
	static int square(int num) {
		return num * num;
	}
	
	static void print(int num) {
		System.out.println(num);
	}
	
	public static void main(String[] args) {	
		
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		
		numbers.stream()
		.filter(x -> x%2==0)
		//correspond to
		//.filter(FP03FunctionalInterfaces::isEven)
		
		.map(x -> x * x)
		//correspond to
		//.map(FP03FunctionalInterfaces::square)
		
		.forEach(System.out::println);
		//correspond to 
		//.forEach(x -> System.out.println(x));
		// that correspond to
		//.forEach(FP03FunctionalInterfaces::print);
		 System.out.println();
		
		//But how lambda works behind the scenes?
		//Lambda pass logic as argument by passing objects!
		//These object are FuctionalInterfaces (interfaces with only one abstract method)
		//Predicate, Function, Consumer
		
		//we can show that by extracting the arguments (extract to local variable)
		Predicate<Integer> isEvenPredicate = x -> x%2==0;
		Function<Integer, Integer> squareFunction = x -> x * x;
		Consumer<Integer> sysoutConsumer = x -> System.out.println(x);
		
		//we will get the same result
		numbers.stream()
		.filter(isEvenPredicate)
		.map(squareFunction)
		.forEach(sysoutConsumer);
		
		System.out.println();
		
		
		//lambda is actually a new instance of a functional interface
		Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {

			@Override
			public boolean test(Integer x) {
				return x%2==0;
			}
		};
		
		Function<Integer, Integer> squareFunction2 = new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer x) {
				return x * x;
			}
		};
		
		Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {

			@Override
			public void accept(Integer x) {
				System.out.println(x);
			}
		};
		
		//again we will get the same result
		numbers.stream()
		.filter(isEvenPredicate2)
		.map(squareFunction2)
		.forEach(sysoutConsumer2);

	}
		
		
		
	
	

	
	
	
	
}
