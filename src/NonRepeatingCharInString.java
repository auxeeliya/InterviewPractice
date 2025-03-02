import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class NonRepeatingCharInString {

	public static void main(String[] args) {
		String s="helloh";
		findFirstNonRepeatingChar(s);

	}

	private static void findFirstNonRepeatingChar(String s) {
		Map<Character,Integer> charMap = new HashMap<>();
		
		for(int i=0;i<s.length();i++) {
			if(charMap.containsKey(s.charAt(i)))
				charMap.replace(s.charAt(i), charMap.get(s.charAt(i)), charMap.get(s.charAt(i)) +1);
			else
				charMap.put(s.charAt(i), 1);
		}
		
		for(Map.Entry<Character, Integer> entry: charMap.entrySet()) {
			if(entry.getValue()==1) {
				System.out.println(entry.getKey());
				break;
			}
		}
		
	} 
 
}
