package com.manh.arrays;

public class FindDuplicateInOnTimeO1ExtraSpace 
{
	private static void printRepeating(int arr[], int size)
	{
	  int i;
	  System.out.println("The repeating elements are: \n");
	  for (i = 0; i < size; i++)
	  {
	    if (arr[Math.abs(arr[i])] >= 0)
	      arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
	    else
	      System.out.printf(" %d ", Math.abs(arr[i]));
	  }
	}
	 public static void main(String[] args) 
	 {
		 int arr[] = {1, 2, 3, 1, 3, 6, 6};
		 FindDuplicateInOnTimeO1ExtraSpace.printRepeating( arr , 7);
	}
}
