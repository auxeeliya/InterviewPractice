import java.util.Arrays;

/*You are given an array of even length nums. You need to pair up the elements such that the maximum sum of any pair is minimized.

Return this minimized maximum pair sum.

Input: nums = [3,5,2,3]  
Output: 6  
Explanation:  
Possible pairs: (3,3) and (2,5),  
Pair sums: 3+3 = 6, 2+5 = 6,  
Max pair sum = **6** (which is minimized).  

Input: nums = [3,5,4,2,4,6]  
Output: 8  
Explanation:  
Pairs: (2,6), (3,5), (4,4),  
Pair sums: 8, 8, 8,  
Max pair sum = **8** (minimized).  

*/
public class MinimizeMaxPairSum {
    public static int minPairSum(int[] nums) {
        Arrays.sort(nums); // Step 1: Sort the array (O(N log N))

        int left = 0, right = nums.length - 1; // Two pointers
        int maxPairSum = 0;

        while (left < right) { // Step 2: Pairing
            maxPairSum = Math.max(maxPairSum, nums[left] + nums[right]); 
            left++;
            right--;
        }

        return maxPairSum; // Step 3: Return the minimized max pair sum
    }

    public static void main(String[] args) {
        System.out.println(minPairSum(new int[]{3,5,2,3}));  // Output: 6
        System.out.println(minPairSum(new int[]{3,5,4,2,4,6})); // Output: 8
    }
}
