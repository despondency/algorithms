package com.algorithms.graph.dsu;// complexity is
// O(N) for initialization
// O(lgN) for union
// O(lgN) for connection query

// total worst case time is O(N + M lg* N)
// lg* is https://en.wikipedia.org/wiki/Iterated_logarithm

public class WeightedQuickUnionFindPathCompression {

	private int[] ids; // lookup
	private int[] depth; // for tracking depth of a subtree
	private int numberOfComponents;

	public WeightedQuickUnionFindPathCompression(int sz) {
		ids = new int[sz];
		depth = new int[sz];
		this.numberOfComponents = sz; // its equal to the sz at the start
		for (int i = 0; i < sz; i++) {
			ids[i] = i; // map each to idx
			depth[i] = 1; // initial depth
		}
	}

	public boolean isConnected(int p, int q) {
		return root(p) == root(q);
	}

	public int root(int i) {
		while (ids[i] != i) {
			ids[i] = ids[ids[i]]; // path compression link each path to the root almost flattening the tree
			i = ids[i]; // traverse further using root of ids[i]
		}
		return i; // return root
	}

	public int getNumberOfComponents() {
		return numberOfComponents;
	}

	public void union(int p, int q) {
		int pRoot = root(p);
		int qRoot = root(q);
		if (qRoot == pRoot) {
			return; // do nothing they are same root
		}
		if (depth[pRoot] < depth[qRoot]) { // if depth of qRoot is larger than pRoot
			ids[pRoot] = qRoot; // link the pRoot to the qRoot since its smaller subtree
			depth[qRoot] += depth[pRoot]; // update the depth of qRoot adding pRoot depth
		}
		else {
			ids[qRoot] = pRoot; // they are equal so just link pRoot to qRoot
			depth[pRoot] += depth[qRoot]; // add qRoot depth to pRoot
		}
		numberOfComponents--; // decrement components since we merged two
	}
}
