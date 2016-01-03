
public class Prioritynode 
{
	private Vertice data;
	private Prioritynode next;
	
	public Prioritynode(Vertice data)
	{
		this.data = data;
		next = null;
	}

	public void setNext(Prioritynode _next)
	{
		next = _next;
	}
	public Prioritynode getNext()
	{
		return next;
	}
	public Vertice getData()
	{
		return data;
	}
}
