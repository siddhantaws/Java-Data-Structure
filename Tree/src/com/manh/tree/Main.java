package com.manh.tree;

public class Main 
{
	public static void main(String[] args) 
	{
		BinarySearchTree<Integer> tree=new BinarySearchTree<>();
		prepareData(tree);
		//tree.printZigZagTraversal();
		Comparable<?> array[]= {15,25,35,45,60,75,80};
		tree.constructBinaryTreeFromSortedArray(array);
	}
	private static void prepareData(BinarySearchTree binarySearchTree)
	{
		binarySearchTree.add(45);binarySearchTree.add(25);
		binarySearchTree.add(75);binarySearchTree.add(15);
		binarySearchTree.add(35);binarySearchTree.add(75);
		binarySearchTree.add(60);binarySearchTree.add(80);
	}
}
