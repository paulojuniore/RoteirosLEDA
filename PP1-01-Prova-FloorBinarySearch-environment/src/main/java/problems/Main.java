package problems;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Integer[] array2 = {3, 1, 7, 0, 5, 8, 9};
		System.out.println(Arrays.toString(array2));
		FloorBinarySearchImpl f = new FloorBinarySearchImpl();
		Integer index = f.floor(array2, 6);
		System.out.println(Arrays.toString(array2));
		System.out.println(index);
	}

}
