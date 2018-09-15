package sorting.linearSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if (array.length == 0)
			return;

		/** Encontra o elemento máximo e mínimo no array **/
		int min = Util.getMinimum(array, leftIndex, rightIndex);
		int max = Util.getMaximum(array, leftIndex, rightIndex);
		int range = max - min + 1;
		Integer[] b = new Integer[range];
		Util.initializeVectorWithZero(b);

		/** Faz a contagem da frequência para cada elemento do array **/
		for (int i = leftIndex; i <= rightIndex; i++) {
			b[array[i] - min]++;
		}

		/**
		 * Modifica a contagem de modo que as posições no final do array sejam obtidas.
		 **/
		for (int i = leftIndex + 1; i < range; i++) {
			b[i] += b[i - 1];
		}

		/** modifica o array original **/
		int j = 0;
		for (int i = 0; i < range; i++) {
			while (j < b[i])
				array[j++] = i + min;
		}

	}

}
