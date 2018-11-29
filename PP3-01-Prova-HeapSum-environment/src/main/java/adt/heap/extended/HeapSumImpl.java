package adt.heap.extended;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * A classe HeapSumImpl herda de PriorityQueue, que funciona como uma min heap.
 * 
 * @author adalbertocajueiro
 *
 */
public class HeapSumImpl extends PriorityQueue<Integer> implements HeapSum {

	@Override
	public Integer sumRangeOrderStatistics(Integer k1, Integer k2) {
		int sum = 0;
		int contador = 1;
		while(contador <= k2) {
			if(contador >= k1) {
				sum += this.poll();
			} else {
				this.poll();
			}
			contador++;
		}
		return sum;
	}

	@Override
	public Integer sumRangeBetween(Integer v1, Integer v2) {
		int sum = 0;
		boolean flag = true;
		if(!this.isEmpty()) {
			while(this.peek() != null && flag) {
				if(this.peek() >= v1 && this.peek() <= v2) {
					sum += this.poll();
				} else {
					if(this.peek() <= v2) {
						flag = true;
						this.poll();
					} else {
						flag = false;
					}
				}
			}
		}
		return sum;
	}

	@Override
	public Integer sumRangeAtLevel(int level) {
		int sum = 0;
		Integer[] array = new Integer[this.toArray().length];
		array = converte(array, this.toArray());
		
		int ini = (int) (Math.pow(2, level) - 1);
		int fim = (int) (Math.pow(2, level + 1) - 2);
		int flag = 0;
		if(ini < array.length) {
			if(fim > array.length) {
				flag = array.length - 1;
			} else {
				flag = fim;
			}
			for(int i = ini; i <= flag; i++) {
				if(array[i] != null) {
					sum += array[i];
				}
			}
		}
		return sum;
	}

	private Integer[] converte(Integer[] array, Object[] array2) {
		for(int i = 0; i < array2.length;i++) {
			array[i] = (Integer) array2[i];
		}
		return array;
	}

}
