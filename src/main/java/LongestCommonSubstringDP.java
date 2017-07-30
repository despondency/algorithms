// complexity is
// O( len(a) * len(b))
public class LongestCommonSubstringDP {

	private int dp[][] = null;
	private String a;
	private String b;

	public LongestCommonSubstringDP(String a, String b) {
		int maxLen = Math.max(a.length(), b.length());
		this.dp = new int[maxLen + 1][maxLen + 1]; // start from 1-based idx
		if (b.length() > a.length()) {
			this.a = b;
			this.b = a;
		}
		else {
			this.a = a;
			this.b = b;
		}
	}

	public int lcs() {
		for (int i = 1; i <= a.length(); i++) {
			for (int j = 1; j <= b.length(); j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1]; // we have a match, add it to res
				}
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // get the max lcs and carry it further
				}
			}
		}
		return dp[a.length()][b.length()];
	}
}
