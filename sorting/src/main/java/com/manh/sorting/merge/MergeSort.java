package com.manh.sorting.merge;

import java.util.List;

import com.manh.sorting.sort.Sorting;

public class MergeSort<E extends Comparable> implements Sorting<Comparable>
{
	private static Comparable [] comp;
	
	@Override
	public List sort(List list) {
		comp=new Comparable[list.size()];
		mergeSort(list, 0, list.size() - 1);
		return list;
	}

	private void mergeSort(List<E> list, int start, int end) {
		if (start < end) {
			int middle = start + (end - start) / 2;
			mergeSort(list, start, middle);
			mergeSort(list, middle + 1, end);
			merge(list, start, middle, end);
		}
	}

	private void merge(List list, int start, int middle, int end) {
		
		for (int i = start; i <= end; i++) {
			comp[i] = (Comparable) list.get(i);
		}
		int i = start;
		int j = middle + 1;
		int k = start;
		while (i <= middle && j <= end) {
			if (comp[i].compareTo(comp[j]) > 0) 
			{
				list.set(k++, comp[j++]);
			}else
			{
				list.set(k++, comp[i++]);
			}
		}
		while (i <= middle )
		{
			list.set(k++, comp[i++]);
		}
		while (j <= end)
		{
			list.set(k++, comp[j++]);
		}
	}
	
}
