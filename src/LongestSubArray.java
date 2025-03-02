/*
 * Problem Statement
You are given an array nums of integers. You may delete one element from the array.
Return the length of the longest subarray that contains only 1s after removing one element.

Example 1:

Input: nums = [1,1,0,1,1,1]  
Output: 5  
Explanation: After removing the `0`, the longest contiguous subarray of `1`s is `[1,1,1,1,1]`.

Example 2:

Input: nums = [1,1,1]  
Output: 2  
Explanation: We must delete **one** element, so the longest subarray is `[1,1]`.
 */
public class LongestSubArray {
	public static int longestSubarray(int[] arr) {
		int len=arr.length;
		
		int left =0;
		int maxLength=0;
		int zeroCount=0;
		for (int right = 0; right < len; right++) {
			if(arr[right]==0) zeroCount++;
			
			while(zeroCount>1) {
				if(arr[left]==0) zeroCount--;
				left++;
			}
			maxLength = Math.max(maxLength, right-left);
		}
		return maxLength;
	}	
	
	public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1,1,0,1,1,1})); // Output: 5
        System.out.println(longestSubarray(new int[]{1,1,1})); // Output: 2
        System.out.println(longestSubarray(new int[]{0,0,0})); // Output: 0
        System.out.println(longestSubarray(new int[]{1,0,1,1,0,1,1,1})); // Output: 4
       
    }
}
