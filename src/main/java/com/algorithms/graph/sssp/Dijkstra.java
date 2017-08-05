package com.algorithms.graph.sssp;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Vector;

public class Dijkstra {

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

	public class Pair {

		int dist;
		int to;

		public Pair(int dist, int to) {
			this.dist = dist;
			this.to = to;
		}
	}

	private Vector<Vector<Edge>> edges;
	private int[] dist;
	private static final int INF = 1000000000;
	private int S;
	private int V;

	public Dijkstra(int V, int S) {
		this.S = S;
		this.V = V;
		this.edges = new Vector<>();
		for (int i = 0; i < V; i++) {
			edges.add(new Vector<>());
		}
		this.dist = new int[V];
		for (int i = 0; i < V; i++) {
			dist[i] = INF;
		}
	}

	public void connect(int u, int v, int dist) {
		edges.get(u).add(new Edge(u, v, dist));
	}

	public int[] shortestPath() {
		PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.dist));
		pq.add(new Pair(0, S));
		dist[S] = 0;
		while (!pq.isEmpty()) {
			Pair edge = pq.poll();
			if (edge.dist > dist[edge.to]) {
				continue;
			}
			Vector<Edge> outgoingEdges = edges.get(edge.to);
			for (Edge outgoing : outgoingEdges) {
				if (dist[edge.to] + outgoing.dist < dist[outgoing.v]) {
					dist[outgoing.v] = dist[edge.to] + outgoing.dist;
					pq.offer(new Pair(dist[outgoing.v], outgoing.v));
				}
			}
		}
		return dist;
	}
}
