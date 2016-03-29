package com.manh.arrays;

public class MaximumDifferenceTwoElementsLargerElementAfterSmallerNumber 
{
	private static int arr [] ={2, 3, 10, 6, 4, 8, 1};
	
	public static void main(String[] args) 
	{
		System.out.println(maxDiffOne(arr, arr.length));
	}
	//Solutions1
	private static int maxDiffOne(int arr[], int arr_size)
	{
	  int max_diff = arr[1] - arr[0];
	  int min_element = arr[0];
	  int i;
	  for(i = 1; i < arr_size; i++)
	  {       
	    if (arr[i] - min_element > max_diff)                               
	      max_diff = arr[i] - min_element;
	    if (arr[i] < min_element)
	         min_element = arr[i];                     
	  }
	  return max_diff;
	}    
	//Solutions2
	private static int maxDiffTwo(int arr[], int n)
	{
	    int maxDiff = -1; // Initialize Result
	 
	    int maxRight = arr[n-1]; // Initialize max element from right side
	 
	    for (int i = n-2; i >= 0; i--)
	    {
	        if (arr[i] > maxRight)
	            maxRight = arr[i];
	        else
	        {
	            int diff = maxRight - arr[i];
	            if (diff > maxDiff)
	            {
	                maxDiff = diff;
	            }
	        }
	    }
	    return maxDiff;
	} 
	//Solutions3
	private static int maxDiffThree(int arr[], int n)
	{
	    // Create a diff array of size n-1. The array will hold
	    //  the difference of adjacent elements
	    int diff[]=new int[n-1];
	    for (int i=0; i < n-1; i++)
	        diff[i] = arr[i+1] - arr[i];
	 
	    // Now find the maximum sum subarray in diff array
	    int max_diff = diff[0];
	    for (int i=1; i<n-1; i++)
	    {
	        if (diff[i-1] > 0)
	            diff[i] += diff[i-1];
	        if (max_diff < diff[i])
	            max_diff = diff[i];
	    }
	    return max_diff;
	}
	//Solutions4
	private static int maxDiffFour(int arr[], int n)
	{
	    // Initialize diff, current sum and max sum
	    int diff = arr[1]-arr[0];
	    int curr_sum = diff;
	    int max_sum = curr_sum;
	 
	    for(int i=1; i<n-1; i++)
	    {
	        // Calculate current diff
	        diff = arr[i+1]-arr[i];
	 
	        // Calculate current sum
	        if (curr_sum > 0)
	           curr_sum += diff;
	        else
	           curr_sum = diff;
	 
	        // Update max sum, if needed
	        if (curr_sum > max_sum)
	           max_sum = curr_sum;
	    }
	 
	    return max_sum;
	}
}
