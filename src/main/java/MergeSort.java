// O(NlogN) complexity + O(N) space
public class MergeSort {

	private int A[];
	private int T[];

	public MergeSort(int[] A) {
		this.A = A;
		this.T = new int[A.length];
	}

	public void sort() {
		sort(A, 0, A.length - 1);
	}

	private void sort(int A[], int L, int H) {
		if (L >= H) {
			return;
		}
		int M = L + (H - L) / 2;
		sort(A, 0, M);
		sort(A, M + 1, H);
		merge(A, L, M, H);
	}

	private void merge(int A[], int L, int M, int H) {
		System.arraycopy(A, L, T, L, H - L + 1);
		int i = L;
		int j = M + 1;
		for (int k = L; k <= H; k++) {
			if (i > M) {
				A[k] = T[j++];
			}
			else if (j > H) {
				A[k] = T[i++];
			}
			else if (T[j] < T[i]) {
				A[k] = T[j++];
			}
			else {
				A[k] = T[i++];
			}
		}
	}

	public int[] getSortedArray() {
		return A;
	}
}
