import java.util.Arrays;
import java.util.List;
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
		
		
		
	}
	
	

}