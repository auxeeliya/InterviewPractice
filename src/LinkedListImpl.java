
public class LinkedListImpl {
	private Node head;
	private Node tail;
	private static class Node{
		int data;		
		Node next;
		
		private Node(int data) {
			this.data = data;
			this.next=null;
		}		
	}
	public LinkedListImpl() {
		this.head = null;
		this.tail = null;
	}
	
	public void addNode(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head=newNode;
			tail=newNode;
		}
		else {
			tail.next=newNode;
			tail=tail.next;
		}
	}
	public void deleteNode(int data){
		if(data==head.data) {
			head=head.next;
		}
		else {
			Node temp=head;
			while(temp!=null) {
				if(data == temp.next.data) {
					temp.next=temp.next.next;
					break;
				}
				temp=temp.next;
			}
		}
	}
	
	public void printList(){
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("null");
	}
	
	public static void main(String args[]) {
		LinkedListImpl lk=new LinkedListImpl();
		lk.addNode(1);
		lk.addNode(2);
		lk.addNode(3);
		lk.addNode(4);
		lk.addNode(5);
		lk.addNode(6);
		
		//lk.head.next.next.next=lk.head.next;
		//lk.findCycleLinkedList();
		
		lk.printList();
		lk.deleteNode(3);
		lk.printList();
		
		//lk.findMiddleNode();
		
		
	}

	private void findMiddleNode() {
		Node fastpointer=head;
		Node slowpointer=head;
		
		while(fastpointer!=null && fastpointer.next!=null)
		{
			fastpointer=fastpointer.next.next;
			slowpointer=slowpointer.next;
		}
		System.out.print(slowpointer.data);
	} 
	
	private void findCycleLinkedList() {
		Node fastpointer=head;
		Node slowpointer=head;
		
		while(slowpointer!=null && fastpointer!=null && fastpointer.next!=null)
		{
			fastpointer=fastpointer.next.next;
			slowpointer=slowpointer.next;
			
			if(slowpointer==fastpointer) {
				System.out.print("cycle LinkedList");
				break;
			}
		}
	} 
}

