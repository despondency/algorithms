package com.algorithms;

import java.util.Arrays;

// we don't need terminating sentinel '$' in this impl
// complexity is O(N^2logN)
public class NaiveSuffixArray {

	private String str;
	private String[] S;
	private int[] H;
	private String lrs;

	public NaiveSuffixArray(String str) {
		this.str = str;
		this.S = new String[str.length()];
		this.H = new int[S.length];
		this.lrs = new String();
	}

	public void buildSA() {
		for (int i = 0; i < str.length(); i++) {
			S[i] = str.substring(i);
		}
		Arrays.sort(S);
		for (int i = 1; i < S.length; i++) {
			int j = 0;
			for (; j < Math.min(S[i - 1].length(), S[i].length()); j++) {
				if (S[i - 1].charAt(j) != S[i].charAt(j)) {
					break;
				}
			}
			if (j > lrs.length()) {
				lrs = S[i - 1].substring(0, j);
			}
			H[i - 1] = j;
		}
	}

	public String[] getSA() {
		return S;
	}

	public int[] getLCP() {
		return H;
	}

	public String getLRS() {
		return lrs;
	}
}
