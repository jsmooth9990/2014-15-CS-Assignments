
public class Tree 
{
	private Node root;
	
	public Tree()
	{
		root = null;
	}
	
	public void Traversal(Node current) //recursive traversal
	{
		if(current == null) //returns when a null node is reached
		{
			return;
		}
		Traversal(current.getllnode()); //traverse the leftmost subtree
		
		if(current.left().present())
		{
		System.out.println(current.left().key()); //print the left key
		}
		Traversal(current.getlmnode()); //print out subtree between left and middle key
		
		if(current.middle() != null) //if a middle key exists
		{
			if(current.middle().present())
			{
			System.out.println(current.middle().key()); //print out middle key
			}
			Traversal(current.getmrnode()); //print out subtree to right of middle key
		}
		else //middle key does not exist, only 1 key in this node, method ends
		{
			return; 
		}
		if(current.right() != null) //right side key exists?
		{
			if(current.right().present())
			{
			System.out.println(current.right().key()); //print out right key
			}
			Traversal(current.getrrnode()); //traverse rightmost subtree
		}
	}
	
	public void Traversalaccess()
	{
		Traversal(root); //start traversal at the rot
	}
	
	public void insert(String data) 
	{
		if(root == null)  //special case when first inserting into empty tree
		{
			root = new Node(new Key(data)); //root set to a new node with 1 key
			return;
		}
		if(root.fournode()) //tests if root is a fournode
		{
		
			
			Node oldll = root.getllnode(); //create references to root's 4 children
			Node oldlm = root.getlmnode();
			Node oldmr = root.getmrnode();
			Node oldrr = root.getrrnode();
			
			Node newmid = new Node(root.middle()); //create 3 new nodes for root's 3 keys
			Node newleft = new Node(root.left());
			Node newright = new Node(root.right());
			
			newleft.setllnode(oldll); //set root's leftmost child to the new left node's left child
			newleft.setlmnode(oldlm); //set root's second leftmost child to new left node's right child
			newright.setllnode(oldmr); //set root's second rightmost child to new right node's left child
			newright.setlmnode(oldrr); //set root's rightmost child to new right nodes right child
			
			newmid.setllnode(newleft); //moves the new middle node up
			newmid.setlmnode(newright);
			root = newmid; //establish a new root
			
		}
		
		Node parent = root;
		
		Node temp = root;
	
		while(parent.nextnode(new Key(data)) != null) //loops to find place to insert, keeps going until the path for the data to be inserted is null
		{
			
			temp = parent.nextnode(new Key(data)); //sets temporary node equal to nextnode in path
		
			if(temp.fournode()) //check each time for a fournode
			{
				
				Node oldll = temp.getllnode(); //set 4 markers for the fournode's children
				Node oldlm = temp.getlmnode();
				Node oldmr = temp.getmrnode();
				Node oldrr = temp.getrrnode();
				
				Node newleft = new Node(temp.left());
				Node newright = new Node(temp.right());
				
				newleft.setllnode(oldll);
				newleft.setlmnode(oldlm);
				
				newright.setllnode(oldmr);
				newright.setlmnode(oldrr);
				
				parent.insert(temp.middle().key());
				
				if(parent.left().key().compareTo(newleft.left().key()) > 0)
				{
					parent.setllnode(newleft);
					parent.setlmnode(newright);
					parent.setmrnode(null);
					parent.setrrnode(null);
				}
				else if(parent.count() >= 2 && parent.middle().key().compareTo(newleft.left().key()) > 0)
				{
					parent.setllnode(null);
					parent.setlmnode(newleft);
					parent.setmrnode(newright);
					parent.setrrnode(null);
				}
				else
				{
					parent.setllnode(null);
					parent.setlmnode(null);
					parent.setmrnode(newleft);
					parent.setrrnode(newright);
				}
				
			
				newleft.setllnode(oldll);
				newleft.setlmnode(oldlm);
				newright.setllnode(oldmr);
				newright.setlmnode(oldrr);
			
				temp = parent.nextnode(new Key(data)); //sets temp to the correct nextnode
			}
			parent = temp; //parent goes down with temp
			
		}
		//Actual insertion begins, temp is the 
		if(temp.isleaf()) //if inserting at a leaf
		{
			temp.insert(data); //adds key to the leaf
			
		}
		else //if we are not inserting at a leaf we must create a new node
		{
			if(temp.left().key().compareTo(data) > 0) //if the key belongs to the left
			{
				temp.setllnode(new Node(new Key(data))); //set left node to a new node with key
			}
			else if(temp.count() == 2 && temp.middle().key().compareTo(data) > 0) //if there are 2 keys and data belongs to the left of 2nd key
			{
				temp.setlmnode(new Node(new Key(data))); //set middle node to new node with key
			}
			else //data belongs on right
			{
				temp.setmrnode(new Node(new Key(data))); //right node set to new node with key
			}
		}
		
	}
	public boolean searchaccess(String data)
	{
		
		return search(new Key(data), root); //start search at root
	}
	
	public boolean search(Key data, Node current) //search takes the key to search for and the current node
	{
		if(current == null) //if search reaches a null node, return false
		{
			
			return false;
		}

		if(current.haskey(data)) //if search contains the target, return true
		{
		
			return true;
		}
		else //go on to next node in the sequence
		{
			
			return search(data, current.nextnode(data));
			
		}
		
	}
	public boolean delete(String data) 
	{
		if(!searchaccess(data)) //check if data is in tree
		{
			System.out.println("nothing there to delete");
			return false;
		}
		Key k = new Key(data);
		Node parent = root;
		Node temp = root;
		
		while(!parent.haskey(k)) //sets parent to node containing taget
		{
			parent = parent.nextnode(k); //paren incremented down the path
			
		}
		
		if(parent.left().key().equals(data)) //if the left key is target
		{
			parent.left().setDeleted(); //delete left key
		}
		else if(parent.middle().key().equals(data)) //if mid key is target
		{
			parent.middle().setDeleted(); //delete middle key
		}
		else //if right key is target
		{
			parent.right().setDeleted(); //delete right key
		}
		return true;
		
	}
	
}
