
public class Runner 
{
	public static void main(String[] arg)
	{
		Queue myQueue = new Queue(5);
		try{
		myQueue.enqueue("I");
		myQueue.enqueue("think,");
		myQueue.enqueue("therefore");
		myQueue.enqueue("i");
		
		while(!myQueue.isEmpty())
		{
			System.out.println(myQueue.dequeue());
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}
}
