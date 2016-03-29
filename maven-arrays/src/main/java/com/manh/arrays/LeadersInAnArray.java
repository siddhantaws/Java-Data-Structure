package com.manh.arrays;

public class LeadersInAnArray 
{
	public static void main(String[] args) 
	{
		 int arr[] = {16, 17, 4, 3, 5, 2};
		printLeaders(arr, arr.length);
	}
	private static void printLeaders(int arr[], int size)
	{
	    int max_from_right =  arr[size-1];
	 
	    /* Rightmost element is always leader */
	    System.out.println("max from right ->"+max_from_right);
	     
	    for (int i = size-2; i >= 0; i--)
	    {
	        if (max_from_right < arr[i])
	        {           
	            max_from_right = arr[i];
	            System.out.println("max from right ->"+max_from_right);
	        }
	    }    
	}
	 
}
