package com.manh.arrays;

public class FindTwoRepeatingElementsInArray 
{
	private static int arr[]= {4, 2, 4, 5, 2, 3, 1};
	public static void main(String[] args) 
	{
		int totalSum=  arr[0] , maxElement=0, totalProduct =arr[0];
		for(int i=1;i<arr.length;i++)
		{
			maxElement=Math.max(arr[i], arr[i-1]);
			totalSum +=arr[i];
			totalProduct*=arr[i];
		}
		int sumOfElement = (maxElement*(maxElement-1))/2;
		int multiOfElement =totalProduct/3600;
		double diffOfElement =Math.pow((double)sumOfElement, 2.0) - (4*multiOfElement);
		int a= (sumOfElement+(int)diffOfElement)/2;
		int b= (sumOfElement-(int)diffOfElement)/2;
	}
}
