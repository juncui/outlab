package outlab;


public class BinaryTree extends Graph
{
	private BinaryTreeVertex root;
	
	public BinaryTree()
	{
		root = null;
	}
	
	public BinaryTree(int newValue)
	{
		root = new BinaryTreeVertex(newValue);
		root.setParent(null);
		root.setLeftChild(null);
		root.setRightChild(null);
	}
	
	public void setRoot(BinaryTreeVertex vertex)
	{
		root = vertex;
		root.setParent(null);
	}
	
	public BinaryTreeVertex getRoot()
	{
		return root;
	}
	
	public BinaryTreeVertex iterativeSearch(int searchValue)
	{
		BinaryTreeVertex x = root;
		BinaryTreeVertex z = new BinaryTreeVertex(searchValue);
		int k = z.getValue();
		while ( x != null && x.getValue() != k)
			if (k < x.getValue())
				x = x.getLeftChild();
			else
				x = x.getRightChild();
		return x;
	}
	
	public BinaryTreeVertex recursiveSearch(int searchValue)
	{	
		return this.doRecursiveSearch(root, searchValue);
	}
		
	private BinaryTreeVertex doRecursiveSearch(BinaryTreeVertex x, int k)
	{
		if (x == null || x.getValue() == k)
			return x;
		if (k < x.getValue())
			return doRecursiveSearch(x.getLeftChild(), k);
		else
			return doRecursiveSearch(x.getRightChild(), k);
	}
		
	
	public boolean insert(int newValue)
	{	
		//check if value already exists in tree;
		if (this.iterativeSearch(newValue) != null)
			return false;

		BinaryTreeVertex x = root;
		BinaryTreeVertex y = null;
		BinaryTreeVertex z = new BinaryTreeVertex(newValue);


		while (x != null)
		{
			y = x;
			if (z.getValue() < x.getValue())
				x = x.getLeftChild();
			else
				x = x.getRightChild();			
		}

		z.setParent(y);

		if (y == null)
			root = z;
		else if (z.getValue() < y.getValue())
		{
			y.setLeftChild(z);
		}
		else
		{
			y.setRightChild(z);
		}

		//update vertexList
		super.addVertex(z);
		return true;
			
	}
	  
	private void transplant(BinaryTreeVertex u, BinaryTreeVertex v)
	{	
		BinaryTreeVertex uParent = u.getParent();
		if (uParent == null)
			this.setRoot(v);
		else if (u.equals(uParent.getLeftChild()))
				uParent.setLeftChild(v);
		else
				uParent.setRightChild(v);
		if (v != null)
			v.setParent(uParent);
		
		//Caller's responsibility to preserve tree property and update vertexList.

	}
	
	public boolean delete(int deleteValue)
	{	
		//check if value exists in tree.
		BinaryTreeVertex z = this.iterativeSearch(deleteValue);
		if (z == null)
			return false;
		
		if (z.getLeftChild() == null)
			this.transplant(z, z.getRightChild());
		else if (z.getRightChild() == null)
			this.transplant(z, z.getLeftChild());
		else
		{
			BinaryTreeVertex y = this.minimum(z.getRightChild());
			if ( !y.getParent().equals(z) )
			{
				this.transplant(y, y.getRightChild());
				y.setRightChild(z.getRightChild());
				y.getRightChild().setParent(y);
			}
			this.transplant(z, y);
			y.setLeftChild(z.getLeftChild());
			y.getLeftChild().setParent(y);	
		}
		
		//update vertexList
		super.removeVertex(z);
		return true;
	}
	
	public BinaryTreeVertex minimum(BinaryTreeVertex x)
	{
		while (x.getLeftChild() != null)
			x = x.getLeftChild();
		return x;
	}
	
	public void updateEdgeList()
	{
		this.clearEdgeList();
		if (root != null)
			traverse(root);
	}
	
	private void traverse(BinaryTreeVertex x)
	{
		if (x.getLeftChild() != null)
		{
			Edge edgeToAdd = new Edge(x, x.getLeftChild());
			edgeToAdd.setEdgeLabel("left");
			super.addEdge(edgeToAdd);
			traverse(x.getLeftChild());
		}
			
		if (x.getRightChild() != null)
		{
			Edge edgeToAdd = new Edge(x, x.getRightChild());
			edgeToAdd.setEdgeLabel("right");
			super.addEdge(edgeToAdd);
			traverse(x.getRightChild());
		}
	}
	
}
