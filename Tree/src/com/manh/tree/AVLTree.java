package com.manh.tree;

public class AVLTree<E extends Comparable> extends BinarySearchTree<Comparable>

{
	private Node leftRotate(Node root) {
		Node newRoot = root.getRight();
		root.setRight(root.getRight().getLeft());
		newRoot.setLeft(root);
		root.setHeight(setHeight(root));
		root.setSize(setSize(root));
		newRoot.setHeight(setHeight(newRoot));
		newRoot.setSize(setSize(newRoot));
		return newRoot;
	}

	private Node rightRotate(Node root) {
		Node newRoot = root.getLeft();
		root.setLeft(root.getLeft().getRight());
		newRoot.setRight(root);
		root.setHeight(setHeight(root));
		root.setSize(setSize(root));
		newRoot.setHeight(setHeight(newRoot));
		newRoot.setSize(setSize(newRoot));
		return newRoot;
	}

	private int setHeight(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max((root.getLeft() != null ? root.getLeft().getHeight() : 0),
				(root.getRight() != null ? root.getRight().getHeight() : 0));
	}

	private int height(Node root) {
		if (root == null) {
			return 0;
		} else {
			return root.getHeight();
		}
	}

	private int setSize(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max((root.getLeft() != null ? root.getLeft().getSize() : 0),
				(root.getRight() != null ? root.getRight().getSize() : 0));
	}

	@Override
	public boolean add(Comparable e) {
		boolean added = super.add(e);
		if(getRoot().getLeft()!=null || getRoot().getRight()!=null )
			fixedAfterInsertion();
		return added;
	}

	private void fixedAfterInsertion() {
		// TODO Auto-generated method stub
		Node root = getRoot();
		int balance = balance(root.getLeft(), root.getRight());

		if (balance > 1) {
			if (height(root.getLeft().getLeft()) >= height(root.getLeft().getRight())) {
				root = rightRotate(root);
			} else {
				root.setLeft(leftRotate(root.getLeft()));
				root = rightRotate(root);
			}
		} else if (balance < -1) {
			if (height(root.getRight().getRight()) >= height(root.getRight().getLeft())) {
				root = leftRotate(root);
			} else {
				root.setRight(rightRotate(root.getRight()));
				root = leftRotate(root);
			}
		} else {
			root.setHeight(setHeight(root));
			root.setSize(setSize(root));
		}
	}

	private int balance(Node rootLeft, Node rootRight) {
		return getHeight(rootLeft) - getHeight(rootRight);
	}
	
	public static void main(String[] args) 
	{
		Tree<Comparable> t=new AVLTree<String>();
		t.add("A");t.add("B");t.add("C");t.add("D");t.add("E");t.add("F");t.add("G");
	}
}
