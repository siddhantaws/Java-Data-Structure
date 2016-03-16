package com.manh.sorting.quick;

import java.util.List;

import com.manh.sorting.sort.Sorting;

public class QuickSort<E extends Comparable> implements Sorting<Comparable>
{

	@Override
	public void sort(List l) 
	{
		quickSort(l , 0 , l.size()-1 );
		for(Integer x:(List<Integer>)l)
			System.out.println(x);
	}	
	
	private void quickSort(List l, int start , int end)
	{
		if(start<end)
		{
			int pivot=getPivot( l , start , end );
			quickSort( l , start , pivot-1 );
			quickSort( l , pivot+1 , end );
		}
	}
	
	private int getPivot(List l, int start , int end)
	{
		E e = (E)l.get(end);
		int i=start , pIndex =start;
		for( ; i<=end-1 ; i++)
		{
			if(e.compareTo(l.get(i))>0)
			{
				swap(l, i, pIndex);
				pIndex++;
			}
		}
		swap(l, end, pIndex);
		return pIndex;
	}
	
	private void swap(List l ,int source ,int dest)
	{
		E temp =(E) l.get(dest);
		l.set(dest, (E) l.get(source) );
		l.set(source, temp  );
	}
	
}
