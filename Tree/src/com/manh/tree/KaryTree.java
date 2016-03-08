package com.manh.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class KaryTree extends AbstractBinaryTree<Comparable> implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Node root;
	
	@Override
	public int getSize() 
	{
		return getSize(root) + 1;
	}
	
	private int getSize(Node node)
	{
		int n= node.getChildren().size();
		for(Node n1 : (List<Node<?>>)node.getChildren())
			n=n+ getSize(n1);
		return n;
	}
	
	@Override
	public boolean add(Comparable parent, Comparable child) 
	{
		Node node= search(root, parent);
		if(node!=null)
		{
			node.addChild(new Node<Comparable>(child));
			return true;
		}
		return false;
	}
	
	@Override
	public void preOrderTraversal() 
	{
		for(Comparable data :   preOrderTraversal(root, new ArrayList<>()))
		{
			System.out.println(data);
		}
	}
	
	private List<Comparable> preOrderTraversal(Node node ,List<Comparable> nodes)
	{
		nodes.add(node.getData());
		for(Node n1 :(List<Node<?>>)node.getChildren())
			preOrderTraversal(n1 , nodes) ;
		return nodes;
	}
	
	@Override
	public void postOrderTraversal() 
	{
		for(Comparable data :   preOrderTraversal(root, new ArrayList<>()))
		{
			System.out.println(data);
		}
	}
	
	private List<Comparable> postOrderTraversal(Node node ,List<Comparable> nodes)
	{
		
		for(Node n1 :(List<Node<?>>)node.getChildren())
			postOrderTraversal(n1 , nodes) ;
		nodes.add(node.getData());
		return nodes;
	}
	
	
	@Override
	public boolean search(Comparable e) 
	{
		Node n= search ( root , e);
		return n!=null ;
	}
	
	private Node search(Node node , Comparable e)
	{
		if(node==null) 
			return null;
		if(node.getData().equals(e))
			return node;
		else
		{
			for(Node n1:(List<Node>)node.getChildren())
				node  =search( n1 ,  e);
		}
		return node;
	}	
	
	
	private static class Node<E extends Comparable> 
	{
		private E data;
		
		private List<Node<E>> children;

		private Node<E> parent;
		
		
		public List<Node<E>> getChildren() {
			return children;
		}
		
		public void setChildren(List<Node<E>> children) 
		{
			for (Node<E> child : children)
				child.setParent(this);
			this.children = children;
		}
		
		public Node<E> getParent() {
			return parent;
		}

		public void setParent(Node<E> parent) {
			this.parent = parent;
		}

		public E getData() {
			return data;
		}

		public void setData(E data) {
			this.data = data;
		}

		public Node(E e) 
		{
			this.data = e;
			this.children=new ArrayList<>();
		}

		public Node (Node<E> node)
		{
			this.data=node.getData();
			this.children=new ArrayList<>();
		}
		
		public void addChild(Node<E> child) 
		{
			child.setParent(this);
			this.children.add(child);
		}
		
		public void addChildAt(int index, Node<E> child)
		{
			child.setParent(this);
			this.children.add(index, child);
		}
		
		public void removeChildren()
		{
			this.children.clear();
		}
		
		public Node<E> removeChildAt(int index) 
		{
			return children.remove(index);
		}
		
		public Node<E> getChildAt(int index) {
			return children.get(index);
		}
		
		private Node() {
			this.data = null;
		}

		@Override
		public boolean equals(Object obj) 
		{
			if(obj==null)
				return false;
			return obj.equals(getData());
		}
	}
}
