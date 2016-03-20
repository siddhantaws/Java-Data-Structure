package com.manh.sorting.count;

import java.util.Arrays;
import java.util.List;

import com.manh.sorting.sort.Sorting;

public class CountingSort<E extends Comparable> implements Sorting<Comparable>
{
	 private static final int MAX_RANGE = 1000000;

	@Override
	public List sort(List l) 
	{
		int N = l.size();
        if (N == 0)
            return null;
        /** find max and min values **/
        int max =(int) l.get(0), min = (int) l.get(0);
        for (int i = 1; i < N; i++)
        {
            if ((int) l.get(i) > max)
                max = (int) l.get(i);
            if ((int) l.get(i) < min)
                min = (int) l.get(i);
        }
        int range = max - min + 1;
 
        /** check if range is small enough for count array **/
        /** else it might give out of memory exception while allocating memory for array **/
        if (range > MAX_RANGE)
        {
            System.out.println("\nError : Range too large for sort");
            return null;
        }
 
        int[] count = new int[range];
        /** make count/frequency array for each element **/
        for (int i = 0; i <N; i++)
            count[(int) l.get(i) - min]++;
        /** modify count so that positions in final array is obtained **/
        for (int i = 1; i < range; i++)
            count[i] += count[i - 1];
        /** modify original array **/
        int j = 0;
        for (int i = 0; i < range; i++)
            while (j < count[i])
            	 l.set(j++, i + min);
		return l;
	}
	
}