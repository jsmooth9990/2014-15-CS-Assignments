import java.util.Scanner;

public class run234
{
	public static void main(String[] args)
	{
		Tree myTree = new Tree();
		Scanner myscan = new Scanner(System.in);
		String a = myscan.nextLine();
	
		
		while(a.charAt(0) != 'q')
		{
			String temp = whiteCheck(a);
			
			if(a.charAt(0) == 'p')
			{
			
				myTree.Traversalaccess();
			}
			else if(a.charAt(0) == 'd')
			{
				if(!myTree.delete(temp))
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
				if(myTree.searchaccess(temp))
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
				myTree.insert(temp);
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
		
	public static String whiteCheck(String data)
	{
		String output = data.substring(1);
		return output.trim();
	}
	
}
