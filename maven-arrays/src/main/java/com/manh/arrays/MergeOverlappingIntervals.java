package com.manh.arrays;

import java.util.List;

public class MergeOverlappingIntervals 
{
	private static int  arr[][]={{1,3}, {2,4}, {5,7}, {6,8} };
	
	public static void main(String[] args) 
	{
		
	}
	
	private class Interval implements Comparable<Interval>
	{
		private int start; private int end;

		@Override
		public int compareTo(Interval o) 
		{
			return this.start - o.start;
		} 
		
	}
	private List<Interval> constructData(int arr[][] )
	{
		return null;  
	}
}
