package outlab;


public class Edge 
{
	private int value;
	private String edgeLabel;
	private Vertex x;
	private Vertex y;
	
	public Edge(Vertex start, Vertex end)
	{
		value = 0;
		x = start;
		y = end;
		edgeLabel = "";
	}
	
	public Vertex getStartVertex()
	{
		return x;
	}
	
	public Vertex getEndVertex()
	{
		return y;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public String getEdgeLabel()
	{
		return edgeLabel;
	}
	
	public void setValue(int newValue)
	{
		value = newValue;
	}
	
	public void setEdgeLabel(String edgeLabel)
	{
		this.edgeLabel = edgeLabel;
	}
}
