package com.algorithms.graph.mst.kruskal;

import java.util.*;

public class Kruskal {

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

	private Vector<Edge> G;
	private List<Edge> mstEdges;
	private int V;
	private int[] depth;
	private int[] UF;
	private int components;

	public Kruskal(int V) {
		this.V = V;
		this.G = new Vector<>();
		this.components = V;
		this.UF = new int[V];
		this.depth = new int[V];
		for (int i = 0; i < V; i++) {
			UF[i] = i; // map each to idx
			depth[i] = 1; // initial depth
		}
		this.mstEdges = new ArrayList<>();
	}

	public void addEdge(int u, int v, int dist) {
		G.add(new Edge(u, v, dist));
		//G.add(Edge.createEdge(v,u,dist)); // don't
	}

	private boolean isConnected(int p, int q) {
		return root(p) == root(q);
	}

	private int root(int i) {
		while (UF[i] != i) {
			UF[i] = UF[UF[i]];
			i = UF[i];
		}
		return i;
	}

	public List<Edge> mstEdges() {
		return mstEdges;
	}

	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		if (j == i) {
			return;
		}
		if (depth[i] < depth[j]) {
			UF[i] = j;
			depth[j] += depth[i];
		}
		else {
			UF[j] = i;
			depth[i] += depth[j];
		}
		components--;
	}

	public int MST() {
		int mst = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.dist));
		for (Edge e : G) {
			pq.offer(e);
		}
		while (!pq.isEmpty() && mstEdges.size() < V - 1) {
			Edge currentEdge = pq.poll();
			if (!isConnected(currentEdge.u, currentEdge.v)) {
				union(currentEdge.u, currentEdge.v);
				mstEdges.add(currentEdge);
				mst += currentEdge.dist;
			}
		}
		return mst;
	}
}
