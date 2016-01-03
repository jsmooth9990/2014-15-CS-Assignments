//Winston Li
public class Priorityqueue 
{
	private Prioritynode head; //no tail
	
	public Priorityqueue()
	{
		head = null;
	}
	
	public boolean empty()
	{
		return head == null;
	}
	
	public void insert(Vertice data) //queue will be sorted increasing weight from head
	{
		Prioritynode before = null; //placeholder
		Prioritynode temp = head;
		Prioritynode toadd = new Prioritynode(data);
		
		while(temp != null && ((temp.getData()).getWeight() <= data.getWeight()))//insertion will be right after before
		{
			before = temp;
			temp = temp.getNext();
		}
		if(before == null) //case for if insertion must be at the beginning
		{
			toadd.setNext(head);
			head = toadd;
		}
		else
		{
			toadd.setNext(temp);
			before.setNext(toadd);
		}
		
	}
	public Vertice peek()
	{
		return head.getData();
	}
	
	public Vertice extractMin() //head is always lowest weight
	{
		Vertice result = head.getData();
		head = head.getNext();
		return result;
	}
	
}
