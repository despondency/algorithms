import com.algorithms.graph.apsp.FloydWarshall;
import org.junit.Assert;
import org.junit.Test;

public class FloydWarshallTest {

	@Test
	public void testFloydWarshallASPS1() throws Exception{
		FloydWarshall floydWarshall = new FloydWarshall(4, true);
		floydWarshall.connect(0,1,-5);
		floydWarshall.connect(1,2,4);
		floydWarshall.connect(0,2,2);
		floydWarshall.connect(0,3,3);
		floydWarshall.connect(2,3,1);

		int dist[][] = floydWarshall.floydWarshallASPS();
		int expected[][] = new int[][]{
			{0, -5, -1, 0},
			{1000000000, 0, 4, 5},
			{1000000000, 1000000000, 0, 1},
			{1000000000,1000000000,1000000000,0}
		};

		// important remark here
		// since we are actually relaxing edges, we may sometimes get an edge length with less than INF that is still INF.
		// for instance we have inf edge 100000000 and after all relaxations we get 99999995 which is still INF and we must exclude it from comparison
		Assert.assertArrayEquals(expected[0], dist[0]);
		Assert.assertArrayEquals(subArray(expected[1],1,expected[1].length), subArray(dist[1],1,dist[1].length));
		Assert.assertArrayEquals(subArray(expected[2],2,expected[2].length), subArray(dist[2],2,dist[2].length));
		Assert.assertArrayEquals(subArray(expected[3],3,expected[2].length), subArray(dist[3],3,dist[3].length));
	}

	private int[] subArray(int[] sub, int from, int to){
		int[] arr = new int[to];
		for(int i = from ;i < to; i++){
			arr[i] = sub[i];
		}
		return arr;
	}

	@Test
	public void testFloydWarshallASPS2() throws Exception{
		FloydWarshall floydWarshall = new FloydWarshall(4, true);
		floydWarshall.connect(0,1,4);
		floydWarshall.connect(0,2,2);
		floydWarshall.connect(2,1,1);
		floydWarshall.connect(2,3,3);
		floydWarshall.connect(1,3,-2);

		int dist[][] = floydWarshall.floydWarshallASPS();
		int expected[][] = new int[][]{
			{0,3,2,1},
			{1000000000,0,1000000000,-2},
			{1000000000, 1, 0, -1},
			{1000000000,1000000000,1000000000,0}
		};
		Assert.assertArrayEquals(expected[0], dist[0]);
		Assert.assertEquals(expected[1][1], dist[1][1]);
		Assert.assertEquals(expected[1][3], dist[1][3]);
		Assert.assertEquals(expected[2][1], dist[2][1]);
		Assert.assertEquals(expected[2][2], dist[2][2]);
		Assert.assertEquals(expected[2][3], dist[2][3]);
		Assert.assertEquals(expected[3][3], dist[3][3]);
	}

	@Test
	public void testFloydWarshall(){
		FloydWarshall floydWarshall = new FloydWarshall(4, true);
		floydWarshall.connect(0,2,-2);
		floydWarshall.connect(1,2,3);
		floydWarshall.connect(1,0,4);
		floydWarshall.connect(2,3,2);
		floydWarshall.connect(3,1,-1);

		int dist[][] = floydWarshall.floydWarshallASPS();
		int expected[][] = new int[][]{
			{0,-1,-2,0},
			{4,0,2,4},
			{5,1,0,2},
			{3,-1,1,0}
		};
		Assert.assertArrayEquals(expected,dist);
	}

}
