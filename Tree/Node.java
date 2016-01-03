
public class Node 
{
	private String question;
	private Node yes;
	private Node no;
	
	public Node(String data, Node yes, Node no)
	{
		question = data + "?";
		this.yes = yes;
		this.no = no;
	}
	
	
	public String getQuestion()
	{
		return question;
	}
	public void setYes(Node data)
	{
		yes = data;
	}
	public void setNo(Node data)
	{
		no = data;
	}
	public Node getYes()
	{
		return yes;
	}
	public Node getNo()
	{
		return no;
	}
}
