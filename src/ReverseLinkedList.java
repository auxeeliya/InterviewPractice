class Node {
    int data;
    Node next;
    
    Node(int val) {
        this.data = val;
        this.next = null;
    }
}

public class ReverseLinkedList {
    public Node reverseList(Node head) {
        Node prev=null;
        Node next=null;
        Node current=head;
        while(current!=null) {
        	next=current.next;
        	current.next=prev;
        	prev=current;
        	current=next;

        }
        
        return prev;
    }
    
    // Helper method to print the reversed linked list
    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        
        ReverseLinkedList reverser = new ReverseLinkedList();
        System.out.println("Original list:");
        reverser.printList(head);
        
        Node reversedHead = reverser.reverseList(head);
        System.out.println("Reversed list:");
        reverser.printList(reversedHead);
        
    }
}
