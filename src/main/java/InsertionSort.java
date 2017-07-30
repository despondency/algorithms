// O(N^2) complexity
public class InsertionSort {

	private int A[];

	public InsertionSort(int A[]) {
		this.A = A;
	}

	public void sort() {
		for (int i = 0; i < A.length; i++) {
			int j = i;
			while (j > 0) {
				if (A[j] < A[j - 1]) {
					swap(j, j - 1);
				}
				j--;
			}
		}
	}

	private void swap(int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public int[] getSortedArray() {
		return A;
	}
}
