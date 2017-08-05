package com.algorithms.graph.mst.prim;

import java.util.*;

public class Prim {

	public class Edge {

		int u;
		int v;
		int dist;

		public Edge(int u, int v, int dist) {
			this.u = u;
			this.v = v;
			this.dist = dist;
		}
	}

	private boolean M[];
	private Vector<Vector<Edge>> G;
	private List<Edge> spanningTree;
	private int V;
	private PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.dist));

	public Prim(int V) {
		this.V = V;
		this.M = new boolean[V];
		this.G = new Vector<>();
		this.spanningTree = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			G.add(new Vector<>()); // u idx -> u -> children
		}
	}

	public List<Edge> getSpanningTree() {
		return spanningTree;
	}

	private void expand(int vertex) {
		M[vertex] = true;
		for (Edge e : G.get(vertex)) {
			if (!M[e.v]) {
				pq.add(e);
			}
		}
	}

	public void addEdge(int u, int v, int dist) {
		G.get(u).add(new Edge(u, v, dist));
		G.get(v).add(new Edge(v, u, dist));
	}

	public int MST() {
		int mst = 0;
		// we can remove that loop if we are sure that the graph is completely connected
		// if the graph is actually a forest, and we need to find
		// the MST of every subgraph which is a forest
		// we need to loop and try to start the expansion process from each of the vertices
		// otherwise we can remove the while and for loop and expand from 0-th vertex.
		while (spanningTree.size() < V - 1) {
			for (int i = 0; i < V; i++) {
				expand(i);
				while (!pq.isEmpty()) {
					Edge e = pq.poll();
					if (M[e.u] && M[e.v]) {
						continue;
					}
					mst += e.dist;
					spanningTree.add(e);
					if (!M[e.u]) {
						expand(e.u);
					}
					if (!M[e.v]) {
						expand(e.v);
					}
				}
			}
		}
		return mst;
	}
}

