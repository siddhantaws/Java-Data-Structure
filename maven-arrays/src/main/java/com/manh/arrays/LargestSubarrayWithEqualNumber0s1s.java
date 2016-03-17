package com.manh.arrays;

public class LargestSubarrayWithEqualNumber0s1s 
{
	private static int arr[]={1, 0, 0, 1, 0, 1, 1};
	
	public static void main(String[] args) 
	{
		int count0s= 0 ,count1s=0;
		int matchCount =0 ,matchIndex =0;
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i]==0)
				++count0s;
			else
				++count1s;
			if(count0s == count1s )
			{
				matchCount = Math.max( matchCount, count0s*2);	
				matchIndex = i;
			}
		}
		System.out.println("Total Count "+matchCount +" end Index " +matchIndex +" Start Index ");
	}
}
