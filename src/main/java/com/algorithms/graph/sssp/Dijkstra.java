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
		pq.offer(new Pair(0, S));
		dist[S] = 0;
		while (!pq.isEmpty()) {
			Pair vertex = pq.poll();

			// important remark here is as follows :
			// since we do not actually delete the edges with longer distance from the PQ that start from the same vertex
			// we must be sure that the current edge we are processing has the minimum distance
			// this method is called lazy deletion
			if (vertex.dist > dist[vertex.to]) {
				continue;
			}

			Vector<Edge> outgoingEdges = edges.get(vertex.to);
			for (Edge outgoing : outgoingEdges) {
				if (dist[vertex.to] + outgoing.dist < dist[outgoing.v]) {
					dist[outgoing.v] = dist[vertex.to] + outgoing.dist;
					pq.offer(new Pair(dist[outgoing.v], outgoing.v));
				}
			}
		}
		return dist;
	}
}
