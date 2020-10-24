package lab;

import frame.SortArray;

/**
 * Abstract superclass for the Quicksort algorithm.
 * 
 * @author NAJI
 */
public abstract class QuickSort {

	// DO NOT modify this method
	public abstract void Quicksort(SortArray records, int left, int right);

	/**
	 * 
	 * @param A
	 *            - das SortArray in welchem getauscht werden soll
	 * @param x
	 *            - das erste Element welches getauscht werden soll
	 * @param y
	 *            - das zweite Element welches getauscht werden soll
	 */
	public static void swap(SortArray A, int x, int y) {
		if (x >= 0 && y >= 0 && x < A.getNumberOfItems() && y < A.getNumberOfItems()) {
			SortingItem temp = A.getElementAt(x);
			A.setElementAt(x, A.getElementAt(y));
			A.setElementAt(y, temp);
		}
	} // End of swap

	/**
	 * 
	 * @param a
	 *            - Element a vom Typ SortingItem
	 * @param b
	 *            - Element b vom Typ SortingItem
	 * @return Fur a < b --> 1, a > b --> -1
	 * 
	 *         Vergleicht zuerst anhand der BookSerialNumber, wenn diese Identisch
	 *         ist wird nach der ReaderID verglichen!
	 * 
	 */
	public int compare(SortingItem a, SortingItem b) {

		if (a.BookSerialNumber.compareToIgnoreCase(b.BookSerialNumber) == 0) {
			if (a.ReaderID.compareToIgnoreCase(b.ReaderID) < 0) {
				return -1;
			} else
				return 1;

		} else {
			if (a.BookSerialNumber.compareToIgnoreCase(b.BookSerialNumber) < 0) {
				return -1;
			}

			else
				return 1;

		}

	}// End Compare

	/**
	 * @param a
	 *            - Gibt das SortArray an welches betrachtet werden soll
	 * @param min
	 *            - Index des Elements welches an der kleinsten Stelle (left) steht
	 * @param max
	 *            - Index des groesten Elements
	 * @param med
	 *            - Index des Element welches in der Mitte steht, bei
	 * @return Gibt den Mittelwert zwischen den 3 Elementen in einem SortArray
	 *         wieder
	 */
	public int findMedian(SortArray a, int min, int max, int med) {

		SortingItem minEl = a.getElementAt(min);
		SortingItem maxEl = a.getElementAt(max);
		SortingItem midEl = a.getElementAt(med);

		if (compare(minEl, midEl) < 0 && compare(minEl, maxEl) < 0 && compare(maxEl, midEl) < 0)
			return max;

		else if (compare(minEl, maxEl) < 0 && compare(midEl, maxEl) < 0 && compare(minEl, midEl) < 0)
			return med;

		else
			// Fuer den Fall, das oberes nicht zutrifft (Falls beide Elemente Gleich sind!)
			// nimm einfach den mit dem kleineren Indiz, also min!
			return min;
	}// End findMedian

	/**
	 * 
	 * @param records
	 *            - Erhalt das SortArray ubergeben, welches Sortiert werden soll
	 * @param left
	 *            - Erhalt den linken Wert (minimum) des Arrays ubergeben
	 * @param right
	 *            - Erhalt den rechten Wert (maximum) des Arrays ubergeben
	 * @return gibt die Position (Index) vom Pivot zurUEck
	 */
	public int partition(SortArray records, int left, int right) {
		SortingItem pivot = records.getElementAt(left);
		int i = left;

		for (int j = left + 1; j < right + 1; j++) {

			if (compare(records.getElementAt(j), pivot) == -1) {
				i++;
				swap(records, i, j);

			}
		}

		swap(records, i, left);
		return i;
	}// End of partition

}// End Quicksort
