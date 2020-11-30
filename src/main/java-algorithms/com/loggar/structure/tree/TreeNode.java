package com.loggar.structure.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
	private T value = null;
	private List<TreeNode<T>> children = new ArrayList<>();
	private TreeNode<T> parent = null;

	public TreeNode(T data) {
		this.value = data;
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
	
	public void initParent(TreeNode<T> parent) {
		parent.addChild(this);
	}

	public List<TreeNode<T>> getChildren() {
		return children;
	}

	public T getValue() {
		return value;
	}

	public void setData(T value) {
		this.value = value;
	}

	private void setParent(TreeNode<T> parent) {
		this.parent = parent;
	}

	public TreeNode<T> getParent() {
		return parent;
	}

}
