import java.util.*;

//Given a string s and an integer k, find the length of the longest substring that contains at most k distinct characters.
//Input: s = "eceba", k = 2  
//Output: 3  
//Explanation: The longest substring with at most 2 distinct characters is "ece".

public class LongestSunstringKDistinct {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return 0;
        int left =0;
        int maxLength =0;
        Map<Character, Integer> charCount = new HashMap<>();
        
        for(int right =0;right<s.length();right++) {
        	charCount.put(s.charAt(right), charCount.getOrDefault(s.charAt(right), 0)+1);
        	while(charCount.size() >k) {
        		char leftChar=s.charAt(left);
        		charCount.put(leftChar, charCount.get(leftChar)-1);
        		if(charCount.get(leftChar)==0)
        			charCount.remove(leftChar);
        		left++;
        	}
        	maxLength = Math.max(maxLength, right-left+1);
        }
        		
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2)); // Output: 3
        System.out.println(lengthOfLongestSubstringKDistinct("eceea", 2)); // Output: 4
        System.out.println(lengthOfLongestSubstringKDistinct("aabbcc", 2));    // Output: 2
    }
}



/*
 *  
 */

/*
Problem Statement:
Given a string s and an integer k, find the length of the longest substring that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: The longest substring with at most 2 distinct characters is "ece".

Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: The longest substring with at most 1 distinct character is "aa".
*/