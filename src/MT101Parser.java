import java.util.*;
import java.util.regex.*;

public class MT101Parser {
    public static void main(String[] args) {
    	 String mt101Message = "{1:F01BANKBEBBAXXX0000000000}"
    	 		+ "{2:I101BANKUS33XXXXN}{4:\n" + 
         		"        :20:PAYREF123456\n" + 
         		"        :28D:1/1\n" + 
         		"        :50H:/12345678901234567890\n" + 
         		"        JOHN DOE  \n" + 
         		"        123 MAIN STREET  \n" + 
         		"        NEW YORK, NY 10001  \n" + 
         		"        USA  \n" + 
         		"        :52A:MYBANKXX  \n" + 
         		"        :30:250218  \n" + 
         		"        :21:INVOICE12345  \n" + 
         		"        :32B:USD5000,00  \n" + 
         		"        :57A:CITIBANKUS33  \n" + 
         		"        :59:/98765432109876543210  \n" + 
         		"        JANE SMITH  \n" + 
         		"        456 BROADWAY AVE  \n" + 
         		"        SAN FRANCISCO, CA 94133  \n" + 
         		"        USA  \n" + 
         		"        :70:PAYMENT FOR INVOICE 12345  \n" + 
         		"        :71A:SHA  \n" + 
         		"        \n" + 
         		"        :20:PAYREF789012\n" + 
         		"        :50H:/23456789012345678901\n" + 
         		"        ALICE BROWN  \n" + 
         		"        789 PARK AVE  \n" + 
         		"        CHICAGO, IL 60601  \n" + 
         		"        USA  \n" + 
         		"        :52A:YOURBANKXX  \n" + 
         		"        :30:250218  \n" + 
         		"        :21:INVOICE67890  \n" + 
         		"        :32B:USD7500,00  \n" + 
         		"        :57A:WELLSFARGOUS33  \n" + 
         		"        :59:/87654321098765432109  \n" + 
         		"        BOB JOHNSON  \n" + 
         		"        567 MAIN STREET  \n" + 
         		"        LOS ANGELES, CA 90012  \n" + 
         		"        USA  \n" + 
         		"        :70:PAYMENT FOR INVOICE 67890  \n" + 
         		"        :71A:SHA  \n" + 
         		"        -}";

        // Extract full application header (everything before first :20:)
        Matcher headerMatcher = Pattern.compile("(\\{1:.*?\\{4:)", Pattern.DOTALL).matcher(mt101Message);
        String applicationHeader = "";
        
        if (headerMatcher.find()) {
            applicationHeader = headerMatcher.group(1).trim()+"\n\t"; // Extract headers
        }

        // Extract transactions by splitting on `:20:` while keeping `:20:` in results
        String[] transactions = mt101Message.split("(?=:20:)");

        // Store individual transactions with application header
        List<String> individualTransactions = new ArrayList<>();
        
        for (String txn : transactions) {
            if (txn.contains(":20:")) { // Ensure it's a valid transaction
                individualTransactions.add(applicationHeader +txn);
            }
        }

        // Print each processed MT101 transaction
        for (String txn : individualTransactions) {
            System.out.println("========== SINGLE MT101 TRANSACTION ==========");
            System.out.println(txn);
        }
    }
}
