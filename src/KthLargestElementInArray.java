
import java.util.Random;

public class KthLargestElementInArray {
    
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length)
            throw new IllegalArgumentException("Invalid input");
        
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    
    private static int quickSelect(int[] nums, int start, int end, int k) {
        while (start <= end) {
            int pivotIndex = partition(nums, start, end);
            
            if (pivotIndex == k)
                return nums[pivotIndex];
            else if (pivotIndex < k)
                start = pivotIndex + 1;
            else
                end = pivotIndex - 1;
        }
        
        return -1; // Should never reach here
    }
    
    private static int partition(int[] nums, int start, int end) {
        int pivotIndex = start + new Random().nextInt(end - start + 1);
        int pivot = nums[pivotIndex];
        
        swap(nums, pivotIndex, end);
        
        int left = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < pivot) {
                swap(nums, left, i);
                left++;
            }
        }
        
        swap(nums, left, end);
        
        return left;
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        
        int kthLargest = findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element is: " + kthLargest);
    }
}

/*
 Problem Statement
Given an integer array nums and an integer k, return the kth largest element in the array.
(Note: It is the kth largest distinct value, not sorted order position.)

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2  
Output: 5  

Example 2:

Input: nums = [1,2,3,4,5,6,7,8,9], k = 4  
Output: 6  

 */
