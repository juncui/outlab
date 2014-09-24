package outlab;


public class BinaryTreeVertex extends Vertex
{
	private BinaryTreeVertex leftChild;
	private BinaryTreeVertex rightChild;
	private BinaryTreeVertex parent;
	
	public BinaryTreeVertex(int value, BinaryTreeVertex leftChild, BinaryTreeVertex rightChild, BinaryTreeVertex parent)
	{
		super(value);
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.parent = parent;
	}
	
	public BinaryTreeVertex(int value)
	{
		this(value, null, null, null);
	}
	
	public BinaryTreeVertex getLeftChild()
	{
		return leftChild;
	}
	
	public BinaryTreeVertex getRightChild()
	{
		return rightChild;
	}
	
	public BinaryTreeVertex getParent()
	{
		return parent;
	}
	
	public void setLeftChild(BinaryTreeVertex leftChild)
	{
		this.leftChild = leftChild;
	}
	
	public void setRightChild(BinaryTreeVertex rightChild)
	{
		this.rightChild = rightChild;
	}
	
	public void setParent(BinaryTreeVertex parent)
	{
		this.parent = parent;
	}

}
