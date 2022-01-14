import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FP041PlayingWithJavaFunctionalProgramming {


	public static void main(String[] args) {
		
		//creating a Stream from a List as we have done so far
		List<Integer> numbers = List.of(23,12,5,14,11,24,18,9,5);
		System.out.println(
				
				numbers.stream(
						)
				); //java.util.stream.ReferencePipeline$Head@5305068a
		
		
		//creating the stream directly
		System.out.println(
				
				Stream.of(23,12,5,14,11,24,18,9,5)
				
				); // java.util.stream.ReferencePipeline$Head@1f32e575
		
		//this stream has also the usual operations
		System.out.println(
				
				Stream.of(23,12,5,14,11,24,18,9,5).count()
				
				); // 9
		
		
		System.out.println(
				
				Stream.of(23,12,5,14,11,24,18,9,5).reduce(0, Integer::sum)
				
				); // 121
		
		
		// In both cases (Stream from a list and direct Stream) 
		// we use wrapper class and perfom boxing and unboxing operations
		// not very efficient
		// If is the case, it's better to create
		
		// STREAMS WITH PRIMITIVE VALUES
		
		//  - by creating an array
		
		int[] numberArray = {23, 12, 5, 14, 11, 24, 18, 9, 5};
		System.out.println(
				
				Arrays.stream(numberArray)
				
				); 	// java.util.stream.IntPipeline$Head@33c7353a
		
		
		// notice! not ReferencePipeline but IntPipeline!!
		// it means that we can perform many operations directly
		
		
		System.out.println(Arrays.stream(numberArray).sum());
		System.out.println(Arrays.stream(numberArray).average());
		System.out.println(Arrays.stream(numberArray).count());
		System.out.println(Arrays.stream(numberArray).max());
		System.out.println(Arrays.stream(numberArray).min());
		
		// create a stream dinamically: IntStream and its operations
		
		// range
		System.out.println(IntStream.range(0, 10));					//java.util.stream.IntPipeline$Head@7530d0a
		System.out.println(IntStream.range(0, 10).sum());			//45   (10 is excluded)
		System.out.println(IntStream.rangeClosed(0, 10).sum());		//55   (10 is included)
		
		//iterate to specify an algorithm
		System.out.println(IntStream.iterate(1, e -> e + 2).limit(10).sum());
		
		
		// iterate to specify an algorithm
		// peek allow to apply an action to every element
		// we are peeking the first 10 odd number
		System.out.println(IntStream.iterate(1, e -> e + 2).limit(10).peek(System.out::println).sum());
		
		
		// we are peeking the first 10 even number
		System.out.println(IntStream.iterate(2, e -> e + 2).limit(10).peek(System.out::println).sum());
		
		// sowing the first 10 power of two
		System.out.println(IntStream.iterate(2, e -> e * 2).limit(10).peek(System.out::println).sum());
		
		// creating a List from a primitive stream	
		// remember to box the primitive list (we cant use int but Integer!)
		System.out.println(IntStream.iterate(2, e -> e * 2).limit(10).boxed().collect(Collectors.toList()));
		
		//we can perform the same operations with DoubleStream, LongStream and so on
		
		
		
		
		
		
	}
	
	

}