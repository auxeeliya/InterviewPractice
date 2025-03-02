public class FirstNonRepeatingCharacter {
    public static char firstNonRepeatingChar(String str) {
        int[] freq = new int[256]; // Assuming ASCII characters
        
        // Count frequencies of characters
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            freq[c]++;
        }
        
        // Find the first non-repeating character
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (freq[c] == 1) {
                return c;
            }
        }
        
        // If no non-repeating character found, return null or throw an exception as needed
        return '\0'; // or throw new RuntimeException("No non-repeating character found");
    }
    
    public static void main(String[] args) {
        String str = "hello";
        char firstNonRepeating = firstNonRepeatingChar(str);
        if (firstNonRepeating != '\0') {
            System.out.println("First non-repeating character: " + firstNonRepeating);
        } else {
            System.out.println("No non-repeating character found");
        }
    }
}
