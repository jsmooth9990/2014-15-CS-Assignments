import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Breadth 
{
	public static void main(String[] args)
	{
		
		
		String[] storage = getInp();
		int V = Integer.parseInt(storage[0]);
		
		int[][] thisArray;
		thisArray = new int[V][V];
		for(int row = 0; row < V; row++) //goes through each row
		{
			String s = storage[row + 1];
			//System.out.println(s);
			for(int col = 0; col < V; col++)
			{
				thisArray[row][col] = Character.getNumericValue(s.charAt(col));
				
			}
		}
		
		Graph myGraph = new Graph(thisArray, storage[storage.length -1]);
		
	
		
		System.out.println(myGraph.breadthFirst(storage[storage.length - 1]));
		
	
	
	}
	public static String[] getInp()    //method to get input
	{
	List<String> stringinps = new ArrayList<>(); //string inps is a new list

		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s = new String();
			s = br.readLine();                        //s is the next input string
			while((s!= null) && (s.length() > 0))     //loops through all input
			{
				stringinps.add(s);                //s is added as next element of stringinps
				s=br.readLine();                  //s is redefined as the next string
			}
			br.close();                               //close buffered reader
			String[] array = new String[stringinps.size()]; //array will be the array of inputs
			//size of stringinps is the size of the returned input array
			return stringinps.toArray(array); //values of list stringinps are sent to array of same size
		}
		catch(Exception e)
		{
			System.out.println("Ack!:"+e); //Ack
		}
	  
		return null;


	}
}
