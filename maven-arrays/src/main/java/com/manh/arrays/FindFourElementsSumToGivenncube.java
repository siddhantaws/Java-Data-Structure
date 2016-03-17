package com.manh.arrays;

import java.util.List;

import com.manh.sorting.quick.QuickSort;

public class FindFourElementsSumToGivenncube {
	private static Object Object[] = { 10, 2, 3, 4 };
	private static int sum = 19;

	public static void main(String[] args) {
		List<Integer> l = new QuickSort<>().sort(Object);
		for (int i = 0; i <= l.size() - 4; i++)
			for (int j = i + 1; j <= l.size() - 3; j++) {
				int k = j + 1;
				int r = l.size() - 1;
				while ( k < r) {
					int totalSum = (l.get(i) + l.get(j) + l.get(k) + l.get(r));
					if (totalSum == sum) {
						print(l.get(i), l.get(j), l.get(k), l.get(r));
						k++;
						r--;
					} else if (totalSum < sum)
						k++;
					else
						r--;
				}
			}
	}

	private static void print(Integer... integer) {
		for (int i : integer)
			System.out.print(i + " ");
		System.out.println();
	}
}
