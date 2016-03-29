package com.manh.arrays;

public class CountStrictlyIncreasingSubarrays
{
	private static int arr[]={1, 2, 3, 4};
	
	public static void main(String[] args) 
	{
		int totalCount=1;int totalSum=0;
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]>arr[i-1])
			{
				totalCount++;
			}
			else
			{
				totalSum +=(totalCount*(totalCount-1))/2;
				totalCount=1;
			}
		}
		totalSum = totalCount == 1 ? totalSum : (totalCount*(totalCount-1))/2;
		System.out.println("Total Count " + totalSum);
	}
}
