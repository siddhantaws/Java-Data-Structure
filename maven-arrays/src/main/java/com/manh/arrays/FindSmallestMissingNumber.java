package com.manh.arrays;

public class FindSmallestMissingNumber 
{
	private static int arr[] = {4, 5, 10, 11};
	
	public static void main(String[] args) 
	{
		System.out.println(findFirstMissing(arr, 0, arr.length-1));
	}
	
	private static int findFirstMissing(int array[], int start, int end) 
	{
		 
	    if(start  > end)
	      return end + 1;
	 
	    if (start != array[start])
	      return start;
	 
	    int mid = (start + end) / 2;
	 
	    if (array[mid] > mid)
	      return findFirstMissing(array, start, mid);
	    else
	      return findFirstMissing(array, mid + 1, end);
	}
}
