package com.algorithms.sort;

import java.util.ArrayList;
import java.util.List;

public class CountingSort {

	private int A[];

	public CountingSort(int A[]) {
		this.A = A;
	}

	public Integer[] sort() {
		int max = 0;
		for (int i = 0; i < A.length; i++) {
			max = Math.max(A[i], max);
		}
		int buckets[] = new int[max + 1];
		List<Integer> sorted = new ArrayList<>();
		for (int i = 0; i < A.length; i++) {
			buckets[A[i]]++;
		}
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] != 0) {
				while (buckets[i] > 0) {
					sorted.add(i);
					buckets[i]--;
				}
			}
		}
		return sorted.toArray(new Integer[sorted.size()]);
	}
}
