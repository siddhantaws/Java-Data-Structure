package com.manh.arrays;

import java.util.Stack;

public class IncreasingSubsequenceLength3MaximumProduct {
	private static int arr[] = {5 , 3, 4,6 ,7};

	public static void main(String[] args) {
		int n = arr.length;
		int left[] = new int[n];
		int right[] = new int[n];

		for (int i = 0; i < n; i++) {
			left[i] = 0;
			right[i] = 0;
		}
		
		//Calculating the right array
		int max = Integer.MIN_VALUE;
		for(int i=n-1;i>=0;i--)
		{
			if(max < arr[i])
			{
				max = arr[i];
				right[i] = -1;
			}
			else	right[i] = max;
		}
		//Calculating the left array.
		Stack<Integer> s=new Stack<>();
		
		for(int i=0;i<n;i++)
		{
			if(right[i] == -1)
			{
				left[i] = -1;
				continue;
			}
			max = -1;
			while(!s.empty() && s.peek() < arr[i])
			{
				max = s.peek();
				s.pop();
			}
			left[i] = max;
			s.push(arr[i]);
		}	
		
		max = Integer.MIN_VALUE;
		int ni = 0;
		int nj = 0;
		int nk = 0;
		for(int i=1;i<n-1;i++)
		{
			if(max < left[i]*arr[i]*right[i])
			{
				ni = left[i];
				nj = arr[i];
				nk = right[i];
				max = left[i]*arr[i]*right[i];
			}
		}
		System.out.println(ni +" "+ nj +" "+nk);
	}
}
