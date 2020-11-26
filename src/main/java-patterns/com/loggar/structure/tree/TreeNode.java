package com.loggar.structure.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
	private T data = null;

	private List<TreeNode<T>> children;

	private TreeNode<T> parent = null;

	public TreeNode(T data) {
		this.data = data;
		children = new ArrayList<>();
	}

	public TreeNode<T> addChild(TreeNode<T> child) {
		child.setParent(this);
		this.children.add(child);
		return child;
	}

	public void addChildren(List<TreeNode<T>> children) {
		children.forEach(each -> each.setParent(this));
		this.children.addAll(children);
	}

	public List<TreeNode<T>> getChildren() {
		return children;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	private void setParent(TreeNode<T> parent) {
		this.parent = parent;
	}

	public TreeNode<T> getParent() {
		return parent;
	}
}
