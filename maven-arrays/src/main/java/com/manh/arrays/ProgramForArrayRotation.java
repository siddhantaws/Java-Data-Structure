package com.manh.arrays;

public class ProgramForArrayRotation 
{
	private static int arr[] ={1, 2, 3, 4, 5, 6, 7};
	
	public static void main(String[] args) 
	{
		leftRotate(arr, 3 , arr.length);
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
		  int i, j, k, temp;
		  int gdc= gcd(d, n);
		  for (i = 0; i < gdc ; i++)
		  {
		    /* move i-th values of blocks */
		    temp = arr[i];
		    j = i;
		    while(true)
		    {
		      k = j + d;
		      if (k >= n)
		        k = k - n;
		      if (k == i)
		        break;
		      arr[j] = arr[k];
		      j = k;
		    }
		    arr[j] = temp;
		  }
	}
	
	private static int gcd(int a,int b)
	{
	   if(b==0)
	     return a;
	   else
	     return gcd(b, a%b);
	}
}
