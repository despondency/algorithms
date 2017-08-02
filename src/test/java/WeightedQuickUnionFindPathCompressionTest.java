import com.algorithms.graph.dsu.WeightedQuickUnionFindPathCompression;
import org.junit.Assert;
import org.junit.Test;

public class WeightedQuickUnionFindPathCompressionTest {

	@Test
	public void testWeightedQuickUnionFindPathCompression() {
		WeightedQuickUnionFindPathCompression wquf = new WeightedQuickUnionFindPathCompression(5);
		wquf.union(3, 4);
		wquf.union(1, 3);
		Assert.assertFalse(wquf.isConnected(2, 4));
		wquf.union(1, 4);
		wquf.union(0, 4);
		Assert.assertTrue(wquf.isConnected(1, 3));
		Assert.assertFalse(wquf.isConnected(1, 2));
		Assert.assertFalse(wquf.isConnected(0, 2));
		Assert.assertEquals(3, wquf.root(4)); // since 3's tree is smaller
		// 2 components -> 0 - 1 - 3 - 4, 2
		Assert.assertEquals(2, wquf.getNumberOfComponents());
	}
}
