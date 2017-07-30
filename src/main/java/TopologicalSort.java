import java.util.Stack;
import java.util.Vector;

public class TopologicalSort {

	public Vector<Vector<Integer>> G;
	public int E;
	public boolean[] U;
	public Stack<Integer> topoSort;

	public TopologicalSort(int E) {
		this.E = E;
		this.G = new Vector<>();
		for (int i = 0; i < E; i++) {
			G.add(new Vector<>());
		}
		U = new boolean[E];
	}

	//this could be used if we need SSC/CC
	public void resetUsed() {
		U = new boolean[E + 1];
	}

	public void DFS(int vertex) {
		//currently explored vertex
		//System.out.println(vertex);
		U[vertex] = true;
		for (int i = 0; i < G.get(vertex).size(); i++) {
			if (!U[G.get(vertex).get(i)]) {
				DFS(G.get(vertex).get(i));
			}
		}

	}

	public void topologicalSort(int vertex){

	}


	public void connect(int u, int v) {
		G.get(u).add(v);
		G.get(v).add(u);
	}

	public void printGraph() {
		for (int i = 0; i < G.size(); i++) {
			System.out.println("Vertex " + i + " children are ");
			for (int j = 0; j < G.get(i).size(); j++) {
				System.out.print(G.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		TopologicalSort topoSort = new TopologicalSort(7);
		topoSort.connect(0, 3);
		topoSort.connect(3, 1);
		topoSort.connect(2, 4);
		topoSort.connect(4, 0);
		topoSort.connect(0, 2);
		topoSort.connect(1, 2);
		//topoSort.topologicalSort();
	}
}
