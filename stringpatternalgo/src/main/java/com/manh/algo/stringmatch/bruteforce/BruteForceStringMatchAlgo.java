package com.manh.algo.stringmatch.bruteforce;

import com.manh.algo.stringmatch.AbstractStringMatchAlgo;

public class BruteForceStringMatchAlgo extends AbstractStringMatchAlgo
{
	@Override
	public boolean match(char[] text, char[] pattern) 
	{
		for(int i=0 ;i<text.length- pattern.length;i++)
		{
			int j=0;
			while(pattern[j]==text[i+j])
			{
				j++;
				if(j==pattern.length) 
					return true ;
			}	
		}
		return false;
	}
}
