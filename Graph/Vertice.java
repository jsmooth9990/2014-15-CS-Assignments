
public class Vertice 
{
	private int index;
	private int fromIndex; //index of prev vertice
	private int weight; 
	
	public Vertice(int index, int fromIndex, int weight)
	{
		this.index = index;
		this.fromIndex = fromIndex;
		this.weight = weight;
	}
	public int getIndex()
	{
		return index;
	}
	public int getFrom()
	{
		return fromIndex;
	}
	public int getWeight()
	{
		return weight;
	}
}
