import java.util.Scanner;


public class Tree 
{
	private Node root;
	
	public Tree()
	{
		Node temp= new Node("sea monkey", null, null); //one default question
		root = temp;
	}
	
	public Node root()
	{
		return root;
	}
	
	public void game()
	{
		Scanner scan = new Scanner(System.in);
		Node current = root;
		Node i = current; //i used as counter
		Node before;
		boolean check = false;
		String answer = "";
		while(current !=null) 
		{
			System.out.println(current.getQuestion());
			check = false; //before this wasnt set so when check was true it skipped the followlo answer was never changed
			while(!check)
			{
				
				answer = scan.nextLine();
				check = true;
				if(answer.charAt(0) != 'n' && answer.charAt(0) != 'y')
				{
					check = false;
					System.out.println("try again, that wasnt yes/no. btw I cant read uppercase");
					
				}
			}
			
			
			
			if(answer.charAt(0) == 'y' && current.getYes() == null) //current is leaf answer is yes
			{
				System.out.println("I win the game, would you like to restart?");
				answer = scan.nextLine();
				if(answer.charAt(0) == 'n')  //optional game restart
				{
					System.out.println("byebye");
					System.exit(0);
				}else{
					current = root;
					i = current;
				}
			}else if(current.getYes() == null && current.getNo() == null && answer.charAt(0) == 'n')
			{ //current is a leaf and answer is no
				
				
				
				System.out.println("what is your thing");
						
					
				
				answer = scan.nextLine();
				Node newleaf = new Node(answer, null, null); //new leaf with new animal
				
				System.out.println("what is one unique property");
				answer = scan.nextLine();
								Node property = new Node(answer, newleaf, current); //new node with new question
				
				if(current == root) //check for if it was the first node
				{ //special case for first addition
					root = property;
					//System.out.println("root is now " + root.getQuestion());
				//	System.out.println("no is " + (root.getNo()).getQuestion());
					//System.out.println("yes is " + (root.getYes()).getQuestion());
				}
				else if(i.getYes() == current)
				{
					
				
					i.setYes(property);
				//	System.out.println(i.getQuestion() + "  no is still " + (i.getNo()).getQuestion());
				}
				else if(i.getNo() == current)
				{
					i.setNo(property);
				}
				System.out.println("thanks for the info, new game startin");
				current = root;
				i = root;
				
			}
			else if(current.getYes() != null && answer.charAt(0) == 'y') //yes and current is not leaf
			{
				
				current = current.getYes();
				if(current.getYes() != null) //when current is a leaf i will stay as parent
				{
					i = current;
				}
			
			}
			else if(current.getNo() != null && answer.charAt(0) == 'n') //no and current not a leaf
			{
				
				current = current.getNo();
				
				if(current.getYes() != null) //when current is leaf i will stay as parent
				{
					i = current;
				}
			}
		}
	}
}






























