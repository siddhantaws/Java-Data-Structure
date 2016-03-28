package com.manh.arrays;

public class FindMaximumRepeatingNumber {
	private static int arr[] = { 1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 3 };

	public static void main(String[] args) {
		int k = 10;

		for (int i = 0; i < arr.length; i++)
		{
			arr[(arr[i] % k)] += k;
		}
			

		int max = arr[0], result = 0;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				result = i;
			}
		}
		System.out.println(result);
		/* Uncomment this code to get the original array back
        for (int i = 0; i< n; i++)
          arr[i] = arr[i]%k; */
		
	}
}
