
import java.util.*;

public class Stack
{
	private Node head;
	
	
	
	
	
	public boolean empty()
	{
		return head == null;
	}
	
	
	public int pop()
	{
		
			Node temp = head;
			head = head.getNext();
			return temp.getData();
		
		
		
	}
	
	public int peek()
	{
		return head.getData();
	}
	
	public Stack() 
	{
		head = null;
		
	}
	
	
	
	
	
	
	
	public void push(int data)
	{
		
		Node temp = new Node(data);
		temp.setNext(head);
		head = temp;
		
	
	}
}	
	

	
	
	
	
	
	
	
	
	
	




