package com.manh.arrays;

public class RearrangeArrayInMaximumMinimumForm 
{
	private static int arr[] = {1, 2, 3, 4, 5, 6, 7} ;
	
	public static void main(String[] args) 
	{
		rearrange(arr, arr.length);
	}
	
	private static void rearrange(int arr[], int n)
	{
	    // Traverse through all numbers
	    for (int i=0; i<n; i++)
	    {
	        int temp = arr[i];
	 
	        // If number is negative then we have already
	        // processed it. Else process all numbers which
	        // are to be replaced by each other in cyclic way
	        while (temp > 0)
	        {
	            // Find the index where arr[i] should go
	            int j = (i < n/2)? 2*i + 1 : 2*(n-1-i);
	 
	            // If arr[i] is already at its correct
	            // position, mark it as negative
	            if (i == j)
	            {
	                arr[i] = -temp;
	                break;
	            }
	 
	            // Swap the number 'temp' with the current number
	            // at its target position
	            swap(i, j);
	 
	            // Mark the number as processed
	            arr[j] = -arr[j];
	 
	            // Next process the previous number at target position
	            i = j;
	        }
	    }
	 
	    // Change the number to original value
	    for (int i=0; i<n; i++)
	        arr[i] = -arr[i];
	}
	
	private static void swap(int source ,int dest)
	{
		int temp = arr[source];
		arr[source] = arr[dest] ;
		arr[dest]=temp;
	}
}
