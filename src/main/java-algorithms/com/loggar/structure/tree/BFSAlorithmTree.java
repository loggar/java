package com.loggar.structure.tree;

import java.util.ArrayDeque;
import java.util.Optional;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BFSAlorithmTree {
	private static final Logger LOGGER = LoggerFactory.getLogger(BFSAlorithmTree.class);

	public static <T> Optional<TreeNode<T>> search(T value, TreeNode<T> root) {
		Queue<TreeNode<T>> queue = new ArrayDeque<>();
		queue.add(root);

		TreeNode<T> currentNode;
		while (!queue.isEmpty()) {
			currentNode = queue.remove();
			LOGGER.info("vist node v: {}", currentNode.getValue());

			if (currentNode.getValue().equals(value)) {
				return Optional.of(currentNode);
			} else {
				queue.addAll(currentNode.getChildren());
			}
		}

		return Optional.empty();
	}

}
