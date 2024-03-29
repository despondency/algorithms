package com.algorithms.graph.topologicalsort;

import java.util.Stack;
import java.util.Vector;

public class TopologicalSort {

	public Vector<Vector<Integer>> G;
	public int V;
	public boolean[] U;
	public Stack<Integer> topoSort;

	public TopologicalSort(int V) {
		this.V = V;
		this.G = new Vector<>();
		for (int i = 0; i < V; i++) {
			G.add(new Vector<>());
		}
		this.U = new boolean[V];
		this.topoSort = new Stack<>();
	}

	private void DFS(int vertex) {
		U[vertex] = true;
		for (int i = 0; i < G.get(vertex).size(); i++) {
			if (!U[G.get(vertex).get(i)]) {
				DFS(G.get(vertex).get(i));
			}
		}
		topoSort.push(vertex);
	}

	public void topologicalSort() {
		for (int i = 0; i < G.size(); i++) {
			if (!U[i]) {
				DFS(i);
			}
		}
	}

	public int[] getTopologicalSort() {
		int sort[] = new int[topoSort.size()];
		int i = 0;
		while (!topoSort.isEmpty()) {
			sort[i] = topoSort.peek();
			topoSort.pop();
			i++;
		}
		return sort;
	}

	public void connect(int u, int v) {
		G.get(u).add(v);
	}
}
