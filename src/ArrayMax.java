import java.util.Arrays;

public class ArrayMax {

	public static void main(String[] args) {
		int input[]= {4,29,5,10,1};
		
		System.out.print(Arrays.stream(input).max().getAsInt());;
	}
}
// another method is to have a function that takes an input array, 
//have an initial value of 0 as max and then traverse the loop to check if the element is bigger than max, if so replace max.
//it will have a time and space complexity of o(n) and o(1)
// if two for loops and swap is used then the time complexity would be 0(n^2)