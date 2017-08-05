import com.algorithms.graph.components.ConnectedComponents;
import org.junit.Assert;
import org.junit.Test;

public class ConnectedComponentsTest {

	@Test
	public void testConnectedComponents() {
		ConnectedComponents graph = new ConnectedComponents(10);
		graph.connect(0, 1);
		graph.connect(2, 3);
		graph.connect(3, 4);
		graph.connect(5, 6);
		graph.connect(6, 7);
		graph.connect(7, 8);
		graph.connectedComponents();
		Assert.assertTrue(graph.isConnected(7, 8)); // true
		Assert.assertFalse(graph.isConnected(9, 0)); // false
		Assert.assertTrue(graph.isConnected(2, 4)); // transitively connected 2 -> 3 -> 4
		Assert.assertArrayEquals(new int[]{1, 1, 4, 4, 4, 8, 8, 8, 8, 9}, graph.getComponents());
		Assert.assertArrayEquals(new int[]{2, 2, 3, 3, 3, 4, 4, 4, 4, 1}, graph.getSizeOfEachComponentForId());
	}
}
