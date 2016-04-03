package com.manh.tree;

import java.util.LinkedList;

public class Main 
{
	public static void main(String[] args) 
	{
		BinarySearchTree<Integer> tree=new BinarySearchTree<>();
		//prepareData(tree);
		//tree.printZigZagTraversal();
		
		Comparable arr[]={5,10,15};
		tree.constructBinaryTreeFromSortedArray(arr);
		//tree.constructBinaryTreeFromSortedLinkedList(list);
	}
	private static void prepareData(BinarySearchTree binarySearchTree)
	{
		binarySearchTree.add(45);binarySearchTree.add(25);
		binarySearchTree.add(75);binarySearchTree.add(15);
		binarySearchTree.add(35);binarySearchTree.add(75);
		binarySearchTree.add(60);binarySearchTree.add(80);
	}
}
