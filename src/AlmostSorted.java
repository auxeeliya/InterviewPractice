import java.util.*;

public class AlmostSorted {
    public static void almostSorted(List<Integer> arr) {
        int n = arr.size();
        List<Integer> sortedArr = new ArrayList<>(arr);
        Collections.sort(sortedArr);
        
        if (arr.equals(sortedArr)) {
            System.out.println("yes");
            return;
        }

        // Find the first and last mismatch positions
        int left = 0, right = n - 1;
        while (arr.get(left).equals(sortedArr.get(left))) left++;
        while (arr.get(right).equals(sortedArr.get(right))) right--;

        // Try swapping
        Collections.swap(arr, left, right);
        if (arr.equals(sortedArr)) {
            System.out.println("yes");
            System.out.println("swap " + (left + 1) + " " + (right + 1)); // 1-based index
            return;
        }
        // Restore the array
        Collections.swap(arr, left, right);

        // Try reversing
        List<Integer> subList = arr.subList(left, right + 1);
        Collections.reverse(subList);
        if (arr.equals(sortedArr)) {
            System.out.println("yes");
            System.out.println("reverse " + (left + 1) + " " + (right + 1));
            return;
        }

        System.out.println("no");
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 5, 4, 3, 2, 6);
        List<Integer> arr2 = Arrays.asList(4, 2); 
        almostSorted(arr2);
    }
}
