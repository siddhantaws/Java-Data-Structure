package com.manh.arrays;

import java.util.Stack;

import com.manh.util.CircularLinkedList;
import com.manh.util.LinkedList.Node;

public class MaximumCircularSubarraySum 
{
	public static void main(String[] args) 
	{
		CircularLinkedList<Integer> cl=new CircularLinkedList<>();
		cl.add(-4);cl.add(15);
		cl.add(-6);cl.add(18);cl.add(2);cl.add(-20);
		int arr[]=new int[6];
		Node<Integer> curr=cl.getFirst();
		arr[0] = curr.getE();
		Stack<Integer> stack=new Stack<>();
		stack.push(arr[0]);
		int i=1;
		for(Node<Integer> n=curr.getNext(); n!=curr ; n=n.getNext())
		{
			arr[i]=Math.max( n.getE()  , arr[i-1]+ n.getE() );
			if(stack.peek()<arr[i])
			{
				stack.pop();
				stack.push(arr[i]);
			}	
			i++;
		}
	}
}
