package sorting.divideAndConquer;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {	
		if(leftIndex >= rightIndex){
			return;
		} 
		else {
			int central = (leftIndex + rightIndex) /2;
			sort(array,leftIndex,central);
			sort(array,central+1,rightIndex);
			merge(array, leftIndex, rightIndex, central);
		}
	}
	
	public void merge(T[] array,int leftIndex,int rigthIndex,int central){
		T[] arrayLeft = Arrays.copyOfRange(array, leftIndex, central + 1);
		T[] arrayRight = Arrays.copyOfRange(array,  central + 1, rigthIndex + 1);

		int i = 0;
		int j = 0;
		
		while(i < arrayLeft.length && j < arrayRight.length){
			if(arrayLeft[i].compareTo(arrayRight[j]) <=0){
				array[leftIndex++] = arrayLeft[i++];
			}
			else{
				array[leftIndex++] = arrayRight[j++];
			}	
		}
		
		while(i < arrayLeft.length){
			array[leftIndex++] = arrayLeft[i++];
		}
		
		while(j < arrayRight.length){
			array[leftIndex++] = arrayRight[j++];
		}
	}
	
}
