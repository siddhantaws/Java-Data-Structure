package com.manh.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.manh.sorting.quick.QuickSort;
import com.manh.sorting.sort.Sorting;

public class CountNumberPossibleTriangles {
	private static int arr[] = { 4, 6, 3, 7 };

	public static void main(String[] args) {
		Sorting sorting = new QuickSort<Integer>();
		List l = new ArrayList<>();
		for (int a : arr)
			l.add(a);
		l = sorting.sort(l);
		System.out.println(1);
		int count = 0;
		for (int i = 0; i < l.size() - 2; i++) {
			int k = i + 2;
			for (int j = i + 1; j < l.size() - 1; j++) {
				while (k < l.size()  &&  ( ((int) l.get(i)) + ((int) l.get(j)) ) > ((int) l.get(k)))
					++k;
				count += k - j - 1;
			}
		}
		System.out.println(count);
	}
}
