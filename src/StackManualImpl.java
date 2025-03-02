
public class StackManualImpl {

	private int arr[];
	private int top;
	private int size;
	
	
	public StackManualImpl(int size) {
		this.size = size;
		arr = new int[size];
		top = -1;
	}
	
	public void push(int n) {
		if(isFull()) {
			System.out.println("Stack is full");
			System.exit(1);
		}
		arr[++top]=n;
		System.out.println("Element Pushed ="+n);		
	}
	
	public void pop() {
		if(isEmpty()){
			System.out.println("Stack is full");
			System.exit(1);
		}
		
		System.out.println("Element Poped ="+ arr[top]);	
		top--;
		
	}
		
	public boolean isEmpty() {
		return top == -1;
	}
	public boolean isFull() {
		return top == size-1;
	}
	
	public void printStack() {
	    for (int i = 0; i <= top; i++) {
	        System.out.println(arr[i]);
	      }
	}

	public static void main(String[] args) {
		StackManualImpl stack = new StackManualImpl(5); 
		stack.push(2);
		stack.push(12);
		stack.push(22);
		System.out.println("\n after pushing");
		stack.printStack();
		stack.pop();
		stack.pop();
		System.out.println("\n after poping");
		stack.printStack();
	}

}
