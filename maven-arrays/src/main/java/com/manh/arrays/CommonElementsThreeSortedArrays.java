package com.manh.arrays;

public class CommonElementsThreeSortedArrays 
{
	private static int ar1[] = {1, 5, 10, 20, 40, 80};
	private static int ar2[] = {6, 7, 20, 80, 100};
	private static int ar3[] = {3, 4, 15, 20, 30, 70, 80, 120};
	
	public static void main(String[] args) 
	{
		findCommon(ar1, ar2, ar3, ar1.length, ar2.length, ar3.length);
	}
	//Soln1
	private static void compareOne(int arr1[], int i ,int m ,int arr2[], int j ,int n ,int arr3[] )
	{
		if(i<m)
		{
			while(arr1[i++]==arr2[j++])
			{
				compareOne(arr1, i , m ,arr2,  j , n , arr3);
				compareTwo(arr1[i-1], arr3 ,0 ,ar3.length);
			}
		}
	}
	
	private static void compareTwo(int compareVal , int arr3[] ,int start ,int end)
	{
		if(start<end)
		{
			int mid=start+(end-start)/2;
			if(arr3[mid]==compareVal)
				System.out.println(compareVal);
			else if(arr3[mid]>compareVal)
				compareTwo(compareVal, arr3, start, mid-1);
			else
				compareTwo(compareVal, arr3, mid+1, end);
		}
	}
	//Soln2
	private static void findCommon(int ar1[], int ar2[], int ar3[], int n1, int n2, int n3)
	{
	    // Initialize starting indexes for ar1[], ar2[] and ar3[]
	    int i = 0, j = 0, k = 0;
	 
	    // Iterate through three arrays while all arrays have elements
	    while (i < n1 && j < n2 && k < n3)
	    {
	         // If x = y and y = z, print any of them and move ahead 
	         // in all arrays
	         if (ar1[i] == ar2[j] && ar2[j] == ar3[k])
	         {   
	        	 System.out.println(ar1[i++]);
	        	 j++;k++;
	         }
	 
	         // x < y
	         else if (ar1[i] < ar2[j])
	             i++;
	 
	         // y < z
	         else if (ar2[j] < ar3[k])
	             j++;
	 
	         // We reach here when x > y and z < y, i.e., z is smallest
	         else
	             k++;
	    }
	}
}
