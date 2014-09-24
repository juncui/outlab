package outlab;
import java.util.ArrayList;

public class Graph 
{
	private ArrayList<Vertex> vertexList = new ArrayList<Vertex>();
	private ArrayList<Edge> edgeList = new ArrayList<Edge>();
	
	public void addVertex(Vertex newVertex)
	{
		vertexList.add(newVertex);
	}
	
	public void addEdge(Edge newEdge)
	{
		edgeList.add(newEdge);
	}
	
	public ArrayList<Vertex> getVertexList()
	{
		return vertexList;
	}
	
	public ArrayList<Edge> getEdgeList()
	{
		return edgeList;
	}
	
	public void removeVertex(Vertex vertex)
	{
		vertexList.remove(vertex);
	}
	
	public void removeEdge(Edge edge)
	{
		edgeList.remove(edge);
	}
	
	public void clearEdgeList()
	{
		edgeList.clear();
	}
	
	public void clearVertexList()
	{
		vertexList.clear();
	}
}
