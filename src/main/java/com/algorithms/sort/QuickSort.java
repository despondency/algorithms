package com.algorithms.sort;// O(NlogN) complexity with no additional space

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuickSort {

	private Integer A[];
	private Random random = new Random();

	public QuickSort(Integer A[]) {
		List<Integer> arr = Arrays.asList(A);
		Collections.shuffle(arr);
		this.A = arr.toArray(new Integer[arr.size()]);
	}

	public void sort() {
		sort(0, A.length - 1);
	}

	private void swap(int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	private void sort(int lo, int hi) {
		if (hi - lo < 1) {
			return;
		}
		int pivot = A[lo + random.nextInt(hi - lo + 1)];
		int i = lo;
		int j = hi;
		while (i <= j) {
			while (A[i] < pivot) {
				i++;
			}
			while (A[j] > pivot) {
				j--;
			}
			if (i > j) {
				break;
			}
			swap(i, j);
			i++;
			j--;
		}
		sort(lo, j);
		sort(i, hi);
	}

	public Integer[] getSortedArray() {
		return A;
	}
}
