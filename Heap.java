package outlab;

import java.util.Arrays;
import java.util.ArrayList;

public class Heap extends BinaryTree{
	private int[] array;

	public Heap(int[] array) {
		this.array = array;
	}
	
	public void buildMaxHeap(){
		int lastIndex = array.length - 1;
		for (int i = getParentIndex(lastIndex); i >= 0; i--)
			maxHeapify(i, lastIndex);
	}
	
	private void maxHeapify(int rootIndex, int lastIndex){
		int l = getLeftChildIndex(rootIndex);
		int r = getRightChildIndex(rootIndex);
		int largest;
		if (l <= lastIndex && array[l] > array[rootIndex])
			largest = l;
		else largest = rootIndex;
		if (r <= lastIndex && array[r] > array[largest])
			largest = r;
		if (largest != rootIndex){
			exchange(rootIndex, largest);
			maxHeapify(largest, lastIndex);
		}
	}
		
	private void exchange(int index1, int index2){
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	public void sort(){
		for (int i = array.length - 1; i > 0; i--)
		{
			exchange(0, i);
			maxHeapify(0, i-1);
		}
		System.out.println("Sorted:\t\t" + Arrays.toString(array));
		arrayToTree();
	}
	
	private int getLeftChildIndex(int index){
		return 2 * index + 1;
	}
	
	private int getRightChildIndex(int index){
		return 2 * index + 2;
	}
	
	private int getParentIndex(int index){
		return (index - 1) / 2;
	}
	
	public int[] getArray(){
		return array;
	}
	
	//transform array to tree for visualization
	public void arrayToTree(){
		ArrayList<HeapVertex> vertices = new ArrayList<>();
		super.clearVertexList();
		for (int i = 0; i < array.length; i++)
		{
			vertices.add(new HeapVertex(array[i], i));
			super.addVertex(vertices.get(i));
		}
		for (int i = 0; i < array.length; i++)
		{
			if (getLeftChildIndex(i) < array.length)
				vertices.get(i).setLeftChild(vertices.get(getLeftChildIndex(i)));
			if (getRightChildIndex(i) < array.length)
				vertices.get(i).setRightChild(vertices.get(getRightChildIndex(i)));
			if (i > 0)
				vertices.get(i).setParent(vertices.get(getParentIndex(i)));
			else
			{
				vertices.get(i).setParent(null);
				super.setRoot(vertices.get(0));
			}
		}
		super.updateEdgeList();
		Visualizer visual = new Visualizer(this);
		visual.show();	
	}
}
