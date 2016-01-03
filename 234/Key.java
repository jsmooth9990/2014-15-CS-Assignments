	
public class Key 
{
	private String data;
	private boolean deleted;
	
	public Key(String data)
	{
		this.data = data;
	}
	public String key()
	{
		return data;
	}
	public boolean present()
	{
		return !deleted;
	}
	public void setDeleted()
	{
		deleted = true;
	}
	public void undelete()
	{
		deleted = false;
	}
}
