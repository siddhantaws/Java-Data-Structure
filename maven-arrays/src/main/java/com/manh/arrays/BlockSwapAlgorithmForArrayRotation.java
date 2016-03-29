package com.manh.arrays;

public class BlockSwapAlgorithmForArrayRotation {

	private static int arr[]={1, 2, 3, 4, 5, 6, 7};
	
	public static void main(String[] args) {
		leftRotate(arr, 3, arr.length);
		printArray(arr, arr.length);
	}
	
	private static void printArray(int arr[], int size)
	{
	  int i;
	  for(i = 0; i < size; i++)
	    System.err.print(arr[i]);
	}
	
	private static void leftRotate(int arr[], int d, int n) 
	{
		int i, j;
		if (d == 0 || d == n)
			return;
		i = d;
		j = n - d;
		while (i != j) {
			if (i < j) /* A is shorter */
			{
				swap( d - i, d + j - i, i);
				j -= i;
			} else /* B is shorter */
			{
				swap( d - i, d, j);
				i -= j;
			}
			// printArray(arr, 7);
		}
		/* Finally, block swap A and B */
		swap( d - i, d, i);
	}
	
	/*This function swaps d elements starting at index fi
	with d elements starting at index si */
	private static void swap(int fi, int si, int d)
	{
	   int i, temp;
	   for(i = 0; i<d; i++)   
	   {
	     temp = arr[fi + i];
	     arr[fi + i] = arr[si + i];
	     arr[si + i] = temp;
	   }     
	}  
}
