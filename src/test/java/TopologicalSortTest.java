import com.algorithms.graph.topologicalsort.TopologicalSort;
import org.junit.Assert;
import org.junit.Test;

public class TopologicalSortTest {

	@Test
	public void testTopologicalSort() {
		TopologicalSort topologicalSort = new TopologicalSort(7);
		topologicalSort.connect(0,1);
		topologicalSort.connect(0,5);
		topologicalSort.connect(0,2);
		topologicalSort.connect(1,4);
		topologicalSort.connect(3,2);
		topologicalSort.connect(3,5);
		topologicalSort.connect(3,4);
		topologicalSort.connect(3,6);
		topologicalSort.connect(5,2);
		topologicalSort.connect(6,4);
		topologicalSort.connect(6,0);

		topologicalSort.topologicalSort();
		int actual[] = topologicalSort.getTopologicalSort();
		int expected[] = new int[]{3,6,0,5,2,1,4};
		Assert.assertArrayEquals(expected,actual);

		TopologicalSort topologicalSortSecond = new TopologicalSort(6);
		topologicalSortSecond.connect(5,2);
		topologicalSortSecond.connect(5,0);
		topologicalSortSecond.connect(4,0);
		topologicalSortSecond.connect(4,1);
		topologicalSortSecond.connect(2,3);
		topologicalSortSecond.connect(3,1);
		topologicalSortSecond.topologicalSort();
		int actualSecond[] = topologicalSortSecond.getTopologicalSort();
		int expectedSecond[] = new int[]{5,4,2,3,1,0};
		Assert.assertArrayEquals(actualSecond,expectedSecond);
	}
}
