package lab;

import frame.SortArray;

public class QuickSortA extends QuickSort {

	/**
	 * Quicksort algorithm implementation to sort a SorrtArray by choosing the pivot
	 * as the first (leftmost) element in the list
	 *
	 * @param records
	 *            - list of elements to be sorted as a SortArray
	 * @param left
	 *            - the index of the left bound for the algorithm
	 * @param right
	 *            - the index of the right bound for the algorithm
	 * @return Returns the sorted list as SortArray
	 */
	@Override
	public void Quicksort(SortArray records, int left, int right) {
		if (left < right) {
			int PivotIndex = partition(records, left, right);
			Quicksort(records, left, PivotIndex - 1);
			Quicksort(records, PivotIndex + 1, right);
		}

	}// End of Quicksort
}
