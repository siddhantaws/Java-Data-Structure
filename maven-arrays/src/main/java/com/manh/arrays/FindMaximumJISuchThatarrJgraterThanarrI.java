package com.manh.arrays;

public class FindMaximumJISuchThatarrJgraterThanarrI {
	private static int arr[] = { 34, 8, 10, 3, 2, 80, 30, 33, 1 };

	public static void main(String[] args) {
		int maxDiff=0;
		int i, j;
		int LMin[] = new int[arr.length];
		int RMax[] = new int[arr.length];
		 /* Construct LMin[] such that LMin[i] stores the minimum value
	       from (arr[0], arr[1], ... arr[i]) */
		LMin[0] = arr[0];
	    for (i = 1; i < arr.length; ++i)
	        LMin[i] = Math.min(arr[i], LMin[i-1]);
	    
	    /* Construct RMax[] such that RMax[j] stores the maximum value
	       from (arr[j], arr[j+1], ..arr[n-1]) */
	    RMax[arr.length-1] = arr[arr.length-1];
	    for (j = arr.length-2; j >= 0; --j)
	        RMax[j] = Math.max(arr[j], RMax[j+1]);
	    /* Traverse both arrays from left to right to find optimum j - i
        This process is similar to merge() of MergeSort */
	    i = 0; j = 0; maxDiff = -1;
	    while (j < arr.length && i < arr.length)
	    {
	        if (LMin[i] < RMax[j])
	        {
	            maxDiff = Math.max(maxDiff, j-i);
	            j = j + 1;
	        }
	        else
	            i = i+1;
	    }
	    System.out.println(maxDiff);
	}
}
