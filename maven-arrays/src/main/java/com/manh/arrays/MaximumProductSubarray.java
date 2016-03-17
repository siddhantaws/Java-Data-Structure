package com.manh.arrays;

public class MaximumProductSubarray
{
	private static int arr[]={-2, -3, 0, -2, -40};

	public static void main(String[] args) {
		int currMax []=new int[arr.length];
		int multiMax=currMax[0]=arr[0] ;
		
		for(int i=1;i<arr.length;i++)
		{
			currMax[i] =Math.max(arr[i] ==0 ? 1 : arr[i] , currMax[i-1] * arr[i] );
			multiMax=Math.max(multiMax , currMax[i]);
		}	
		System.out.println(multiMax);
	}
}
