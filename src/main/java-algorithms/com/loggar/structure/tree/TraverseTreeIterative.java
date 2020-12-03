package com.loggar.structure.tree;

import java.util.List;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TraverseTreeIterative<T> {
	private static final Logger logger = LoggerFactory.getLogger(TraverseTreeIterative.class);

	public static <T> void traversePreOrder(TreeNode<T> node) {
		if (node == null)
			return;

		// We create an empty stack and we push root to it
		Stack<TreeNode<T>> nodeStack = new Stack<>();
		nodeStack.push(node);

		// We pop all items one by one.
		// For each item, we make the following steps : print data, push its right child, push its left child
		// We push right child in first for that left is processed first
		while (!nodeStack.empty()) {
			TreeNode<T> currentNode = nodeStack.pop();
			logger.debug("[visit node] {}", currentNode.getValue());
			List<TreeNode<T>> children = currentNode.getChildren();
			for (TreeNode<T> c : children) {
				nodeStack.push(c);
			}
		}
	}
}
