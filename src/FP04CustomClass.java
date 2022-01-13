import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Course {
	
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;
	
	
	public String getName() {
		return name;
	}
	
	
	
	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}



	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	public int getNoOfStudents() {
		return noOfStudents;
	}
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}
	@Override
	public String toString() {
		return "Course [name=" + name + ", category=" + category + ", reviewScore=" + reviewScore + ", noOfStudents="
				+ noOfStudents + "]";
	}
	
	
	
}

public class FP04CustomClass {

	public static void main(String[] args) {
		
		List<Course> courses = List.of(
				new Course("Spring", "Framework", 98, 20000),
				new Course("Spring Boot", "Framework", 95, 18000),
				new Course("API", "Microservices", 97, 22000),
				new Course("Microservices", "Microservices", 96, 25000),
				new Course("Fullstack", "Fullstack", 91, 14000),
				new Course("AWS", "Cloud", 92, 21000),
				new Course("Azure", "Cloud", 99, 21000),
				new Course("Docker", "Cloud", 92, 20000),
				new Course("Kubernetes", "Cloud", 91, 20000)
				);
		
		//allMatch, noneMAtch, anyMatch
		

		
		Predicate<? super Course> reviewScoreBiggerThan90 = course -> course.getReviewScore() > 90;
		
		
		Predicate<? super Course> reviewScoreLessThan90 = course -> course.getReviewScore() < 90;
		
		Predicate<? super Course> reviewScoreBiggerThan95 = course -> course.getReviewScore() > 95;
		
		System.out.println(
				courses.stream().allMatch(course -> course.getReviewScore() > 90));
		
		System.out.println(
				courses.stream().allMatch(reviewScoreBiggerThan95));
		
		System.out.println(
				courses.stream().noneMatch(reviewScoreBiggerThan95));
		
		System.out.println(
				courses.stream().noneMatch(reviewScoreLessThan90));		
		
		System.out.println(
				courses.stream().anyMatch(reviewScoreLessThan90));	
		
		System.out.println(
				courses.stream().anyMatch(reviewScoreBiggerThan95));	
		
		// sorting items with sorted and comparator
		
		// we can actually use comparingInt in all these cases because it's more efficient
		// there is a specific method for all the primitive types
		Comparator <Course> comparingByNoOfStudentsComparatorIncreasing = Comparator.comparing(Course::getNoOfStudents);
		Comparator <Course> comparingByNoOfStudentsComparatorDecreasing = Comparator.comparing(Course::getNoOfStudents).reversed();
		
		System.out.println(
				courses.stream().sorted(comparingByNoOfStudentsComparatorIncreasing).collect(Collectors.toList()));

		System.out.println(
				courses.stream().sorted(comparingByNoOfStudentsComparatorDecreasing).collect(Collectors.toList()));
		
		// to steps sorting
		// example of comparingInt
		Comparator <Course> comparingByNoOfStudentsComparatorIncreasingAndReviewScore = 
				Comparator.comparingInt(Course::getNoOfStudents)
				.thenComparingInt(Course::getReviewScore).reversed();
		
		System.out.println(
				courses.stream().sorted(comparingByNoOfStudentsComparatorIncreasingAndReviewScore).collect(Collectors.toList()));
		
		// limit - skip - takeWhile - dropWhile
		
		// we want to limit the list to the first 5 items
		System.out.println(
				courses.stream()
				.sorted(comparingByNoOfStudentsComparatorIncreasingAndReviewScore)
				.limit(5)
				.collect(Collectors.toList()));
		
		// We want to skip the first three and show the others
		System.out.println(
				courses.stream()
				.sorted(comparingByNoOfStudentsComparatorIncreasingAndReviewScore)
				.skip(3)
				.collect(Collectors.toList()));
		
		// Of course we can combine skip and limit
		System.out.println(
				courses.stream()
				.sorted(comparingByNoOfStudentsComparatorIncreasingAndReviewScore)
				.skip(3)
				.limit(1)
				.collect(Collectors.toList()));
		
		// takeWhile: we want to list all the courses while a condition occurs
		// e.g all the course while the review score is >= 95 (96 excluded).
		
		System.out.println(
				courses.stream()
				.takeWhile(course -> course.getReviewScore() >= 95)
				.collect(Collectors.toList()));
		
		// the opposit is dropWhile (to skip depending of a condition)
		System.out.println(
				courses.stream()
				.dropWhile(course -> course.getReviewScore() >= 95)
				.collect(Collectors.toList()));
		
		
		// max & min
		
		
		// max returns the last element in the list
		System.out.println(
				courses.stream()
				.max(comparingByNoOfStudentsComparatorIncreasingAndReviewScore)
				);
		
		// min returns the first element in the list
		System.out.println(
				courses.stream()
				.min(comparingByNoOfStudentsComparatorIncreasingAndReviewScore)
				);
		
		
		// we get actually an Optional, what does it means?
		// we will use filter wiht a predicate that give us no results
		
		System.out.println(
				courses.stream()
				.filter(reviewScoreLessThan90)
				.min(comparingByNoOfStudentsComparatorIncreasingAndReviewScore)
				);
		// we get Optional.empty
		// It's just a way to avoid the nullPoiterException in Java
		
		
		// You can also use orElse to set a default result in case of null
		System.out.println(
				courses.stream()
				.filter(reviewScoreLessThan90)
				.min(comparingByNoOfStudentsComparatorIncreasingAndReviewScore)
				.orElse(new Course("Origami from 0 to Hero", "Bonus Course", 99, 30000))
				);
		
		// without filter we get the first course - that exists-  and not the default
		System.out.println(
				courses.stream()
				.min(comparingByNoOfStudentsComparatorIncreasingAndReviewScore)
				.orElse(new Course("Origami from 0 to Hero", "Bonus Course", 99, 30000))
				);
		
		
		// finding the first element that meets a specific criteria
		
		System.out.println(
				courses.stream()
				.filter(reviewScoreLessThan90)
				.findFirst()
				); //Optional.empty
		
		System.out.println(
				courses.stream()
				.filter(reviewScoreBiggerThan95)
				.findFirst()
				); //Optional[Course [name=Spring, category=Framework, reviewScore=98, noOfStudents=20000]]
		
		// finding ONE element that meets a specific criteria. it can be a different value than findFirst 
		// (but just in certain condition, otherwise is the same result)
		System.out.println(
				courses.stream()
				.filter(reviewScoreBiggerThan95)
				.findFirst()
				); //Optional[Course [name=Spring, category=Framework, reviewScore=98, noOfStudents=20000]]
			

		// sum - average
		
		// sum: exercise - get the total nuber of students in all those courses having reviewScore > 95
		System.out.println(		
				courses.stream()
				.filter(reviewScoreBiggerThan95)
				.mapToInt(Course::getNoOfStudents)
				.sum()
				); //88000
		
		// average: exercise - get the average of students in all those courses having reviewScore > 95	
		System.out.println(		
				courses.stream()
				.filter(reviewScoreBiggerThan95)
				.mapToInt(Course::getNoOfStudents)
				.average()
				); //OptionalDouble[22000.0]
		
		// count: exercise - get the total of courses that meet the criteria  reviewScore > 95	
		System.out.println(		
				courses.stream()
				.filter(reviewScoreBiggerThan95)
				.mapToInt(Course::getNoOfStudents)
				.count()
				); //4
		
		// max: exercise - get the maximum value of number of students in all the courses having  reviewScore > 95	
		System.out.println(		
				courses.stream()
				.filter(reviewScoreBiggerThan95)
				.mapToInt(Course::getNoOfStudents)
				.max()
				); //OptionalInt[25000]
		
		
		// min: exercise - get the MINIMUM value of number of students in all the courses having  reviewScore > 95	
		System.out.println(		
				courses.stream()
				.filter(reviewScoreBiggerThan95)
				.mapToInt(Course::getNoOfStudents)
				.min()
				); //OptionalInt[25000]
		
		
		//groupingBy - List of courses by category
		System.out.println(
				courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory))
				);

		//groupingBy - Number of courses by category
		System.out.println(
				courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()))
				); // {Cloud=4, Fullstack=1, Microservices=2, Framework=2}
		
		
		//groupingBy - In every category, Select Just the course having the higher
		System.out.println(
				courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory, 
						Collectors.maxBy(Comparator.comparing(Course::getReviewScore))))
				); 	//{Cloud=Optional[Course [name=Azure, category=Cloud, reviewScore=99, noOfStudents=21000]], 
					//Fullstack=Optional[Course [name=Fullstack, category=Fullstack, reviewScore=91, noOfStudents=14000]], 
					//Microservices=Optional[Course [name=API, category=Microservices, reviewScore=97, noOfStudents=22000]], 
					//Framework=Optional[Course [name=Spring, category=Framework, reviewScore=98, noOfStudents=20000]]}
		
		
		//groupingBy - List of courses by category - Just the name
		System.out.println(
				courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory,
						Collectors.mapping(Course::getName, Collectors.toList())))
				);
		

	}

}
