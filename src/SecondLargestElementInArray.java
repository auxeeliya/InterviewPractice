import java.util.Arrays;

public class SecondLargestElementInArray {

	public static void main(String[] args) {
		int arr[]= {12,4,13,28,13};
		int k=3;
		findKthLargestElemet(arr, k);
	}

	private static void findKthLargestElemet(int[] arr, int k) {
		Arrays.sort(arr);
		System.out.println(arr[arr.length-k]);

	}

}
