import java.util.*;
import java.util.stream.Collectors;


public class HappyLadyBug {
    public static String happyLadybugs(String b) {
        // Count frequency of each character
        Map<Character, Long> frequency = b.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        // Check if all ladybugs are already happy (no movement needed)
        boolean alreadyHappy =false;
        if(b.length()==1 && !b.chars().equals("_")) {
        	alreadyHappy = false;
        }
  
        for ( int i = 1; i < b.length(); i++) {
            if (b.charAt(i) != b.charAt(i - 1) && (i+1<b.length()) && ( b.charAt(i) != b.charAt(i + 1))) {
            	alreadyHappy = false;
                break;
            }
			
			 if(i==b.length()-1 && b.charAt(i) == b.charAt(i - 1)) { 
				 alreadyHappy = true;
			 }
        }
       // if (alreadyHappy) return b+" -> YES";

        // If there is no empty space ('_') but the ladybugs are not happy, return "NO"
        if (!alreadyHappy && !frequency.containsKey('_')) return b+" -> NO";

        // Check if each ladybug appears at least twice
        for (var entry : frequency.entrySet()) {
            if (entry.getKey() != '_' && entry.getValue() == 1) return b+" -> NO";
        }

        return b+" -> YES"; // Rearrangement is possible
    }

    public static void main(String[] args) {
      //  List<String> testCases = List.of("AABBC", "AABBC_C", "_", "DD__FQ_QQF", "AABCBC","G", "GR", "_GR_", "_R_G_", "R_R_R","RRGGBBXX","RRGGBBXY");

    	List<String> testCases = List.of("P______");

    	testCases.forEach(test -> System.out.println(happyLadybugs(test)));
    }
}
