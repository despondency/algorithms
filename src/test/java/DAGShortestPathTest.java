import com.algorithms.graph.sssp.DAGShortestPath;
import org.junit.Assert;
import org.junit.Test;

public class DAGShortestPathTest {

	@Test
		public void testDAGShortestPath() {
		DAGShortestPath dagShortestPath = new DAGShortestPath(8);
		dagShortestPath.connect(0, 1, 5);
		dagShortestPath.connect(0, 7, 8);
		dagShortestPath.connect(0, 4, 9);
		dagShortestPath.connect(1, 7, 4);
		dagShortestPath.connect(1, 3, 15);
		dagShortestPath.connect(1, 2, 12);
		dagShortestPath.connect(4, 7, 5);
		dagShortestPath.connect(4, 5, 4);
		dagShortestPath.connect(4, 6, 20);
		dagShortestPath.connect(7, 5, 6);
		dagShortestPath.connect(7, 2, 7);
		dagShortestPath.connect(5, 6, 13);
		dagShortestPath.connect(5, 2, 1);
		dagShortestPath.connect(2, 3, 3);
		dagShortestPath.connect(2, 6, 11);
		dagShortestPath.connect(3, 6, 9);
		Assert.assertArrayEquals(new int[]{0, 5, 14, 17, 9, 13, 25, 8}, dagShortestPath.shortestPaths());
	}
}
