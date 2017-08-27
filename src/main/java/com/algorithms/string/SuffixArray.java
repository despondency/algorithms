package com.algorithms.string;

public class SuffixArray {

	private String s;
	private final int alpha = 256;
	public SuffixArray (String s) {
		this.s = s;
	}

	private int[] cs(String s){
		int o[] = new int[s.length()];
		int c[] = new int[alpha];
		for (int i = 0 ; i < s.length();i++){
			c[s.charAt(i)] = c[s.charAt(i)] + 1;
		}
		for (int j = 1; j < alpha;j++){
			c[j] = c[j] + c[j-1];
		}
		for (int i = s.length()-1; i >= 0;i--){
			c[s.charAt(i)] = c[s.charAt(i)]-1;
			o[c[s.charAt(i)]] = i;
		}
		return o;
	}

	private int[] css2(String s, int l, int[] o, int c[]){
		int c1[] = new int[s.length()];
		int no[] = new int[s.length()];
		for (int i = 0 ;i < s.length();i++){
			c1[c[i]] = c1[c[i]] + 1;
		}
		for(int j = 1; j < s.length(); j++){
			c1[j] = c1[j] + c1[j-1];
		}
		for (int i = s.length()-1; i >=0;i--){
			int w = (o[i] - l + s.length()) % s.length();
			int q = c[w];
			c1[q] = c1[q] - 1;
			no[c1[q]] = w;
		}
		return no;
	}

	private int[] cc(String s, int[] o){
		int[] c = new int[s.length()];
		c[o[0]] = 0;
		for (int i = 1 ;i < s.length();i++){
			if(s.charAt(o[i]) != s.charAt(o[i-1])){
				c[o[i]] = c[o[i-1]] + 1;
			}else{
				c[o[i]] = c[o[i-1]];
			}
		}
		return c;
	}

	private int[] nc(int [] no, int[] c, int l){
			int n = no.length;
			int nc[] = new int[n];
			nc[no[0]] = 0;
			for (int i = 1 ;i < n;i++){
				int cur = no[i];
				int prev = no[i-1];
				int mid = cur + l;
				int midPrev = (prev + l) % n;
				if(c[cur] != c[prev] ||
					c[mid] != c[midPrev]) {
					nc[cur] = nc[prev] + 1;
				}else{
					nc[cur] = nc[prev];
				}
			}
			return nc;
	}

	// Kasai-Arimura-Park LCP O(N)
	public int[] lcp(int sa[]){
		int invsa[] = new int[s.length()];
		for(int i = 0 ;i < s.length();i++){
			invsa[sa[i]] = i;
		}
		int h = 0;
		int height[] = new int[s.length()];
		for(int i = 0 ; i < s.length();i++){
			if(invsa[i] > 1){
				int k = sa[invsa[i]-1];
				while(s.charAt(i+h) == s.charAt(k+h)){
					h++;
				}
				height[invsa[i]] = h;
				if(h > 0) h--;
			}
		}
		return height;
	}

	// nlogn
	public int[] buildSA(){
		int o[] = cs(s);
		int c[] = cc(s,o);
		int L = 1;
		while ( L < s.length()){
				o = css2(s,L,o,c);
				c = nc(o,c,L);
				L *= 2;
		}
		return o;
	}
}
