package adt.heap.extended;

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
		int cont = 1, soma = 0;
		while(cont <= k2) {
			if(cont >= k1) {
				soma += this.peek();
			}
			this.poll();
			cont++;
		}
		return (Integer) soma;
	}

	@Override
	public Integer sumRangeBetween(Integer v1, Integer v2) {
		int soma = 0;
		while(this.peek() <= v2) {
			if(this.peek() >= v1) {
				soma += this.poll();
			} else {
				this.poll();
			}
		}
		return (Integer) soma;
	}

	@Override
	public Integer sumRangeAtLevel(int level) {
		int ini = (int) ((Math.pow(2, level)) - 1);
		int fim = (int) (Math.pow(2, level + 1) - 2);
		int cont = 0, soma = 0;
		while(!this.isEmpty()) {
			if(cont >= ini && cont <= fim) {
				soma += this.poll();
			} else {
				this.poll();
			}
			cont++;
		}
		return (Integer) soma;
	}

}
