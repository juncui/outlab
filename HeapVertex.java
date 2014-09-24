package outlab;


public class HeapVertex extends BinaryTreeVertex
{
	private int index;
	
	public HeapVertex(int value, BinaryTreeVertex leftChild,
			BinaryTreeVertex rightChild, BinaryTreeVertex parent, int index) {
		super(value, leftChild, rightChild, parent);
		this.index = index;
	}

	public HeapVertex(int value, int index){
		super(value, null, null, null);
		this.index = index;
	}
	
	public HeapVertex(int value){
		super(value, null, null, null);
		this.index = -1;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	@Override
	public String toString(){
		return "Vertex " + this.index + " has a value of " + this.getValue();
	}
	
	public int compareTo(HeapVertex anotherVertex){
		int difference = this.getValue() - anotherVertex.getValue();
		return difference;		
	}

}
