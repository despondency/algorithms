import com.algorithms.graph.sssp.BellmanFord;
import org.junit.Test;

public class BellmanFordTest {

	@Test
	public void testBellmanFordNegativeEdges() throws Exception {
		BellmanFord bellmanFord = new BellmanFord(5, 0,true);
		bellmanFord.connect(0, 1, 1);
		bellmanFord.connect(0, 2, 10);
		bellmanFord.connect(1, 3, 2);
		bellmanFord.connect(2, 3, -10);
		bellmanFord.connect(3, 4, 3);
		int[] paths = bellmanFord.shortestPaths();
	}

	@Test(expected = Exception.class)
	public void testNegativeCycle() throws Exception {
		BellmanFord bellmanFord = new BellmanFord(5, 0, true);
		bellmanFord.connect(0, 1, 1000);
		bellmanFord.connect(1, 2, 15);
		bellmanFord.connect(2, 1, -42);
		int[] paths = bellmanFord.shortestPaths();
	}
}
