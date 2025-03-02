import java.util.*;

public class SmallestSubstringWithAllChars {
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";
        
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        int left = 0, minLength = Integer.MAX_VALUE, minStart = 0;
        int requiredChars = charCount.size(), formed = 0;
        Map<Character, Integer> windowCount = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            windowCount.put(rightChar, windowCount.getOrDefault(rightChar, 0) + 1);

            if (charCount.containsKey(rightChar) 
            		&& windowCount.get(rightChar).intValue() == charCount.get(rightChar).intValue()) { // if there are 2 'A's in the target string , looking for 1 'A's in the input as well
                formed++;
            }

            while (formed == requiredChars) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);

                if (charCount.containsKey(leftChar) && windowCount.get(leftChar) < charCount.get(leftChar)) {
                    formed--;
                }
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // Output: "BANC"
        System.out.println(minWindow("ADOBECODEBANC", "ABCA")); // output "ADOBECODEBA"
        System.out.println(minWindow("a", "a"));               // Output: "a"
        System.out.println(minWindow("a", "aa"));              // Output: ""
        System.out.println(minWindow("aA", "a"));              // Output: "a"
    }
}
