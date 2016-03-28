package com.manh.arrays;

public class SubsequenceProgramsGenerateThem 
{
	private static int arr[] = {1, 2, 3, 4};
	
	public static void main(String[] args) {
		int opsize = (int) Math.pow(2, arr.length);
		 
	    /* Run from counter 000..1 to 111..1*/
	    for (int counter = 1; counter < opsize; counter++)
	    {
	        for (int j = 0; j < arr.length; j++)
	        {
	            /* Check if jth bit in the counter is set
	                If set then print jth element from arr[] */
	            if (counter & (1<<j))
	                cout << arr[j] << " ";
	        }
	      
	    }	
	}
}
