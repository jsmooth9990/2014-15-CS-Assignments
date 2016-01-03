
public class Node 
{
	private int data;
	private Node next;
	
	
	
	public Node(int _data)
	{
		next = null;
		data = _data;
	}
	
	//accessors and mutators
	public int getData()
	{
		return data;
	}
	
	

	
	public void setNext(Node _next)
	{
		next = _next;
	}

	public Node getNext() {
		return next;
	}
}
