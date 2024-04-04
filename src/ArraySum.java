import java.util.Arrays;

public class ArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int elements[] = {2,3,4,5,7} ;
		
		int sum = Arrays.stream(elements)
		.sum();
		System.out.println(sum);

	}

}
