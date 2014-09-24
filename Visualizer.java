package outlab;


import javax.swing.JFrame;

import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.graph.DelegateForest;
import edu.uci.ics.jung.graph.DirectedOrderedSparseMultigraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

import org.apache.commons.collections15.Transformer;


/**
 * Incorporates JUNG's visualization library into graph. 
 * @author Jun Cui
 *
 */

public class Visualizer
{
	private Graph g;
	private DelegateForest<Vertex, Edge> dforest = new DelegateForest<>(new DirectedOrderedSparseMultigraph<>());
	private BasicVisualizationServer<Vertex, Edge> vs;
	
	/**
	 * Step 1: construct Visualizer with a Graph object.
	 * @param graph
	 */
	public Visualizer(Graph graph)
	{
		g = graph;
	}
	
	/**
	 * Step 2: convert all vertics and edges to a DelegateForest object.
	 */
	public void graphToDelegateForest()
	{
		for (int i = 1; i <= g.getVertexList().size(); i++)
		{
			Vertex v = g.getVertexList().get(i-1);
			dforest.addVertex(v);
		}
		for (int i = 1; i <= g.getEdgeList().size(); i++)
		{
			Edge e = g.getEdgeList().get(i-1);
			dforest.addEdge(e, e.getStartVertex(), e.getEndVertex());
		}
	}
	
	/**
	 * Step 3: set up the GUI.
	 */
	public void setupGUI()
	{
		JFrame frame = new JFrame("JUNG visualizer");
		vs = new BasicVisualizationServer<>(new TreeLayout<>(dforest));
	    frame.getContentPane().add(vs);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);
	    this.showValues();
	    //this.showEdgeValues();
	}
	
	/**
	 * Step 4: show the values of vertices on graph.
	 */
	public void showValues()
	{
		
		vs.getRenderContext().setVertexLabelTransformer(new Transformer<Vertex, String>()
		{
			public String transform(Vertex v)
			{
				return Integer.toString(v.getValue());
			}
		});
				
	}
	
	public void showEdgeValues()
	{
		vs.getRenderContext().setEdgeLabelTransformer(new Transformer<Edge, String>()
		{
			public String transform(Edge e)
			{
				return e.getEdgeLabel();
			}
		});
	}
	
	public void show()
	{
		graphToDelegateForest();
		setupGUI();
	}
}
