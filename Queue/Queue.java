import java.util. *;
public class Queue 
{
	private int maxSize;
	private int head;
	private int tail;
	private int count;
	
	private String[] circularArray;
	
	public Queue(int size)
	{
		maxSize = size;
		head = 0;
		tail = 0;
		count = 0;
		circularArray = new String[maxSize];
	}
	
	public void enqueue(String data) throws Overflow
	{
		if(count != maxSize)
		{
			tail = (tail+1)%maxSize;
			circularArray[tail] = data;
		
			count++;
		}
		else
		{
			throw new Overflow("queue overflow abort abort");
		}
	}
	public String dequeue() throws Underflow
	{
		if(!isEmpty())
		{
			head = (head+1)%maxSize;
			count--;
			
			return circularArray[head];
			
		}
		else
		{
			throw new Underflow("queue underflow abort abort");
		}
	}

	public boolean isEmpty()
	{
		return count == 0;
	}

}

class Overflow extends Exception
{
	Overflow(String s)
	{
		super(s);
	}
}

class Underflow extends Exception
{
	Underflow(String s)
	{
		super(s);
	}
}
