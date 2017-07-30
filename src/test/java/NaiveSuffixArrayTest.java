import org.junit.Assert;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

public class NaiveSuffixArrayTest {

	@Test
	public void testLRS() {
		String s = "ababawebabeqbeqbrwabrwabrababbaba";
		NaiveSuffixArray naiveSuffixArray = new NaiveSuffixArray(s);
		naiveSuffixArray.buildSA();
		String LRS = naiveSuffixArray.getLRS();
		Assert.assertTrue(proofOfCorrectness(s, LRS));
	}

	@Test
	public void testSA() {
		String s = "mississippi";
		NaiveSuffixArray naiveSuffixArray = new NaiveSuffixArray(s);
		naiveSuffixArray.buildSA();
		String[] actual = naiveSuffixArray.getSA();
		String[] expected = new String[]{"i", "ippi",
			"issippi", "ississippi", "mississippi",
			"pi", "ppi", "sippi", "sissippi", "ssippi", "ssissippi"};
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testLCP() {
		String s = "mississippi";
		NaiveSuffixArray naiveSuffixArray = new NaiveSuffixArray(s);
		naiveSuffixArray.buildSA();
		int[] actual = naiveSuffixArray.getLCP();
		int[] expected = new int[]{1, 1, 4, 0, 0, 1, 0, 2, 1, 3, 0};
		Assert.assertArrayEquals(expected, actual);
	}

	public boolean proofOfCorrectness(String str, String lrs) {
		String l = new String();
		Set<String> allStrs = new TreeSet<>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (allStrs.contains(str.substring(i, j))) {
					if (l.length() < Math.abs(i - j)) {
						l = str.substring(i, j);
					}
				}
				else {
					allStrs.add(str.substring(i, j));
				}
			}
		}
		return l.equals(lrs);
	}
}
