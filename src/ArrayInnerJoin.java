import java.util.Arrays;

public class ArrayInnerJoin {

	public static void main(String[] args) {
		int first[]= {4,9,5};
		int second[]= {9,4,9,8,4};
		
		Arrays.stream(first).filter(x-> Arrays.stream(second).anyMatch(y -> y == x))
		.distinct()
		.forEach(System.out::println);
	}

}
