import com.algorithms.string.SuffixArray;
import org.junit.Test;

import java.util.Arrays;

public class SuffixArrayTest {

	@Test
	public void testSuffixArray(){
		String s = "ababaa$";
		String [] strings = new String[s.length()];

		for (int i = 0 ; i < strings.length; i++){
			strings[i] = s.substring(i,strings.length);
		}
		Arrays.sort(strings);
		for (int i = 0 ;i < strings.length; i++){
			System.out.println(strings[i]);
		}
		System.out.println("=====================");


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
