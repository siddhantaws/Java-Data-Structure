package com.manh.arrays;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceProgramsGenerateThem 
{
	public static void generateSequence(String[] args) {
	    List<String> results = new ArrayList<String>();
	    for ( int i = 1; i <= (1<<(args.length))-1; i++ ) {
	      StringBuilder builder = new StringBuilder();
	      for ( int j = 0; j < args.length; j++ ) {
	        if ( (i & (1<<j)) != 0) {
	          builder.append(args[j]);
	        }
	      }
	      results.add(builder.toString());
	    }
	    System.out.println( results );
	  }
	  
	  public static void main(String[] args) {
		  SubsequenceProgramsGenerateThem.generateSequence( new String[]{"1","2","3","4"});
	}
}
