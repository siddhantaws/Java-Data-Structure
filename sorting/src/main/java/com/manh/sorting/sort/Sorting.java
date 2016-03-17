package com.manh.sorting.sort;

import java.util.ArrayList;
import java.util.List;

public interface Sorting <E extends Comparable>
{
	public List sort(List l);
	
	public default List sort(Object obj[])
	{
		List l=new ArrayList<>();
		for(Object o  : obj)
			if(o!=null)
				l.add(o);
		return sort(l);
	}
}
