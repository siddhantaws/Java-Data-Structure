package com.manh.sorting.merge;

import java.util.Arrays;

import com.manh.sorting.quick.QuickSort;

public class Main 
{
	public static void main(String[] args) 
	{
		Comparable []arr={25,30,1,20,5,7,8};
		new QuickSort<Integer>().sort(Arrays.asList(arr));
	}
}
