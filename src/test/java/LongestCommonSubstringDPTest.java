import com.algorithms.string.LongestCommonSubstringDP;
import org.junit.Assert;
import org.junit.Test;

public class LongestCommonSubstringDPTest {

	@Test
	public void testLongestCommonSubstringDP() {
		LongestCommonSubstringDP a = new LongestCommonSubstringDP("ababababad", "ab");
		Assert.assertEquals(2, a.lcs());
		LongestCommonSubstringDP b = new LongestCommonSubstringDP("ababab", "ababab");
		Assert.assertEquals(6, b.lcs());
		LongestCommonSubstringDP c = new LongestCommonSubstringDP("rqwrq", "zzzz");
		Assert.assertEquals(0, c.lcs());
	}
}
