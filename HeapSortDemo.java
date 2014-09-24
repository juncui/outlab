package outlab;

import java.util.Arrays;

public class HeapSortDemo {
	public static void main(String[] args){
		
		
		int[] array = {3, 9, 10, 1, 7, 2, 15, 5, 8, 14};
		
		
		Heap h = new Heap(array);
		System.out.println("Original:\t" + Arrays.toString(h.getArray()));
		h.arrayToTree();
				
		h.buildMaxHeap();
		System.out.println("MaxHeapified:\t" + Arrays.toString(h.getArray()));
		h.arrayToTree();

		h.sort();	
		
	}

}
