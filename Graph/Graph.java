import java.lang.Object;
import java.lang.Iterable;
import java.util.Iterator;
import java.util.Scanner;

public class Graph implements Iterable
{
	
	private int[][] thisArray;
	int current;
	private String start;
	private String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private boolean[] flags;
	
	public Graph(int[][] storage, String start)
	{
		
		thisArray = storage;
		this.start = start;
		
	
		flags = new boolean[thisArray[0].length];
		for(int p = 0; p< thisArray[0].length; p++)
		{
			flags[p] = false;
		}
		
	}
	
	
	public Iterator iterator()
	{
		return new myIter();
	}
	
	public class myIter implements Iterator
	{
		int i; //index of current node iterator is working on
		public myIter()
		{
			i = current;
		}
		
		public boolean hasNext()
		{
			for(int j = 0; j < thisArray[0].length; j++)
			{
				if((thisArray[i][j] != 0) && flags[j] == false)
				{
					return true;
				}
			}
			return false;
		}
		
		public Object next()
		{
			for(int j = 0; j < thisArray[0].length; j++)
			{
				if((thisArray[i][j] != 0) && flags[j] == false)
				{
					return j;
				}
			}
			return null;
		}
		
		public void remove()
		{
			//will not be used
		}
	}
	
	public String breadthFirst(String start)
	{
		String output = start;
		int i = 0;
		for(int j = 0; letters.charAt(j) != start.charAt(0); j++) //finds index of start letter
		{
			i++;
		}
		
		Queue myQueue = new Queue();
		
		myQueue.enqueue(i);
		flags[i] = true;
		int temp;
		while(!myQueue.empty())
		{
			
			current = myQueue.dequeue();
			
			Iterator secIter = iterator();
	
			
			while(secIter.hasNext())
			{
				
				temp = (int)secIter.next();
				flags[temp] = true;
				myQueue.enqueue(temp);
				
				output += letters.charAt(temp);
				
				
			
			}
		}
		
		return output;
	}
	
	public String depthFirst(String start)
	{
		String output = start;
		int i = 0;
		for(int j = 0; letters.charAt(j) != start.charAt(0); j++) //finds index of start letter
		{
			i++;
		}
		
		Stack myStack = new Stack();
		myStack.push(i);
		//System.out.println(i);
		int temp;
		flags[i] = true;
		while(!myStack.empty())
		{
			current = myStack.peek();
		
			Iterator firstIter = iterator();
			
			if(firstIter.hasNext())
			{
				current = (int)firstIter.next();
				//System.out.println("the next unvisited was found to be " + temp);
				flags[current] = true;
				myStack.push(current);
				output += letters.charAt(current);
				//System.out.println("output so far " + output);
				
			}
			else
			{
				myStack.pop();
			}
			
			//System.exit(0);
		}
		
		return output;
	}
	
	public int nextUnvisited(int i)
	{
		for(int j = 0; j < thisArray[0].length; j++)
		{
			if((thisArray[i][j] != 0) && flags[j] == false)
			{
				return j;
			}
		}
		return -1;
	}
	
	public boolean hasUnvisited(int i)
	{
		for(int j = 0; j < thisArray[0].length; j++)
		{
			if((thisArray[i][j] != 0) && flags[j] == false)
			{
				return true;
			}
		}
		return false;
	}
	
	
	
	//public void addEdge(int V1, int V2)
	//{
		//thisArray[V1][V2] = 1;
		//thisArray[V2][V1] = 1;
	//}
	
	
	
	public void print()
	{
		//System.out.println("Matrix representation:");
		//System.out.print("  ");
	//	for(int k = 0; k < V; k++)
		//{
			//System.out.print(vArray[k].label() + " ");
		//}
		//System.out.println();
		for(int i = 0; i < thisArray[0].length; i++)
		{
			//System.out.print(vArray[i].label() + " ");
			for(int j = 0; j < thisArray[0].length; j++)
			{
				System.out.print(thisArray[i][j] + " ");
			}
			System.out.println();
		}
	}

}
