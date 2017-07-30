import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class BFS {

	private Vector<Vector<Integer>> G;
	private int E;
	private boolean[] U;
	private boolean isDirected;

	public BFS(int E, boolean isDirected) {
		this.E = E;
		this.G = new Vector<>();
		for (int i = 0; i < E; i++) {
			G.add(new Vector<>());
		}
		this.U = new boolean[E];
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
