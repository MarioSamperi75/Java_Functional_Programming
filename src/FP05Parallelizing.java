import java.util.stream.LongStream;

public class FP05Parallelizing {
	
	// FP can take advantage of a multiprocessor structure
	// Better performance !!!

	public static void main(String[] args) {
		long before = System.currentTimeMillis(); 
		System.out.println(LongStream.range(0, 1000000000).sum());
		System.out.println("Sequential: " + (System.currentTimeMillis() - before));
		
		//JUST USE parallel() !!!
		long before2 = System.currentTimeMillis(); 
		System.out.println(LongStream.range(0, 1000000000).parallel().sum());
		System.out.println("Parallel: " + (System.currentTimeMillis() - before2));
		
		// result with my computer:
		
		//			499999999500000000
		//			Sequential: 2382
		//			499999999500000000
		//			Parallel: 138
	}

}
