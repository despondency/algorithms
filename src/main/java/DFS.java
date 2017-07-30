import java.util.Vector;

public class DFS {

	private Vector<Vector<Integer>> G;
	private int V;
	private boolean[] U;
	private boolean isDirected;
	public DFS(int V, boolean isDirected) {
		this.V = V;
		this.G = new Vector<>();
		for (int i = 0; i < V; i++) {
			G.add(new Vector<>());
		}
		this.U = new boolean[V];
		this.isDirected = isDirected;
	}

	public void DFS(int vertex) {
		U[vertex] = true;
		for (int i = 0; i < G.get(vertex).size(); i++) {
			if (!U[G.get(vertex).get(i)]) {
				DFS(G.get(vertex).get(i));
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
