package com.manh.arrays;

import java.util.List;
import com.manh.sorting.quick.QuickSort;

public class FindFourElementsSumToGivennsqureLongn 
{
	private static int arr[]={10, 2, 3, 4} ;
	public static void main(String[] args) 
	{
		int size= ( arr.length * arr.length-1 ) / 2;
		int sum= 19;
		Aux auxSum[]=new Aux[size];
		int k=0;
		for(int i=0;i<arr.length-1 ;i++)
			for(int j=i+1;j<arr.length ;j++,k++)
				auxSum[k]=new Aux( arr[i]+ arr[j] , arr[i], arr[j] );
		
		List<Aux> l= new QuickSort<>().sort(auxSum);
		int i = 0 , j= size =l.size()-1 ;
		while( i<size  &&  j>=0)
		{
			if( l.get(i).getData() + l.get(j).getData() == sum )
			{
				System.out.println( l.get(i).getStart() +" " + l.get(i).getEnd() + " "+ l.get(j).getStart() +" " + l.get(j).getEnd());
				i++;j--;
			}else if( l.get(i).getData() + l.get(j).getData() < sum )
				i++;
			else
				j--;
		}
	}
	private static class Aux implements Comparable<Aux>
	{
		private int data;
		private int start;
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public int getStart() {
			return start;
		}
		public void setStart(int start) {
			this.start = start;
		}
		public int getEnd() {
			return end;
		}
		public void setEnd(int end) {
			this.end = end;
		}
		private int end;
		public Aux(int data, int start, int end) 
		{
			super();
			this.data = data;
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Aux o) 
		{
			return this.data - o.data ;
		}
		@Override
		public String toString() 
		{
			return "Sum -"+new Integer(data).toString();
		}
	}
}
