package com.loggar.structure.graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BFSAlorithmGraph {
	private static final Logger LOGGER = LoggerFactory.getLogger(BFSAlorithmGraph.class);

	public static <T> Optional<GraphNode<T>> search(T value, GraphNode<T> start) {
		Queue<GraphNode<T>> queue = new ArrayDeque<>();
		queue.add(start);

		GraphNode<T> currentNode;
		Set<GraphNode<T>> alreadyVisited = new HashSet<>();

		while (!queue.isEmpty()) {
			currentNode = queue.remove();
			LOGGER.info("visit node v: {}", currentNode.getValue());

			if (currentNode.getValue().equals(value)) {
				return Optional.of(currentNode);
			} else {
				alreadyVisited.add(currentNode);
				queue.addAll(currentNode.getNeighbors());
				queue.removeAll(alreadyVisited);
			}
		}

		return Optional.empty();
	}
}
