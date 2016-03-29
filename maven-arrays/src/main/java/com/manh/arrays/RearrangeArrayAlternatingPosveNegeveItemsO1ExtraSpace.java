package com.manh.arrays;

public class RearrangeArrayAlternatingPosveNegeveItemsO1ExtraSpace 
{
	private static int  arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8} ;

	
	public static void main(String[] args) 
	{
		rearrange(arr, arr.length);
		printArray();
	}
	
	private static void rearrange(int arr[], int n)
	{
	    int i,j;
	     // this for loop segregate the +ve and -ve Number
	    for(i=0,j=0;j<n;++j)
	    {
	        if(arr[j] < 0)
	        {
	        	rotate(arr,i,j);
	        ++i;
	        }
	    }
	    j = 0;
	 
	    // This while loop arranging +ve and -ve number 
	    if(arr[j] < 0)
	        ++j;
	    while(i < n && j <= i)
	    {
	        rotate(arr,j,i);
	        i = i + 1;
	        j = j + 2;
	 
	    }
	}
	
	private static void rotate(int arr[],int start,int end)
	{
	  int temp = arr[end];
	  while(start < end)
	  {
	    arr[end] = arr[end - 1];
	    --end;
	  }
	  arr[start] = temp;
	}
	
	private static void printArray()
	{
		for(int i : arr)
			System.out.print(" "+i);
	}
}
