package com.algorithms.string;

// complexity is
// O( len(a) * len(b))
public class LevenshteinEditDistance {

	private String a;
	private String b;
	private int dp[][];

	public LevenshteinEditDistance(String a, String b) {
		if (b.length() > a.length()) {
			this.a = b;
			this.b = a;
		}
		else {
			this.a = a;
			this.b = b;
		}
		this.dp = new int[this.a.length() + 1][this.b.length() + 1];
	}

	public int editDistance() {
		if (a.length() == 0) {
			return b.length();
		}
		else if (b.length() == 0) {
			return a.length();
		}
		for (int i = 0; i <= a.length(); i++) {
			for (int j = 0; j <= b.length(); j++) {
				if (i == 0) {
					dp[i][j] = j; // base
				}
				else if (j == 0) {
					dp[i][j] = i; // base
				}
				else if (a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1]; // they are equal, get the last edit distance
				}
				else {                       //insert     //remove             //replace
					dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
				}
			}
		}
		return dp[a.length()][b.length()];
	}
}
