package com.manh.arrays;

public class AProductArrayPuzzle 
{
	private static int arr[]={10, 3, 5, 6, 2};
	
	public static void main(String[] args) 
	{
		int product =1;
		int productArray[]=new int[arr.length];
		for(int i=1;i<arr.length;i++)
		{
			product*=arr[i];
		}
		productArray[0]=product;
		for(int i=1;i<arr.length;i++)
		{
			productArray[i] = (productArray[i-1]/arr[i]) * arr[i-1];
		}
	}
}
