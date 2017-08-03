import com.algorithms.graph.mst.boruvka.Boruvka;
import org.junit.Assert;
import org.junit.Test;

public class BoruvkaTest {
		@Test
		public void testBoruvkaMST(){
			Boruvka boruvka = new Boruvka(8);
			boruvka.addEdge(0,2,2);
			boruvka.addEdge(0,7,1);
			boruvka.addEdge(0,4, 25);
			boruvka.addEdge(0,6,12);
			boruvka.addEdge(1,3, 13);
			boruvka.addEdge(1,2, 15);
			boruvka.addEdge(1,7,3);
			boruvka.addEdge(1,5, 23);
			boruvka.addEdge(2,6,2);
			boruvka.addEdge(2,3,4);
			boruvka.addEdge(2,7,24);
			boruvka.addEdge(3,6,17);
			boruvka.addEdge(4,5,3);
			boruvka.addEdge(4,7,12);
			boruvka.addEdge(4,6,32);
			boruvka.addEdge(5,7,11);
			Assert.assertEquals(26, boruvka.MST());
		}
}
