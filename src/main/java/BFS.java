import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class BFS {

	private Vector<Vector<Integer>> G;
	private int V;
	private boolean[] U;
	private boolean isDirected;

	public BFS(int V, boolean isDirected) {
		this.V = V;
		this.G = new Vector<>();
		for (int i = 0; i < V; i++) {
			G.add(new Vector<>());
		}
		this.U = new boolean[V];
		this.isDirected = isDirected;
	}

	public void BFS(int vertex) {
		U[vertex] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(vertex);
		while (!q.isEmpty()) {
			Integer curr = q.poll();
			for (Integer i : G.get(curr)) {
				if (!U[i]) {
					q.add(i);
					U[i] = true;
				}
			}
		}
	}

	public void connect(int u, int v) {
		G.get(u).add(v);
		if(!isDirected) {
			G.get(v).add(u);
		}
	}
}
