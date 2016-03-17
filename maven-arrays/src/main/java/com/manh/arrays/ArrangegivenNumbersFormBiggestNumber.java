package com.manh.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class ArrangegivenNumbersFormBiggestNumber 
{
	private static int arr[]={54, 546, 548, 60};
	/*Arrange given numbers to form the biggest number */
	
	public static void main(String[] args) 
	{
		ArrayList<String> al=new ArrayList<>();
		al.add("54");al.add("546");al.add("548");al.add("60");
		Collections.sort(al, (e1, e2 ) -> { return e2.compareTo(e1); } );
	}
}
