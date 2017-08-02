package com.algorithms.sort;

// O(N^2) complexity O(N) exchanges
public class SelectionSort {

	private int[] A;

	public SelectionSort(int[] arr) {
		this.A = arr;
	}

	public void sort() {
		for (int i = 0; i < A.length; i++) {
			int idx = findSmallestInRange(i, A.length);
			swap(i, idx);
		}
	}

	private int findSmallestInRange(int from, int to) {
		int smallest = A[from];
		int idx = from;
		for (int i = from + 1; i < to; i++) {
			if (smallest > A[i]) {
				smallest = A[i];
				idx = i;
			}
		}
		return idx;
	}

	private void swap(int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

	public int[] getSortedArray() {
		return A;
	}
}
