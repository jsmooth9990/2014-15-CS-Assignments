import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner 
{
	public static void main(String[] arg)
	{
		BST myBST = new BST(); 
		
		Scanner myscan = new Scanner(System.in);
		String a = myscan.nextLine();
	//	String[] storage = getInp();
		
		while(a.charAt(0) != 'q')
		{
			String temp = whiteCheck(a);
			
			if(a.charAt(0) == 'p')
			{
			
				myBST.traversalaccess();
			}
			else if(a.charAt(0) == 'd')
			{
				if(!myBST.delete(temp))
				{
					System.out.println(temp + " not present to delete");
				}
				else
				{
					System.out.println(temp + " Has been extirpated");
				}
			}
			else if(a.charAt(0) == 'c')
			{
				if(myBST.searchAccess(temp))
				{
					System.out.println(temp + " is present");
				}
				else
				{
					System.out.println(temp + "? aint seen no sign of no " + temp + " round htese parts govnr");
				}
			}
			else if(a.charAt(0) == 'i')
			{
				myBST.insert(temp);
				System.out.println("lookee here theres a " + temp +" inserted!");
			}
			
			else
			{
				System.out.println("UNRECOGNIZED CMD ALERT ALERT");
			}
			a = myscan.nextLine();
			
		}
		System.out.println("oh no shutdown");
		System.exit(0);

		
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
	public static String whiteCheck(String data)
	{
		String output = data.substring(1);
		return output.trim();
	}
	
}
