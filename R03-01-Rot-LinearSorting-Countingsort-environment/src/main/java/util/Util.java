package util;

/**
 * Class containing useful methods for arrays manipulation.
 */
public class Util {

	/**
	 * Swaps the contents of two positions in an array.
	 *
	 * @param array
	 *            The array to be modified, not null
	 * @param i
	 *            One of the target positions
	 * @param j
	 *            The other target position
	 */
	public static void swap(Object[] array, int i, int j) {
		if (array == null)
			throw new IllegalArgumentException();

		Object temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/**
	 * It says if a specific number is prime or not.
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isPrime(long n) {
		boolean result = true;
		for (int i = 2; i < n; i++) {
			if (n % i == 0){
				result = false;
				break;
			}
		}
		return result;
	}
	
	/**
	 * Returns the largest element in a given array.
	 * 
	 * @param array
	 * @param leftIndex
	 * @param rightIndex
	 * @return
	 */
	public static int getMaximum(Integer[] array, int leftIndex, int rightIndex) {
		int max = array[leftIndex];
		for(int i = leftIndex + 1; i <= rightIndex; i++) {
			if(array[i] > max)
				max = array[i];
		}
		return max;
	}
	
	/**
	 * Returns the lowest element in a given array.
	 * 
	 * @param array
	 * @param leftIndex
	 * @param rightIndex
	 * @return
	 */
	public static int getMinimum(Integer[] array, int leftIndex, int rightIndex) {
		int min = array[leftIndex];
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if(array[i] < min)
				min = array[i];
		}
		return min;
	}
	
	/**
	 * Initialize a given vector with the value zero.
	 * 
	 * @param array
	 */
	public static void initializeVectorWithZero(Integer[] array) {
		for(int i = 0; i < array.length; i++) {
			array[i] = 0;
		}
	}
	
	
}