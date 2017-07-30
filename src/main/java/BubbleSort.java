// O(N^2) complexity
public class BubbleSort {

	private int A[];

	public BubbleSort(int A[]) {
		this.A = A;
	}

	public void sort() {
		for (int i = 0; i < A.length; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if (A[i] > A[j]) {
					swap(i, j);
				}
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
