import java.util.Arrays;

public class BiggerIsGreater {
    public static void main(String[] args) {
        String word = "dkhc"; // Example word
        String result = nextPermutation(word);
        System.out.println("Next permutation: " + result);
    }

    public static String nextPermutation(String word) {
        char[] chars = word.toCharArray();

        // Step 1: Find the pivot (rightmost character that is smaller than its next character)
        int i = chars.length - 2;
        while (i >= 0 && chars[i] >= chars[i + 1]) {
            i--;
        }

        // If no pivot is found, the string is in descending order, so return no answer
        if (i == -1) {
            return "No answer";
        }

        // Step 2: Find the smallest character on the right of the pivot that is larger than the pivot
        int j = chars.length - 1;
        while (chars[j] <= chars[i]) {
            j--;
        }

        // Step 3: Swap the pivot and the smallest character found
        swap(chars, i, j);

        // Step 4: Reverse the substring after the pivot to get the smallest lexicographical order
        Arrays.sort(chars, i + 1, chars.length);  // Sort the suffix

        return new String(chars);
    }

    // Utility method to swap characters in the array
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
