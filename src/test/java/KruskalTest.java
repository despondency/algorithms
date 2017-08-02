import com.algorithms.graph.mst.kruskal.Kruskal;
import org.junit.Assert;
import org.junit.Test;

public class KruskalTest {

	@Test
	public void testKruskalMST(){
		Kruskal kruskal = new Kruskal(8);
		kruskal.addEdge(0,2,2);
		kruskal.addEdge(0,7,1);
		kruskal.addEdge(0,4, 25);
		kruskal.addEdge(0,6,12);
		kruskal.addEdge(1,3, 13);
		kruskal.addEdge(1,2, 15);
		kruskal.addEdge(1,7,3);
		kruskal.addEdge(1,5, 23);
		kruskal.addEdge(2,6,2);
		kruskal.addEdge(2,3,4);
		kruskal.addEdge(2,7,24);
		kruskal.addEdge(3,6,17);
		kruskal.addEdge(4,5,3);
		kruskal.addEdge(4,7,12);
		kruskal.addEdge(4,6,32);
		kruskal.addEdge(5,7,11);
		Assert.assertEquals(26,kruskal.MST());
	}

}
