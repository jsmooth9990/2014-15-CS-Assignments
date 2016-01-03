import java.io.*;
import java.util.*;
public class Concordance 
{
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner input = new Scanner(new FileReader("bunny"));
		Map<String, TreeSet<Integer>> mymap = new TreeMap<String, TreeSet<Integer>>(); //map holds string keys, integer data
		int i = 1;
		while(input.hasNextLine()) //outer loop formats all punctuation
		{
			
			String data = input.nextLine();
			if(data.equals("exit"))
			{
				break;
			}
			//System.out.println("data is: " + data + "at line "+i);
			if(!data.isEmpty())
			{
				//System.out.println("data is not empty, is: " + data);
				data = data.toLowerCase().replaceAll("[^a-zA-Z' ]", ""); //go lowercase, remove punctuation
				//System.out.println("data has been changed to: " + data);
				String[] words = data.split(" "); //split each string 
			
			
				for(int j = 0; j < words.length; j++) //inner loop adds to the treemap
				{
					//System.out.println("number " + (j+1) + " in words array is " + words[j]);
					TreeSet<Integer> temp = mymap.remove(words[j]); //removes entry with old string key value
					if(temp != null)
					{
						//System.out.println("later time, adding " + words[j] + " at line " + i);
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
		  //System.out.println("reache2d");
		  Set set = mymap.entrySet(); //creates a set that is the entry set of the treemap 
	      Iterator myiter = set.iterator(); 
	      while(myiter.hasNext()) 
	      {
	         Map.Entry entry = (Map.Entry)myiter.next(); //create keyvalue pair
	         
	         String a = (String)entry.getKey();
	        
	         for(int b = 0; b < 10-a.length(); b++)
	         {
	        	 System.out.print(" ");
	         }
	         System.out.print(a + ": ");
	         TreeSet<Integer> toprint = (TreeSet)entry.getValue();
	         
	         for(Integer x : toprint)
	         {
	        	 
	        	 System.out.print(x);
	        	 if(x != toprint.last())
	        	 {
	        		 System.out.print(", ");
	        	 }
	         }
	         System.out.println();
	         
	       
	      }
		
	  
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
