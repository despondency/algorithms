package com.algorithms.graph.apsp;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Vector;

public class JohnsonsAlgorithm {

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

	private Vector<Vector<Edge>> G;
	private int V;
	private boolean isDirected;
	private static final int INF = 1000000000;

	public JohnsonsAlgorithm(int V, boolean isDirected) {
		this.isDirected = isDirected;
		this.V = V;
		this.G = new Vector<>();
		for (int i = 0; i < V; i++) {
			G.add(new Vector<>());
		}
		G.add(new Vector<>()); // because of additional edge
	}

	public void connect(int u, int v, int dist) {
		G.get(u).add(new Edge(u, v, dist));
		if (!isDirected) {
			G.get(v).add(new Edge(v, u, dist));
		}
	}

	public void johnsonsAlgorithm() throws Exception {
		transform();
		int bellmanFordDist[] = bellmanFord();
		reweight(bellmanFordDist);
		removeEdge();
		dijkstra(bellmanFordDist);
	}

	private void removeEdge() {
		G.remove(V);
	}

	private int[] bellmanFord() throws Exception {
		int h[] = new int[V + 1];
		for (int i = 0; i <= V - 1; i++) { // relax V-1 times
			for (Edge e : G.get(i)) {
				h[e.v] = Math.min(h[e.v], h[e.u] + e.dist);
			}
		}
		// check negative cycle
		for (int u = 0; u < V; u++) {
			for (Edge e : G.get(u)) {
				if (h[e.v] > h[e.u] + e.dist) {
					throw new Exception("Negative Cycle Detected.");
				}
			}
		}
		return h;
	}

	private void reweight(int bellmanDist[]) {
		for (int w = 0; w < V; w++) {
			for (Edge e : G.get(w)) {
				e.dist = e.dist + bellmanDist[e.u] - bellmanDist[e.v];
			}
		}
	}

	private void transform() {
		for (int i = 0; i < V; i++) {
			G.get(V).add(new Edge(V, i, 0));
		}
	}

	private void dijkstra(int bellmanWeights[]) {
		int dist[][] = new int[V][V];
		for (int i = 0; i < V; i++) {
			for (int q = 0; q < V; q++) {
				dist[i][q] = INF;
			}
			dist[i][i] = 0;
			PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt((e) -> e.dist));
			pq.add(new Pair(0, i));
			while (!pq.isEmpty()) {
				Pair vx = pq.poll();
				if (vx.dist > dist[i][vx.to]) {
					continue;
				}
				for (Edge outgoing : G.get(vx.to)) {
					if (dist[i][vx.to] + outgoing.dist < dist[i][outgoing.v]) {
						dist[i][outgoing.v] = dist[i][vx.to] + outgoing.dist;
						pq.offer(new Pair(dist[i][outgoing.v], outgoing.v));
					}
				}
			}
		}
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if (dist[i][j] != INF) {
					System.out.print((dist[i][j] + bellmanWeights[j] - bellmanWeights[i]) + " ");
				}
				else {
					System.out.print(INF + " ");
				}
			}
			System.out.println();
		}
	}
}
