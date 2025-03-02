
import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElement_PriorityQueue {
    
    public static int findKthLargest(int[] nums, int k) {
    	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    	for(int num:nums) {
    		minHeap.offer(num); //add element to the heap 
    		//*** minheap.add can also be used
    		if(minHeap.size()>k) {
    			minHeap.poll(); //remove the smallest element
    		}
    	}
    	return minHeap.peek(); //top of the heap is the kth largest element
    	
    }
        
    
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2)); // Output: 5
        System.out.println(findKthLargest(new int[]{1,2,3,4,5,6,7,8,9}, 4)); // Output: 6
        System.out.println(findKthLargest(new int[]{7,10,4,3,20,15}, 3)); // Output: 10
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
