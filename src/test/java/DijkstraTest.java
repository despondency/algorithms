import com.algorithms.graph.sssp.Dijkstra;
import org.junit.Assert;
import org.junit.Test;

public class DijkstraTest {

	@Test
	public void testDijkstraSSSP() {
		Dijkstra dijkstra = new Dijkstra(8, 0, true);
		dijkstra.connect(0, 1, 5);
		dijkstra.connect(0, 7, 8);
		dijkstra.connect(0, 4, 9);
		dijkstra.connect(1, 7, 4);
		dijkstra.connect(1, 3, 15);
		dijkstra.connect(1, 2, 12);
		dijkstra.connect(4, 7, 5);
		dijkstra.connect(4, 5, 4);
		dijkstra.connect(4, 6, 20);
		dijkstra.connect(7, 5, 6);
		dijkstra.connect(7, 2, 7);
		dijkstra.connect(5, 6, 13);
		dijkstra.connect(5, 2, 1);
		dijkstra.connect(2, 3, 3);
		dijkstra.connect(2, 6, 11);
		dijkstra.connect(3, 6, 9);
		Assert.assertArrayEquals(new int[]{0, 5, 14, 17, 9, 13, 25, 8}, dijkstra.shortestPath());
	}
}
