package com.manh.arrays;

public class SmallestSubarraySumGreaterAGivenValue 
{
	private static int arr[] = {1, 4, 45, 6, 0, 19};
	
	public static void main(String[] args) 
	{
		System.out.println(	smallestSubWithSum(arr,arr.length, 51)	);
	}
	private static int smallestSubWithSum(int arr[], int n, int sum)
	{
		int curr_sum = 0, start = 0, i;
		int minIndex = n + 1;
	 
		for (i = 0; i < n; i++)
		{
			curr_sum = curr_sum + arr[i];
	 
			// If curr_sum exceeds the sum, then remove the starting elements
			while (curr_sum > sum && start <= i)
			{
				minIndex = Math.min(minIndex, i-start+1);
				curr_sum = curr_sum - arr[start];
				start++;
			}
		}
		return minIndex;
	}
}
