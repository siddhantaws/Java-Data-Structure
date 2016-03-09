package com.manh.tree;


import java.util.LinkedList;

public class BinarySearchTree<E extends Comparable> extends AbstractBinaryTree<Comparable> 
{
	/**
	 * 
	*/
	private static final long serialVersionUID = 1L;
	
	@Override
	public boolean add(Comparable e) 
	{
		return super.add(e);
	}

	@Override
	public void preOrderTraversal() 
	{
		super.preOrderTraversal();
	}
	
	@Override
	public void levelOrderInReverseOrder() 
	{
		super.levelOrderInReverseOrder();
	}
	
	@Override
	public void inOrderTraversal() 
	{
		super.inOrderTraversal();
	}

	@Override
	public void postOrderTraversal() 
	{
		super.postOrderTraversal();
	}

	@Override
	public E getMax() 
	{
		return (E)super.getMax();
	}
	
	@Override
	public int getSize() 
	{
		return super.getSize();
	}
	
	@Override
	public boolean search(Comparable e) 
	{
		return super.search(e);
	}

	@Override
	public int getHeight() 
	{
		return super.getHeight();
	}
	
	@Override
	public int numberOfFullNodes() 
	{
		return super.numberOfFullNodes();
	}
	
	@Override
	public int numberOfHalfNodes() 
	{
		return super.numberOfHalfNodes();
	}
	
	@Override
	public int getSumOfAllNodes() 
	{
		return super.getSumOfAllNodes();
	}
	
	@Override
	public Comparable getDeepestNode() 
	{
		return super.getDeepestNode();
	}
	
	@Override
	public int levelHasMaximumSum() 
	{
		return super.levelHasMaximumSum();
	}
	@Override
	public boolean sumExistInBinaryTree(int sum) 
	{
		return super.sumExistInBinaryTree(sum);
	}
	
	@Override
	public boolean checkEqualityOfTwoBinaryTree(Tree tree) 
	{
		return super.checkEqualityOfTwoBinaryTree(tree);
	}
	
	@Override
	public Comparable getLeastCommonAncestor(Comparable e1, Comparable e2) 
	{
		return super.getLeastCommonAncestor(e1, e2);
	}
	@Override
	public void constructBinaryTreeFromInOrderAndPreOrder(Comparable[] e1, Comparable[] e2) 
	{
		super.constructBinaryTreeFromInOrderAndPreOrder(e1, e2);
	}
	
	@Override
	public void constructBinaryTreeFromInOrderAndPostOrder(Comparable[] inOrderE1, Comparable[] postOrderE2) 
	{
		super.constructBinaryTreeFromInOrderAndPostOrder(inOrderE1, postOrderE2);
	}
	
	@Override
	public void reverseInOrderTraversal() 
	{
		super.reverseInOrderTraversal();
	}
	
	@Override
	public void printZigZagTraversal() 
	{
		super.printZigZagTraversal();
	}
	
	@Override
	public void constructBinaryTreeFromSortedArray(Comparable[] e) 
	{
		super.constructBinaryTreeFromSortedArray(e);
	}
	
	@Override
	public void constructBinaryTreeFromSortedLinkedList(LinkedList<Comparable<?>> list) 
	{
		super.constructBinaryTreeFromSortedLinkedList(list);
	}
}
