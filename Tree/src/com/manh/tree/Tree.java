package com.manh.tree;

import java.util.LinkedList;

public interface Tree<E extends  Comparable<?>> 
{

	public boolean add(E e);
	
	public boolean add(E parent, E child);
	
	public boolean isEmpty();
	
	public void preOrderTraversal();
	
	public void inOrderTraversal();
	
	public void postOrderTraversal();
	
	public void reverseInOrderTraversal();
	
	public void printZigZagTraversal();
	
	public E getMax();
	
	public int getSize();
	
	public boolean search(E e);
	
	public int getHeight();
	
	public void levelOrderInReverseOrder();
	
	public int numberOfFullNodes();
	
	public int numberOfHalfNodes();
	
	public E getDeepestNode();
	
	public int levelHasMaximumSum();
	
	public int getSumOfAllNodes();
	
	public boolean sumExistInBinaryTree(int sum);
	
	public void convertToMirrorImage();
	
	public boolean checkEqualityOfTwoBinaryTree(Tree<?> tree) ;
	
	public void printAncestorOfNodeInBinaryTree(E e);
	
	public E getLeastCommonAncestor(E e1 ,E e2);
	
	public void constructBinaryTreeFromInOrderAndPreOrder(E e1[] ,E e2[]);
	
	public void constructBinaryTreeFromInOrderAndPostOrder(E e1[] ,E e2[]);
	
	public void constructBinaryTreeFromSortedArray(E e[]);
	
	public void constructBinaryTreeFromSortedLinkedList(LinkedList<Comparable<?>> list);
}
