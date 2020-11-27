package com.loggar.structure.tree;

import java.util.List;

public class TraverseTreeRecursion<T> {
	public static <T> void traversePreOrder(TreeNode<T> node) {
		if (node == null)
			return;

		System.out.println("[visit node] " + node.getValue());

		List<TreeNode<T>> children = node.getChildren();
		for (TreeNode<T> c : children) {
			traversePreOrder(c);
		}
	}
}
