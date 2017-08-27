import com.algorithms.graph.flow.EdmondsKarp;
import org.junit.Test;

public class EdmondsKarpTest {

	@Test
	public void testEdmondsKarpMaxFlow()
	{
		EdmondsKarp edmondsKarp = new EdmondsKarp(3);
		edmondsKarp.connect(0,1,3);
		edmondsKarp.connect(0,2,2);
		edmondsKarp.connect(1,2,2);
		System.out.println(edmondsKarp.maxflow(0,2));
	}
}
