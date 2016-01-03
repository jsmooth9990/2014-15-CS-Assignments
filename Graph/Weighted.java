import java.util.Iterator;

public class Weighted implements Iterable 
{
	private int[][] thisArray; //2d array
	private int current; 
	private String start; 
	private String end;
	private String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
	private boolean[] flags;
	
	public Weighted(int[][] storage, String start, String end) //constructor
	{
		
		
		thisArray = storage;
		this.start = start;
		this.end = end;
	
		flags = new boolean[thisArray[0].length];
		for(int p = 0; p< thisArray[0].length; p++)
		{
			flags[p] = false;
		}
		
	}
	
	
	public String breadthFirst()
	{
		String[] paths = new String[flags.length];
		Priorityqueue mypq = new Priorityqueue();
		String output = " "; 
		int i = 0;
		for(int j = 0; letters.charAt(j) != start.charAt(0); j++) //finds index of start letter
		{
			i++;
		}
		
		
		
		Vertice startpoint = new Vertice(i, 26, 0); //temp1 is vertice for start point
		mypq.insert(startpoint); //push starting vertice to min priority queue
		flags[i] = true;    //start pt is visited
		
		while(!mypq.empty())
		{
			
			
			Vertice temp = mypq.extractMin(); //point with loweest distance
		
			
			current = temp.getIndex(); //gets index of plowest distance point
			if(letters.charAt(temp.getFrom()) != output.charAt(output.length()-1))
			{
				
				output = paths[temp.getFrom()];
				
				output += Character.toString(letters.charAt(current));
				
				paths[current] = output;
				
			}
			else{
				output += Character.toString(letters.charAt(current));
				paths[current] = output;
			
			}
		
	
			
			Iterator secIter = iterator();
	
			
			while(secIter.hasNext())
			{
				
				int k = (int)secIter.next();        //next unvisited node 
				
				flags[k] = true;                    //is set as visited

				int distance = (temp.getWeight()) + thisArray[current][k];
				if(letters.charAt(k) == end.charAt(0))
				{
					output += end;
					output += " distance is ";
					output += Integer.toString(distance);
					return output;
				}
				
				Vertice temporary = new Vertice(k, current,distance);
				mypq.insert(temporary);                //will push in all unvisited points
				
				
				
				
			
			}
		}
		
		return "THIS PATH LOOKS IMPOSSIBLE WERE ALL GONNA DIE OH NOO";
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
	
}
