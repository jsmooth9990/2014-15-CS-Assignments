
public class BST 
{
	private Node root;
	
	
	public void traversalaccess()
	{
		traversal(root);
		
	}
	
	private void traversal(Node head)
	{
		if(head == null)
		{
			return;
		}
			
		traversal(head.left());
		
		System.out.println(head.key());
		
		
			
		traversal(head.right());
		
	}
	
	public BST()
	{
		root = null;
	}
	
	public boolean empty()
	{
		return root == null;
	}
	
	public boolean delete(String data) //delete
	{
		Node current = root;
		
		if(!searchAccess(data))
		{
			
			return false;
		}
		if((root.key()).equals(data)) //oh boy now we delete the root
		{
			
			if(root.left() == null && root.right() == null) //root has no kids
			{
				root = null;
				
			}
			else if(root.left() == null && root.right() != null) //root has one kid
			{
				root = root.right();
			
			}
			else if(root.left() != null && root.right() == null)
			{
				root = root.left();
				
			}
			else //2 children
			{
				
				current = root.right();
				while(current.left() != null) //min node in right subtree
				{
					current = current.left();
				}
			//	System.out.println("current is " + current.key());
				Node parent = root.right();
				if(parent == current)
				{
				
					Node temp = root.left();
					root = current;
					current.setleft(temp);
					
				}
				else
				{
					while(parent.left() != current) //find parent of min node
					{
						parent = parent.left();
					}
					Node temp = root.left();
					Node temp2 = root.right();
					root = current;
					current.setleft(temp);
					current.setright(temp2);
					parent.setleft(null);
				}
				
				
			}
			return true;
		
		}
		
		while(current.left() != null || current.right() != null) //finds node who's child is the prey
		{
			if(current.left() != null)
			{
				if((current.left()).key().equals(data))
				{
					break;
				}
			}
			if(current.right() != null)
			{
				if((current.right()).key().equals(data))
				{
					break;
				}
			}
			if(current.key().compareTo(data) < 0)
			{
				current = current.right();
				
			}
			else
			{
				current = current.left();
				
			}
		}
		Node target;
		//its time to eliminate u my frind
		if((current.key()).compareTo(data) < 0) //if the target node is to the right of the current node
		{
			target = current.right();
			if(target.right() == null && target.left() == null)
			{//case: no children, how fortunate
				current.setright(null);
			}
			else if(target.right() == null && target.left() != null) //cases for target has 1 kid
			{
				current.setright(target.left());
			}
			else if(target.right() != null && target.left() == null)
			{
				current.setright(target.right());
			}
			else //target has an entire tree attached to it 
			{
				Node temp = target.right();
				while(temp.left() != null) //finds minimum value to the right of the target
				{
					temp = temp.left();
				}
				Node parent = target.right();
				if(parent == temp)
				{
					current.setright(temp);
					temp.setleft(target.left());
				}
				else
				{
					while(parent.left() != temp)
					{
						parent = parent.left(); //parent of the minimum value
					}
					Node temp2 = target.right();
					current.setright(temp); //removes target node
					parent.setleft(null); //removs reference to temp at bottom of tree
					temp.setleft(target.left()); //sets temps left side to the left tree
					temp.setright(temp2);
				}
			}
		}else{ //target is on the left
			
			target = current.left();
			if(target.right() == null && target.left() == null)
			{//case: no children, how fortunate
				current.setleft(null);
			}
			else if(target.right() == null && target.left() != null) //cases for target has 1 kid
			{
				current.setleft(target.left());
			}
			else if(target.right() != null && target.left() == null)
			{
				current.setleft(target.right());
			}
			else //target has an entire tree attached to it 
			{
				Node temp = target.right();
				while(temp.left() != null) //finds minimum value to the right of the target
				{
					temp = temp.left();
				}
				Node parent = target.right();
				if(parent == temp)
				{
					current.setleft(temp);
					{
						temp.setleft(target.left());
					}
				}
				else
				{
					while(parent.left() != temp)
					{
						parent = parent.left(); //parent of the minimum value
					}
					Node temp2 = target.right();
					current.setleft(temp); //removes target node
					parent.setleft(null); //removs reference to temp at bottom of tree
					temp.setleft(target.left()); //sets temps left side to the left tree
					temp.setright(temp2);
				}
			}
		}
		
		return true;
	
	}
	
	
	public boolean searchAccess(String data)
	{
		if(empty())
		{
			return false;
		}
		return search(data, root);
	}
	
	private boolean search(String data, Node head) //recursively search for data
	{
		
		if((head.key()).equals(data)) //test if head's key matches
		{
			return true;
		}
		if((head.key()).compareTo(data) < 0) //if data would be on right of head
		{
			if(head.right() != null)
			{
				head = head.right();
				return search(data, head);
			}
			else //no more nodes to search key for
			{
				return false;
			}
		}
		else
		{
			if(head.left() != null)
			{
				head = head.left();
				return search(data, head);
			}
			else
			{
				return false;
			}
		}
	}
	
	public void insert(String data) //inserts node with key data
	{
		if(root == null)
		{
			root = new Node(data);
			return;
		}
		Node current = root;
		while(current != null) //sets current to right before
		{
			if((current.key()).compareTo(data) < 0) //data belongs to the right of current
			{
				if(current.right() != null)
				{
					current = current.right();
				}
				else //if current's right node is null, leave the loop
				{
					current.setright(new Node(data)); //adds the new node
					break;
				}
			}
			else //data belongs to the left of current
			{
				if(current.left() != null)
				{
					current = current.left(); //if there is a left node, go to left node
				}
				else
				{
					current.setleft(new Node(data));
					break;
				}
			}
		}
	}
	
	
}
