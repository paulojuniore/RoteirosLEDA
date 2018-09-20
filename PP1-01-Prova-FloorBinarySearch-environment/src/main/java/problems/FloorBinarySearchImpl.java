package problems;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		insertionSort(array, 0, array.length-1);
		Integer floor = floorBinarySearch(array, 0, array.length-1, x);
		return floor;
	}
	
	private Integer floorBinarySearch(Integer[] array, int ini, int fim, int x) {
		Integer retorno = 0;
		if(ini > fim)
			retorno = null;
		else {
			int meio = (ini + fim)/2;
			if(array[meio] == x)
				retorno = array[meio];
			else if(array[meio] < x)
				retorno = floorBinarySearch(array, meio+1, fim, x);
			else if(array[meio] > x)
				retorno = floorBinarySearch(array, ini, meio-1, x);
		}
		return retorno;
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
