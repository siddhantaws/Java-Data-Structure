package com.manh.algo.stringmatch;

public abstract class AbstractStringMatchAlgo implements IStringMatchAlgo
{
	private int prime = 101;
	
	
	public int getPrime() {
		return prime;
	}


	@Override
	public boolean match(char[] text, char[] pattern) 
	{
		throw new UnsupportedOperationException();
	}
}
