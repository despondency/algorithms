import com.algorithms.string.KnuthMorrisPratt;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class KnuthMorrisPrattTest {

	@Test
	public void testKMP(){
		String s = "abababcaab";
		KnuthMorrisPratt kmp = new KnuthMorrisPratt(s, "a");
		List<Integer> idx = kmp.match();
		Assert.assertArrayEquals(new Integer[]{0,2,4,7,8}, idx.toArray(new Integer[idx.size()]));
	}
}
