package sorting.linearSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if (array.length == 0) {
			/** Encontra o maior elemento do array e aloca um array com este valor + 1. **/
			int max = Util.getMaximum(array, leftIndex, rightIndex);
			Integer[] b = new Integer[max + 1];
			Util.initializeVectorWithZero(b);
			
			/** Conta a ocorrência para cada elemento no array. **/
			for (int j = leftIndex; j <= rightIndex; j++) {
				b[array[j]]++;
			}

			/** Modifica a contagem de modo que as posições no final do array sejam obtidas.  **/
			for (int j = leftIndex + 1; j < max + 1; j++) {
				b[j] += b[j - 1];
			}
			
			/** Aloca um vetor temporário para guardar o array original **/
			Integer[] temp = new Integer[array.length];
			for (int i = array.length - 1; i >= 0; i--) {
				temp[b[array[i]] - 1] = array[i];
				b[array[i]]--;
			}

			/** Transfere o vetor temporário para o array original **/
			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = temp[i];
			}
		}

	}

}
