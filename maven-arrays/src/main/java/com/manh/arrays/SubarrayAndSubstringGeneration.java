package com.manh.arrays;

public class SubarrayAndSubstringGeneration 
{
	private static int arr[] = {1, 2, 3, 4};
	
	public static void main(String[] args) 
	{
		for (int i=0; i <arr.length; i++)
	    {
	        // Pick ending point
	        for (int j=i; j<arr.length; j++)
	        {
	            // Print subarray between current starting
	            // and ending points
	            for (int k=i; k<=j; k++)
	            		System.out.print(arr[k]);
	            System.out.println("");
	 
	        }
	    }
	}
}
