package problems;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		insertionSort(array, 0, array.length-1);
		Integer floor = floorBinarySearch(array, 0, array.length-1, x);
		return floor;
	}
	
	private Integer floorBinarySearch(Integer[] array, int ini, int fim, int x) {
		if(ini > fim)
			return null;
		if(x >= array[fim])
			return array[fim];
		int meio = (ini+fim)/2;
		if(array[meio] == x)
			return array[meio];
		if(meio > 0 && array[meio-1] <= x && x < array[meio])
			return array[meio-1];
		if(x < array[meio])
			return floorBinarySearch(array, ini, meio-1, x);
		return floorBinarySearch(array, meio+1, fim, x);
	}
	
	private void insertionSort(Integer[] array, int leftIndex, int rightIndex) {
		Integer key;
		int j;
		for (int i = leftIndex + 1; i <= rightIndex ; i++) {
			key = array[i];
			j = i;
			while(j > leftIndex && array[j-1] > key) {
				array[j] = array[j-1];
				j--;
			}
			array[j] = key;
		}
	}
}
