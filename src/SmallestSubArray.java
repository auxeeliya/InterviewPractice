
public class SmallestSubArray {
	public static int smallestSubarray(int[] arr, int k) {
		//use sliding window technique
		//left - start with 0
		//right - move the right pointer till the arr length
		//while some condition satisfies
		//find the min or max with right-left (sometimes +1);
		//remove the left value
		//move the left pointer
		//return the min or max value
		 if (arr == null || arr.length == 0 || k == 0) return 0;
		 
		int len=arr.length;
		int left = 0;
		int sum=0;
		int minlength =Integer.MAX_VALUE;		
				
		for(int right=0;right<len;right++) {
			sum+=arr[right];
			while(sum>=k) {
				minlength=Math.min(minlength, right-left+1);
				sum-=arr[left];
				left++;
			}
		}
		return minlength==Integer.MAX_VALUE? 0 : minlength;
	}
	public static void main(String[] args) {
        System.out.println(smallestSubarray(new int[]{2,3,1,2,4,3},7)); // Output: 2
        System.out.println(smallestSubarray(new int[]{1,1,1,1,1,1,1}, 11)); // Output: 0  
        System.out.println(smallestSubarray(new int[]{8},5));
    }

}


/*
Problem Statement
Given an array nums of positive integers and an integer target, find the length of the smallest contiguous subarray 
whose sum is ≥ target.
If no such subarray exists, return 0.

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]  
Output: 2  
Explanation: The smallest subarray `[4,3]` has sum `7`.  

Example 2:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]  
Output: 0  
Explanation: No subarray has sum ≥ 11.
*/