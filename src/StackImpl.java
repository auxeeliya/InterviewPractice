import java.util.ListIterator;
import java.util.Stack;

public class StackImpl {

	public static void main(String[] args) {
		Stack<String> animals= new Stack<>();
		animals.push("cat");	
		animals.push("dog");
		animals.push("camel");
		
		//animals.stream().forEach(System.out::println);
		
		ListIterator<String> iterator = animals.listIterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		
	}

}
//import java.util.Iterator;  
//import java.util.ListIterator;  
//import java.util.Stack;  
//   
//public class StackImpl 
//{  
//public static void main (String[] args)   
//{   
//Stack <Integer> stk = new Stack<>();  
//stk.push(119);  
//stk.push(203);  
//stk.push(988);  
//ListIterator<Integer> ListIterator = stk.listIterator(stk.size());  //IF SIZE IS NOT GIVEN USE HASNEXT AND NEXT
//System.out.println("Iteration over the Stack from top to bottom:");  
//while (ListIterator.hasPrevious())   
//{  
//Integer avg = ListIterator.previous();  
//System.out.println(avg);  
//}  
//}  
//}
