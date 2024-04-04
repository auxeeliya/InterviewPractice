import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindNameStartingR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names= Arrays.asList("Sai","Ram","Kumar","Raju");
		
		names.stream().filter(x->x.startsWith("R"))
		.forEach(System.out::println);

	}

}
