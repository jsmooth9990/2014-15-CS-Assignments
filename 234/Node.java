
public class Node 
{
	private Key left;  //holds the 3 keys
	private Key middle;
	private Key right;
	private int keycount; //the number of keys 
	
	private Node llnode; //4 references to children
	private Node lmnode;
	private Node mrnode;
	private Node rrnode;
	
	public Node(Key firstkey) //the first key created is always the left key
	{
		left = firstkey;
		keycount = 1;
	}
	
	public boolean isleaf() //tests if a node is a leaf
	{
		return (llnode == null && lmnode == null && mrnode == null && rrnode == null);
	}
	
	public int count() //returns number of keys
	{
		return keycount;
	}
	
	public boolean fournode() //tests if node is a fournode
	{
		return keycount == 3;
	}
	
	public boolean haskey(Key data) //tests if node contains a certain key
	{
		
		if(data.key().equals(left.key()) && left().present()) //if left key is data
		{
			return true;
		}
		else if(middle != null && data.key().equals(middle.key()) && middle().present()) //if middle key is data
		{
			return true;
		}
		else if(right != null && data.key().equals(right.key()) && right().present()) //if right key is data
		{
			return true;
		}
			
		return false;
	}
	
	public Node nextnode(Key data) //given data, decides which child's subtree data should be located in
	{
		
		if(keycount == 1) //if only 1 key
		{
			if(data.key().compareTo(left.key()) < 0) //go to leftmost child
			{
				return llnode;
			}
			else    //otherwise go to the second leftmost child
			{
				return lmnode;
			}
		}
		else if(keycount == 2) //if only 2 keys
		{
			if(data.key().compareTo(left.key()) < 0) //if belongs to the left of the first key
			{
				return llnode; //return leftmost node
			}
			else if(data.key().compareTo(middle.key()) < 0) //if belongs to the left of the middle key and right of first key
			{
				return lmnode; //return second leftmost node
			}
			else //must belong t right of second key
			{
				return mrnode; //second rightmost node
			}
		}
		else //3 keys
		{
			if(data.key().compareTo(left.key()) < 0) //if belongs to left of first key
			{
				return llnode; //left most node
			}
			else if(data.key().compareTo(middle.key()) < 0) //belongs right of first key left of second
			{
				return lmnode; //second leftmost node
			}
			else if(data.key().compareTo(right.key()) < 0) //belongs right of second key left of third
			{
				return mrnode; //second rightmost node
			}
			else //belongs to the right of the third key
			{
				return rrnode; //rightmost node
			}
		}
		
	}
	
	public void insert(String newkey) //inserts new key into the node
	{
		keycount++;
		if(keycount == 2) //if there are now 2 keys
		{
			Key temp = left;
			Key temp2 = new Key(newkey);
			
			if(temp.key().compareTo(temp2.key()) < 0)
			{
				left = temp;
				middle = temp2;
			}
			else
			{
				left = temp2;
				middle = temp;
			}
		}
		else
		{
			Key temp = left;
			Key temp2 = middle;
			Key temp3 = new Key(newkey);
			
			if(temp.key().compareTo(temp2.key()) < 0 && temp2.key().compareTo(temp3.key()) < 0)
			{
				right = temp3; //order of temp1, 2, 3
			}
			else if(temp.key().compareTo(temp3.key()) < 0 && temp3.key().compareTo(temp2.key()) <0)
			{
				middle = temp3; //order temp1, 3, 2
				right = temp2;
			}
			else if(temp2.key().compareTo(temp.key()) < 0 && temp.key().compareTo(temp3.key()) < 0)
			{
				left = temp2; //order temp2, 1, 3
				middle = temp;
				right = temp3;
			}
			else if(temp2.key().compareTo(temp3.key()) < 0 && temp3.key().compareTo(temp.key()) < 0)
			{
				left = temp2; //order temp2, 3, 1
				middle = temp3;
				right = temp;
			}
			else if(temp3.key().compareTo(temp.key()) < 0 && temp.key().compareTo(temp2.key()) < 0)
			{
				left = temp3; //order temp3, 1, 2
				middle = temp;
				right = temp2;
			}
			else
			{
				left = temp3; //order temp3, 2, 1
				middle = temp2;
				right = temp;
			}
		}
	}
	
	

	public Key left()
	{
		return left;
	}
	public Key middle()
	{
		return middle;
	}
	public Key right()
	{
		return right;
	}
	//accessors mutators
	public Node getllnode()
	{
		return llnode;
	}
	public Node getlmnode()
	{
		return lmnode;
	}
	public Node getmrnode()
	{
		return mrnode;
	}
	public Node getrrnode()
	{
		return rrnode;
	}
	public void setllnode(Node data)
	{
		llnode = data;
	}
	public void setlmnode(Node data)
	{
		lmnode = data;
	}
	public void setmrnode(Node data)
	{
		mrnode = data;
	}
	public void setrrnode(Node data)
	{
		rrnode = data;
	}
	
}
