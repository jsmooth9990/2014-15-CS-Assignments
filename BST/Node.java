
public class Node 
{
	private String key;
	private Node left;
	private Node right;
	
	public Node(String key)
	{
		this.key = key;
		left = null;
		right = null;
		
	}
	public String key()
	{
		return key;
	}
	public Node left()
	{
		return left;
	}
	public void setleft(Node data)
	{
		left = data;
	}
	public Node right()
	{
		return right;
	}
	public void setright(Node data)
	{
		right = data;
	}
}
