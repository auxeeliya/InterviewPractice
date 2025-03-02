import java.util.*;

public class LarrysArray {
    public static String larrysArray(List<Integer> A) {
        int inversions = 0;
        int n = A.size();

        // Count the number of inversions
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (A.get(i) > A.get(j)) {
                    inversions++;
                }
            }
        }
        System.out.println("inversion="+inversions);
        return (inversions % 2 == 0) ? "YES" : "NO";
    }

    public static void main(String[] args) {
        List<Integer> A1 = Arrays.asList(3, 1, 2);
       // System.out.println(larrysArray(A1));  // Output: YES

        List<Integer> A2 = Arrays.asList(1, 3, 4, 2);
       // System.out.println(larrysArray(A2));  // Output: YES
    	
        List<Integer> A3 = Arrays.asList(1, 6, 5, 2, 4, 3);
        System.out.println(larrysArray(A3));  // Output: NO
    }
}
