package outlab;

import java.util.ArrayList;


public class Tester3 
{
	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree();
		System.out.println("null root-" + tree.getRoot());
		int[] values = {23,42,6,32,33,66,9,2,14,3,56};
		
		
		//test insert function
		for (int v : values)
			tree.insert(v);
		
		BinaryTreeVertex root = tree.getRoot();
		System.out.println("root-"+ root.getValue());
		System.out.println(root.getLeftChild());
		System.out.println(root.getRightChild());
		System.out.println(root.getParent());
		
		
		
		
		tree.insert(7);
		
		tree.updateEdgeList();
		
		
		System.out.println("edges-"+ tree.getEdgeList().size());
		System.out.println("edge label-" + tree.getEdgeList().get(3).getEdgeLabel());
		
		
		//test search function
		BinaryTreeVertex v = tree.iterativeSearch(values[4]);
		BinaryTreeVertex u = tree.recursiveSearch(values[4]);
		if (v.equals(u))
		{
			System.out.println("both searches are correct");
			System.out.println(v.getValue() + " = " + u.getValue() + " = " + values[4]);
		}
		
		else
			System.out.println("search is wrong");
		
		//test search with non-exist vertex
		if (tree.iterativeSearch(1000) != null)
			System.out.println("search no is wrong");
		else
			System.out.println("search no is correct");
			
		
		//test delete
		System.out.println(tree.delete(23));
		System.out.println("deleted vertex is added back.");
		tree.insert(23);
		
		//test delete non-exist
		if (tree.delete(1000))
			System.out.println("delete no is wrong");
		else
			System.out.println("non-exist vertex cannot be deleted");
		
		tree.updateEdgeList();
		Visualizer visual = new Visualizer(tree);
		visual.show();
		
		System.out.println("VertexList Size-"+ tree.getVertexList().size());
		System.out.println("EdgeList Size-"+ tree.getEdgeList().size());
		

		
		
	}		
			
}

