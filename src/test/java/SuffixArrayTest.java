import com.algorithms.string.SuffixArray;
import org.junit.Test;

public class SuffixArrayTest {

	@Test
	public void testSuffixArray(){
		String s = "ababaa$";
		SuffixArray sa = new SuffixArray(s);
		int ar[] = sa.buildSA();
		for(int i = 0 ; i < ar.length;i++){
			System.out.println(ar[i] + " " + s.substring(ar[i]));
		}
		System.out.println("=====");
		int h[] = sa.lcp(ar);
		for(int i = 0 ; i < h.length;i++){
			System.out.println(s.substring(ar[i]) + " " + h[i]);
		}
	}
}
