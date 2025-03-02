import java.util.Arrays;

public class DivideArrayIntoPairs {
    public static boolean canDivideIntoPairs(int[] nums) {
        if (nums.length % 2 != 0) return false; // Must have even length

        Arrays.sort(nums); // Step 1: Sort the array

        int targetSum = nums[0] + nums[nums.length - 1]; // Expected sum for all pairs

        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] != targetSum) {
                return false; // If any pair's sum is different, return false
            }
            left++;
            right--;
        }

        return true; // If all pairs match, return true
    }

    public static void main(String[] args) {
        System.out.println(canDivideIntoPairs(new int[]{3, 5, 2, 4, 5, 2})); // true
        System.out.println(canDivideIntoPairs(new int[]{1, 1, 2, 3})); // false
        System.out.println(canDivideIntoPairs(new int[]{6, 3, 3, 6, 5, 5})); // true
    }
}



/*
We are given an even-length array and need to divide it into pairs where each pair has the same sum.

If possible, return true, otherwise return false.
*/