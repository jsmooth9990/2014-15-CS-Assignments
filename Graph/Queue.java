
import java.util.*;

public class Queue
{
	private Node head;
	private Node tail;
	
	
	
	
	public boolean empty()
	{
		return head == null;
	}
	public void enqueue(int data) 
	{
		Node temp = new Node(data);
		if(empty()) //condition for empty queue
		{
			head = temp;
			tail = temp;
		}
		else{
		tail.setNext(temp); //appends to end of queue
		tail = temp;
		}
	}
	
	public int dequeue()
	{
		
			Node temp = head; //tail is unneeded
			head = head.getNext(); //if the queue becomes empty, tail is irrelevant because it will be reassinged
			return temp.getData();
		
		
		
	}
	
	public int peek()
	{
		return head.getData();
	}
	
	public Queue() 
	{
		head = null;
		tail = head;
		
	}
	
	
	
	
	
	
	
	
}	
	

	
	
	
	
	
	
	
	
	
	




