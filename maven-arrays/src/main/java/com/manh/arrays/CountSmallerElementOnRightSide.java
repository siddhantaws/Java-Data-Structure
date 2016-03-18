package com.manh.arrays;

public class CountSmallerElementOnRightSide 
{
	
	public static void main(String[] args) 
	{
		int[] arr = new int[]{12, 1, 2, 3, 0, 11, 4};
		System.out.println("Input array");
		
		Node dummyNode = new Node(-Integer.MAX_VALUE);
		int[] countSmaller = new int[arr.length];
		for(int i=arr.length-1;i>=0;i--){
			Node node = new Node(arr[i]);
			push(node,dummyNode);
			countSmaller[i] = node.smallerCount;
		}
 
		System.out.println("\nOutput array");
		for(int i: countSmaller)
			System.out.print(i+",");
		System.out.println("");
	}
	
	static class Node{
		int data;
		Node left;
		Node right;
		int count;
		int smallerCount;
		public Node(int data)
		{
			this.data = data;
		}
	}
	
	private static void push(Node node, Node head)
	{
		if(head != null){
			if(head.data < node.data){
				head.count++;
				//System.out.println("head.data="+head.data);
				node.smallerCount += (head.left == null)?1:(head.left.count+2);
				if(head.right == null){
					node.smallerCount--;	//to account for dummy node;
					//System.out.println(node.data+" - number of smaller elements on right >>"+node.smallerCount);
					head.right = node;
				} else{
					push(node, head.right);
				}
			} else if(head.data > node.data){
				head.count++;
				if(head.left == null){
					head.left = node;
					node.smallerCount--;	//to account for dummy node;
					//System.out.println(node.data+" - number of smaller elements on right >>"+node.smallerCount);
				} else{
					push(node,head.left);
				}
			}
		}
	}
}
