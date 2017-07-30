import java.util.*;

public class BFS {

	private Vector<Vector<Integer>> G;
	private int E;
	private boolean[] U;

	public BFS(int E) {
		this.E = E;
		this.G = new Vector<>();
		for (int i = 0; i < E; i++) {
			G.add(new Vector<>());
		}
		U = new boolean[E];
	}

	public void BFS(int vertex) {
		U[vertex] = true;
		//System.out.println(vertex);
		Queue<Integer> q = new LinkedList<>();
		q.add(vertex);
		while (!q.isEmpty()) {
			Integer curr = q.poll();
			for (Integer i : G.get(curr)) {
				if (!U[i]) {
					//currently explored vertex
					//System.out.println(i);
					q.add(i);
					U[i] = true;
				}
			}
		}
	}

	public void connect(int u, int v) {
		G.get(u).add(v);
		G.get(v).add(u);
	}
}
