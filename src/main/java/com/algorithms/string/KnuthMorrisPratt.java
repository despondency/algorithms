package com.algorithms.string;

import java.util.ArrayList;
import java.util.List;

public class KnuthMorrisPratt {

	private String text;
	private String pattern;
	private String actual;

	public KnuthMorrisPratt(String text, String pattern)
	{
		this.text = text;
		this.pattern = pattern;
		this.actual = pattern + "$" + text;
	}

	private int[] preprocess() {
		if (actual == null) {
			throw new IllegalStateException("String is null");
		}
		int b = 0;
		int p[] = new int[actual.length()];
		p[0] = 0;
		for (int i = 1; i < actual.length(); i++) {
			while (b > 0 && actual.charAt(i) != actual.charAt(b)) {
				b = p[b - 1];
			}
			if (actual.charAt(i) == actual.charAt(b)) {
				b++;
			}
			else {
				b = 0;
			}
			p[i] = b;
		}
		return p;
	}

	public List<Integer> match()
	{
		int pf[] = preprocess();
		int pL = pattern.length();
		List<Integer> matches = new ArrayList<>();
		for(int i = pattern.length();i < actual.length();i++){
			if(pf[i] == pattern.length()){
				matches.add(i - 2*pL);
			}
		}
		return matches;
	}



}
