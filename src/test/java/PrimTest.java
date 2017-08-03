import com.algorithms.graph.mst.prim.Prim;
import org.junit.Assert;
import org.junit.Test;

public class PrimTest {

	@Test
	public void testPrimMST() {
		Prim prim = new Prim(8);
		prim.addEdge(0, 2, 2);
		prim.addEdge(0, 7, 1);
		prim.addEdge(0, 4, 25);
		prim.addEdge(0, 6, 12);
		prim.addEdge(1, 3, 13);
		prim.addEdge(1, 2, 15);
		prim.addEdge(1, 7, 3);
		prim.addEdge(1, 5, 23);
		prim.addEdge(2, 6, 2);
		prim.addEdge(2, 3, 4);
		prim.addEdge(2, 7, 24);
		prim.addEdge(3, 6, 17);
		prim.addEdge(4, 5, 3);
		prim.addEdge(4, 7, 12);
		prim.addEdge(4, 6, 32);
		prim.addEdge(5, 7, 11);
		Assert.assertEquals(26, prim.MST());
	}
}
