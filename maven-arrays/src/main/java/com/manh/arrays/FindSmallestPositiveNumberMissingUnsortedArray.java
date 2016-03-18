package com.manh.arrays;

public class FindSmallestPositiveNumberMissingUnsortedArray 
{
	private static int arr[] = {2, 3, 7, 6, 8, -1, -10, 15} ;
	
	public static void main(String[] args) 
	{
		int shift = segregate (arr, arr.length);
	/*
	 * After segregration find the max element in the array 
	 * create a boolean array of that size 
	 * traverse array make the update as arrboolean[arr[i]]=true
	 * travese array get the least i from  arrboolean[i]=false 
	 * */
	}
	
	private static int segregate (int arr[], int size)
	{
	    int j = 0, i;
	    for(i = 0; i < size; i++)
	    {
	       if (arr[i] <= 0)  
	       {
	           swap(i, j);
	           j++;  // increment count of non-positive integers
	       }
	    }
	 
	    return j;
	}
	
	private static void swap(int source ,int dest)
	{
		int temp =arr[source];
		arr[source] = arr[dest];
		arr[dest]=temp;
	}
	
}
