import org.junit.Assert;
import org.junit.Test;

public class QuickFindTest {

	@Test
	public void testQuickFindTest() {
		QuickFind quickFind = new QuickFind(5);
		quickFind.union(3, 4);
		quickFind.union(1, 3);
		Assert.assertFalse(quickFind.isConnected(2, 4));
		quickFind.union(1, 4);
		Assert.assertTrue(quickFind.isConnected(1, 3));
		Assert.assertFalse(quickFind.isConnected(1, 2));
	}
}
