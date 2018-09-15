package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(array == null || leftIndex < 0 || leftIndex >= rightIndex || rightIndex >= array.length){
			return;
		}
		
		int i = leftIndex;
		int j = rightIndex;
		T pivot = array[i];
			
		while(i <= j){
			
			while(array[i].compareTo(pivot) < 0){
				i++;
			}
			
			while(array[j].compareTo(pivot) > 0){
				j--;
			}
			
			if(i <= j){
				Util.swap(array, i, j);
				i++;
				j--;
			}
			
		}
		
		if(i < rightIndex){
			sort(array, i, rightIndex);
		}
		
		if (leftIndex < j){
			sort(array, leftIndex, j);
		}
	}
}
