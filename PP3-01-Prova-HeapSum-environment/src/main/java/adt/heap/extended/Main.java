package adt.heap.extended;

public class Main {

	public static void main(String[] args) {
		HeapSumImpl heap = new HeapSumImpl();
		heap.add(1);
		heap.add(3);
		heap.add(5);
		heap.add(7);
		heap.add(9);
		heap.add(11);
		heap.add(13);
		heap.add(15);
		heap.add(17);
		System.out.println(heap.sumRangeBetween(3, 9));
		System.out.println(heap.sumRangeAtLevel(1));
		System.out.println(heap.sumRangeOrderStatistics(3, 8));
	}

}
