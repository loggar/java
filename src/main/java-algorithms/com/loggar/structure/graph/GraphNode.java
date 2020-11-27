package com.loggar.structure.graph;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GraphNode<T> {
	private T value;
	private Set<GraphNode<T>> neighbors;

	public GraphNode(T value) {
		this.value = value;
		this.neighbors = new HashSet<>();
	}

	public T getValue() {
		return value;
	}

	public Set<GraphNode<T>> getNeighbors() {
		return Collections.unmodifiableSet(neighbors);
	}

	public void connect(GraphNode<T> node) {
		if (this == node)
			throw new IllegalArgumentException("Can't connect node to itself");
		this.neighbors.add(node);
		node.neighbors.add(this);
	}
}
