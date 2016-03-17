package com.manh.arrays;

public class KadaneAlgorithm 
{
	private static int arr[]={-4,15 ,-6,18,2, -20};
	public static void main(String[] args) 
	{
		int currMax[]=new int[arr.length];currMax[0]=arr[0];
		int totalMax[]=new int[arr.length];totalMax[0]=arr[0];
		for(int i=1;i<arr.length;i++)
		{
			currMax[i]=Math.max(arr[i], arr[i]+currMax[i-1]);
			totalMax[i]=Math.max(currMax[i], totalMax[i-1]);
		}
	}
}
