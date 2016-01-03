import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Linenumber
{
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Map<String, TreeSet<Integer>> mymap = new TreeMap<String, TreeSet<Integer>>(); //map holds string keys, integer data
		int i = 1;
		while(input.hasNext()) //outer loop formats all punctuation
		{
			
			String data = input.nextLine();
			//System.out.println("data is: " + data);
			if(!data.isEmpty())
			{
				//System.out.println("data is not empty, is: " + data);
				data = data.toLowerCase().replaceAll("[^a-zA-Z' ]", ""); //go lowercase, remove punctuation
				//System.out.println("data has been changed to: " + data);
				String[] words = data.split(" "); //split each string 
			
			
				for(int j = 0; j < words.length; j++) //inner loop adds to the treemap
				{
				//	System.out.println("number " + (j+1) + " in words array is " + words[j]);
					TreeSet<Integer> temp = mymap.remove(words[j]); //removes entry with old string key value
					if(temp != null)
					{
					//	System.out.println("later time, adding " + words[j] + " at line " + i);
						temp.add(i);
					}
					else
					{
						temp = new TreeSet<Integer>();
						temp.add(i);
						//System.out.println("first time, adding " + words[j] + " at line " + i);
					}
					mymap.put(words[j], temp);
				}
			}
			i++;
			//System.out.println("reached");
		  }
		 // System.out.println("reache2d");
		  Set set = mymap.entrySet(); //creates a set that is the entry set of the treemap 
	      Iterator myiter = set.iterator(); 
	      while(myiter.hasNext()) 
	      {
	         Map.Entry entry = (Map.Entry)myiter.next(); //create keyvalue pair
	         
	         System.out.print(entry.getKey() + " appears in line(s) ");
	         TreeSet<Integer> toprint = (TreeSet)entry.getValue();
	         for(Integer x : toprint)
	         {
	        	 System.out.print(x + " ");
	         }
	         System.out.println();
	         
	       
	      }
		
	}
}
