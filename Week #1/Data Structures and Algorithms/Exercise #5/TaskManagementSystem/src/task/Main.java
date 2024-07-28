package task;

class Node{
	Task task;
	Node next;
	
	Node(Task task){
		this.task = task;
		this.next = null;
	}
}
public class Main {
	private Node head;
	
	public Main() {
		this.head = null;
	}
	
	public void add(Task task) {
		Node temp = new Node(task);
		
		if(head == null) {
			head = temp;
		}
		else {
			Node curr = head;
			while(curr.next != null) {
				curr = curr.next;
			}
			
			curr.next = temp;
		}
	}
	
	public Task search(String Id) {
		Node curr = head;
		while(curr != null) {
			if(curr.task.getTaskId().equals(Id)) {
				return curr.task;
			}
			curr = curr.next;
		}
		return null;
	}
	
	public void traverse() {
		Node curr = head;
		while(curr != null) {
			System.out.println(curr.task);
			curr = curr.next;
		}
	}
	
	public void delete(String Id) {
		if(head == null) return ;
		
		if(head.task.getTaskId().equals(Id)) {
			head = head.next;
			return;
		}
		
		Node curr = head;
		while(curr.next != null && !curr.next.task.getTaskId().equals(Id)) {
			curr = curr.next;
		}
		
		if(curr.next != null) curr.next = curr.next.next;	
	}
	
	public static void main(String[] args) {
		Main tl = new Main();
		
		tl.add(new Task("T1","Front End","In Progress"));
		tl.add(new Task("T2","Back End","Not Started"));
		tl.add(new Task("T3","User Interface","Completed"));
		
		System.out.println("Search for Task:");
		System.out.println(tl.search("T2"));
		
		System.out.println("\nDeleting:");
		tl.delete("T2");
		
		System.out.println("\nTraversal:");
		tl.traverse();
	}
}
