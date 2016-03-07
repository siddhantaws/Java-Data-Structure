package com.manh.tree;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class AbstractBinaryTree<E extends Comparable> implements Tree<E>, Serializable {
	/**
	 * 
	*/
	private static final long serialVersionUID = 1L;

	private Node root;

	public Node getRoot() {
		return root;
	}

	private E max;

	private static class Node<E extends Comparable> {
		private static Node NULL = new Node<Comparable>();

		private E data;

		private Node left;

		private Node right;

		public E getData() {
			return data;
		}

		public void setData(E data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node(E e) {
			this.data = e;
		}

		private Node() {
			this.data = null;
		}

	}

	@Override
	public boolean add(E e) {
		if (root == null) {
			root = new Node(e);
			return true;
		}
		return add(e, root);
	}

	private boolean add(E e, Node root) {
		Node parent = root;
		Node temp = parent;
		int comp;
		do {
			parent = temp;
			comp = e.compareTo(temp.getData());
			if (comp > 0)
				temp = temp.getRight();
			else if (comp < 0)
				temp = temp.getLeft();
			else {
				temp.setData(e);
				return true;
			}

		} while (temp != null);
		if (comp > 0)
			parent.setRight(new Node<Comparable>(e));
		else
			parent.setLeft(new Node<Comparable>(e));
		return true;
	}

	@Override
	public void preOrderTraversal() {
		preOrderTraversalIterative(root);
	}

	private void preOrderTraversalIterative(Node node) {
		Stack<Node<?>> stack = new Stack<>();
		stack.push(node);
		while (!stack.isEmpty()) {
			while (node != null) {
				System.out.println(node.getData());
				if (node.getLeft() != null) {
					node = node.getLeft();
					stack.push(node);
				} else {
					node = null;
				}
			}

			Node n = stack.pop();
			if (n.getRight() != null) {
				stack.push(n.getRight());
				node = n.getRight();
			}

		}
	}

	private void preOrderTraversalRecursive(Node root) {
		if (root != null) {
			System.out.println(root.getData());
			preOrderTraversalRecursive(root.getLeft());
			preOrderTraversalRecursive(root.getRight());
		}
	}

	@Override
	public void inOrderTraversal() {
		inOrderTraversaIterative(root);
	}

	private void inOrderTraversaIterative(Node node) {
		Stack<Node> stack = new Stack<>();
		stack.push(node);
		while (!stack.isEmpty()) {
			while (node != null) {
				if (node.getLeft() != null) {
					node = node.getLeft();
					stack.push(node);
				} else {
					node = null;
				}
			}
			Node n = stack.pop();
			System.out.println(n.getData());
			if (n.getRight() != null)
				stack.push(n.getRight());
		}
	}

	private void inOrderTraversalRecursive(Node node) {
		if (node != null) {
			inOrderTraversalRecursive(node.getLeft());
			System.out.println(node.getData());
			inOrderTraversalRecursive(node.getRight());
		}
	}

	@Override
	public void postOrderTraversal() {
		postOrderTraversalIterative(root);
	}

	private void postOrderTraversalRecursive(Node node) {
		if (node != null) {
			postOrderTraversalRecursive(node.getLeft());
			postOrderTraversalRecursive(node.getRight());
			System.out.println(node.getData());
		}
	}

	private void postOrderTraversalIterative(Node node) {
		Stack<Node> stack2 = new Stack<>();
		stack2.push(node);
		Stack<Node> stack1 = new Stack<>();
		while (!stack2.isEmpty()) {
			Node node2 = stack2.pop();
			stack1.push(node2);
			if (node2.getLeft() != null)
				stack2.push(node2.getLeft());
			if (node2.getRight() != null)
				stack2.push(node2.getRight());
		}
		while (!stack1.isEmpty()) {
			System.out.println(stack1.pop().getData());
		}
	}
	
	
	@Override
	public void reverseInOrderTraversal() 
	{
		reverseInOrderTraversalRecursive(root);
	}

	private void reverseInOrderTraversalRecursive(Node node)
	{
		if(node!=null)
		{
			reverseInOrderTraversalRecursive(node.getRight());
			System.out.println(node.getData());
			reverseInOrderTraversalRecursive(node.getLeft());
			
		}
	}

	@Override
	public E getMax() {
		max = (E) root.getData();
		return getMaxRecursive(root);
	}

	private E getMaxRecursive(Node node) {
		E left = null, right = null;
		if (node.getLeft() != null)
			left = (E) node.getLeft().getData();
		if (node.getRight() != null)
			left = (E) node.getRight().getData();
		if ((left != null && ((E) node.getData()).compareTo(left) > 0)
				|| (right != null && ((E) node.getData()).compareTo(right) > 0)) {
			if (left.compareTo(right) > 0) {
				max = left.compareTo(max) > 0 ? left : max;
			} else {
				max = right.compareTo(max) > 0 ? right : max;
			}
		} else if (((E) node.getData()).compareTo(max) > 0) {
			max = (E) node.getData();
		}
		if (node.getLeft() != null)
			getMaxRecursive(node.getLeft());
		if (node.getRight() != null)
			getMaxRecursive(node.getRight());
		return max;
	}

	@Override
	public int getSize() {
		return getSizeRecursive(root);
	}

	private int getSizeRecursive(Node node) {
		if (node == null)
			return 0;
		return 1 + getSizeRecursive(node.getLeft()) + getSizeRecursive(node.getRight());
	}

	@Override
	public boolean search(E e) {
		return search(e, root);
	}

	private boolean search(E e, Node node) {
		if (node == null)
			return false;
		return e.equals(node.getData()) || search(e, node.getLeft()) || search(e, node.getRight());
	}

	@Override
	public int getHeight() {
		return getHeightIterative(root);
	}

	private int getHeightIterative(Node node) {
		Queue<Node> q = new LinkedBlockingQueue<>();
		q.add(node);
		q.add(Node.NULL);
		int level = 0;
		while (!q.isEmpty()) {
			Node n = q.poll();
			if (n.getData() == null) {
				if (!q.isEmpty()) {
					q.add(Node.NULL);
					level++;
				}
			} else {
				if (n.getLeft() != null)
					q.add(n.getLeft());
				if (n.getRight() != null)
					q.add(n.getRight());
			}
		}
		return level;
	}

	private int getHeightRecursive(Node node) {
		if (node == null)
			return -1;
		else
			return 1 + Math.max(getHeightRecursive(node.getLeft()), getHeightRecursive(node.getRight()));
	}

	@Override
	public void levelOrderInReverseOrder() {
		levelOrderInReverseOrder(root);
	}

	private void levelOrderInReverseOrder(Node n) {
		Queue<Node> q = new ArrayDeque<>(15);
		Stack<Node> stack = new Stack<>();
		q.add(n);
		while (!q.isEmpty()) {
			Node node = q.poll();
			stack.push(node);
			if (node.getRight() != null)
				q.add(node.getRight());
			if (node.getLeft() != null)
				q.add(node.getLeft());
		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop().getData());
		}
	}

	@Override
	public int numberOfFullNodes() {
		return numberOfFullNodes(root);
	}

	private int numberOfFullNodes(Node node) {
		Queue<Node> q = new ArrayDeque<>(15);
		q.add(node);
		int count = 0;
		while (!q.isEmpty()) {
			Node n = q.poll();
			if (n.getLeft() != null && n.getRight() != null)
				count++;
			if (n.getLeft() != null)
				q.add(n.getLeft());
			if (n.getRight() != null)
				q.add(n.getRight());
		}
		return count;
	}

	@Override
	public int numberOfHalfNodes() {
		return numberOfHalfNodes(root);
	}

	private int numberOfHalfNodes(Node node) {
		Queue<Node> q = new ArrayDeque<>(15);
		q.add(node);
		int count = 0;
		while (!q.isEmpty()) {
			Node n = q.poll();
			if (n.getLeft() != null || n.getRight() != null)
				count++;
			if (n.getLeft() != null)
				q.add(n.getLeft());
			if (n.getRight() != null)
				q.add(n.getRight());
		}
		return count;
	}

	@Override
	public E getDeepestNode() {
		return getDeepestNode(root);
	}

	private E getDeepestNode(Node<?> node) {
		Queue<Node> q = new ArrayDeque<>(15);
		q.add(node);
		int count = 0;
		Node<?> n = null;
		while (!q.isEmpty()) {
			n = q.poll();
			if (n.getLeft() != null)
				q.add(n.getLeft());
			if (n.getRight() != null)
				q.add(n.getRight());
		}
		return (E) n.getData();
	}

	@Override
	public int levelHasMaximumSum() {
		return levelHasMaximumSum(root);
	}

	private int levelHasMaximumSum(Node node) {
		Queue<Node> q = new LinkedBlockingQueue<>();
		q.add(node);
		q.add(Node.NULL);
		int level = 0, maxLevel = 0;
		int currSum = 0, maxSum = 0;
		while (!q.isEmpty()) {
			Node n = q.poll();
			if (n.getData() == null) {
				if (currSum > maxSum) {
					maxSum = currSum;
					maxLevel = level;
				}
				currSum = 0;
				if (!q.isEmpty()) {
					q.add(Node.NULL);
					level++;
				}
			} else {
				currSum = currSum + (Integer) n.getData();
				if (n.getLeft() != null)
					q.add(n.getLeft());
				if (n.getRight() != null)
					q.add(n.getRight());
			}
		}
		return level;
	}

	@Override
	public int getSumOfAllNodes() {
		return getSumOfAllNodes(root);
	}

	private int getSumOfAllNodes(Node node) {
		if (node == null)
			return 0;
		else
			return (Integer) node.getData() + getSumOfAllNodes(node.getLeft()) + getSumOfAllNodes(node.getRight());
	}

	@Override
	public boolean sumExistInBinaryTree(int sum) {
		return sumExistInBinaryTree(root, sum);
	}

	private boolean sumExistInBinaryTree(Node node, int sum) {
		if (node == null)
			return sum == 0;
		else {
			sum = sum - (Integer) node.getData();
			return sumExistInBinaryTree(node.getLeft(), sum) || sumExistInBinaryTree(node.getRight(), sum);
		}
	}

	@Override
	public void convertToMirrorImage() {
		convertToItsMirror(root);
	}

	private void convertToItsMirror(Node node) {
		if (node == null)
			return;
		else {
			convertToItsMirror(node.getLeft());
			convertToItsMirror(node.getRight());
			Node temp = node.getLeft();
			node.setLeft(node.getRight());
			node.setRight(temp);
		}
	}

	@Override
	public boolean checkEqualityOfTwoBinaryTree(Tree tree) 
	{
		return checkEqualityOfTwoBinaryTree(getRoot(), ((AbstractBinaryTree)tree).getRoot());
	}

	private boolean checkEqualityOfTwoBinaryTree(Node root1,Node root2) 
	{
		if(root1==null && root2==null)
			return true;
		else 
			return root1.getData().equals(root2)  && checkEqualityOfTwoBinaryTree(root1.getLeft(), root2.getLeft()) 
					&& checkEqualityOfTwoBinaryTree(root1.getRight(), root2.getRight());
		
	}

	@Override
	public void printAncestorOfNodeInBinaryTree(E e) 
	{
		printAncestorOfNodeInBinaryTree(e, root);
	}
	
	private boolean printAncestorOfNodeInBinaryTree(E e, Node node)
	{
		if(node==null)
			return false;
		else  
		{
			if( node.getData().equals(e) ||  printAncestorOfNodeInBinaryTree(e, node.getLeft()) ||  printAncestorOfNodeInBinaryTree(e, node.getRight()))
				System.out.println(node.getData());
		}
		return true;
	}

	@Override
	public E getLeastCommonAncestor(E e1, E e2) 
	{
		return getLeastCommonAncestorIterative(root , e1 , e2);
	}
	
	private E getLeastCommonAncestorIterative(Node node , E e1 , E e2 ) 
	{
		
		return null;
	}

	/*@Override
	public void constructBinaryTreeFromInOrderAndPreOrder(E[] e1, E[] e2) 
	{
		constructBinaryTreeFromInOrderAndPreOrder(e1, 0,  e1.length-1, e2, 0 , e2.length-1);
	}
	
	private void constructBinaryTreeFromInOrderAndPreOrder(E[] inE2 ,int startIndexE2 ,  int lenE2 , E[] preE1,int startIndexE1 , int lenE1 )
	{
		if(startIndexE1 > lenE1 ||  startIndexE2 > lenE2)
			return ;
		Node node = new Node(preE1[startIndexE1]);
		
		int i = startIndexE1;
		
		for(; i<lenE1; i++){                                    		
			if(inE2[i] == preE1[startIndexE1])						
				break; 											
		}
		
		node.left = constructBinaryTreeFromInOrderAndPreOrder(preE1, startIndexE1, i-1, preorder, startPre+1, startPre+1+i-startIn);

	}
*/
	
	@Override
	public void constructBinaryTreeFromInOrderAndPostOrder(E[] inOrderE1, E[] postOrderE2) 
	{
		root = constructBinaryTreeFromInOrderAndPostOrder(inOrderE1, 0, inOrderE1.length-1, postOrderE2, 0, postOrderE2.length-1);
	}
	
	public Node constructBinaryTreeFromInOrderAndPostOrder(E[] inOrderE1, int startInOrder, int endInOrder , E[] postOrderE2 ,int startPost, int endPost ) 
	{
		if(startPost > endPost)
		{
			   return null ;
		}
		
		Node node = new Node(postOrderE2[endPost]);
		
		int index=0;
		for (int i = startInOrder; i <= endInOrder; i++) 
		{
		   if(postOrderE2[endPost]==inOrderE1[i])
		   {
		    index = i;
		    break;
		   }  
		}
		
		int numberOfNodes = index - startInOrder;
		
		node.setLeft(constructBinaryTreeFromInOrderAndPostOrder(inOrderE1, startInOrder, index-1, postOrderE2, startPost, (startPost + numberOfNodes)-1));
		node.setRight(constructBinaryTreeFromInOrderAndPostOrder(inOrderE1, index+1, endInOrder, postOrderE2, startPost + numberOfNodes, endPost-1));
		return node;
	}

	@Override
	public void constructBinaryTreeFromInOrderAndPreOrder(E[] e1, E[] e2)
	{
		
	}

	@Override
	public void printZigZagTraversal() 
	{
		printZigZagTraversalIterative(root);
	}
	
	private void printZigZagTraversalIterative(Node node)
	{
		Stack<Node> stack1=new Stack<>();
		Stack<Node> stack2=new Stack<>();
		stack1.add(node);
		boolean isLeftRightReading=true;
		
		while(!stack1.isEmpty())
		{
			Node n=stack1.pop();
			System.out.println(n.getData());
			if(isLeftRightReading)
			{
				if(n.getLeft()!=null)
					stack2.add(n.getLeft());
				if(n.getRight()!=null)
					stack2.add(n.getRight());
			}else
			{
				if(n.getRight()!=null)
					stack2.add(n.getRight());
				if(n.getLeft()!=null)
					stack2.add(n.getLeft());
			}
			
			if(stack1.isEmpty())
			{
				isLeftRightReading =!isLeftRightReading;
				stack1=stack2;
				stack2=new Stack<>();
			}
		}
 	}

	@Override
	public void constructBinaryTreeFromSortedArray(E[] e) 
	{
		root=constructBinaryTreeFromSortedArray((Comparable<?>[])e, 0, e.length-1);
	}
	
	private Node constructBinaryTreeFromSortedArray(Comparable[] e ,int start ,int end)
	{
		if(start>end)
			return null;
		Node<Comparable<?>> node=new Node<>();
		
		if(start==end)
		{
			node.setData(e[start]);
			node.setLeft(null);
			node.setRight(null);
		}else
		{
			int mid= start+(end-start)/2;
			node.setData(e[mid]);
			node.setLeft(constructBinaryTreeFromSortedArray(e, start, mid-1));
			node.setRight(constructBinaryTreeFromSortedArray(e, mid+1, end));
		}
		return node;
	}

	@Override
	public void constructBinaryTreeFromSortedLinkedList(LinkedList<Comparable<?>> list) 
	{
		
	}
	
	
}

