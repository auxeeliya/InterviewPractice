
import java.util.*;

public class ReduceArrayToHalf {
    public static int minSetSize(int[] nums) {
       Map<Integer,Integer> freqMap = new HashMap<>();
      for(int num: nums) {
    	  freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
      }
      List<Integer> freqValList = new ArrayList<>(freqMap.values());
      freqValList.sort(Collections.reverseOrder());
      int removedElem=0, counter=0;
      for(int freqVal: freqValList) {
    	  removedElem+=freqVal;
    	  counter++;
    	  if(removedElem>=nums.length/2) {
    		  return counter;
    	  }
      }
      return counter;
    }

    public static void main(String[] args) {
        System.out.println(minSetSize(new int[]{3,3,3,3,5,5,5,2,2,7})); // Output: 2
        System.out.println(minSetSize(new int[]{1,9})); // Output: 1
        System.out.println(minSetSize(new int[]{7,7,7,7,7,7})); // Output: 1
    }
}

/*
Problem Statement
Given an array of integers nums, find the minimum number of elements that must be removed to reduce the array size to at most half.

Example 1

Input: nums = [3,3,3,3,5,5,5,2,2,7]  
Output: 2  
Explanation:  
- The array has `10` elements.  
- We need to remove at least `5` elements to reduce it to half (`≤5`).  
- The most frequent elements are `{3,3,3,3}` and `{5,5}`.  
- Removing `{3,3,3,3}` and `{5,5}` removes `6` elements.  
- Minimum groups needed = **2**.

Example 2

Input: nums = [1,9]  
Output: 1  
Explanation: Removing `1` or `9` makes the array size ≤1.

Example 3

Input: nums = [7,7,7,7,7,7]  
Output: 1  
Explanation: We can remove all `7`s in **one step**.
Approach: Frequency Sorting + Greedy

💡 Key Idea
We must remove elements with the highest frequency first.
Sorting frequencies in descending order ensures minimal removal steps.
Use a HashMap to count occurrences, then sort the frequencies.
Steps to Solve
Count frequencies of each number using a HashMap<Integer, Integer>.
Sort frequency values in descending order (removing higher counts first).
Greedily remove elements, keeping track of removed count until half of the array is removed.
*/