package com.manh.arrays;

public class FindSortedSubsequencesize3LinearTime {
	private static int arr[] = {12, 11, 5, 6, 7 ,  1};

	public static void main(String[] args) 
	{
		TripleletSet set=new TripleletSet();
		System.out.println(set.findTriplet3(arr));
	}

	private static class TripleletSet {
		private int i = -1, j = -1, k = -1;

		public int getI() {
			return i;
		}

		public int getJ() {
			return j;
		}

		public int getK() {
			return k;
		}

		public boolean findTriplet3(int input[]) {
			return input.length <= 2 ? false : findSortedSubsequenceOfSize3(input);
		}

		private boolean findSortedSubsequenceOfSize3(int input[]) {

			boolean isJFound = false;
			int tempItem = -1;
			int iItem = -1;
			int jItem = -1;

			// let first is tempI
			tempItem = input[0];

			// for rest of the elements
			for (int i = 1; i < input.length; i++) {

				// does current element is for I
				if (input[i] < tempItem) {
					// System.out.println(k + " " + i );
					tempItem = input[i];
				} else if (input[i] == tempItem)
					continue;
				else if (!isJFound || input[i] < jItem) {
					iItem = tempItem;
					jItem = input[i];
					isJFound = true;
				} else {
					this.i = iItem;
					this.j = jItem;
					this.k = input[i];
					// System.out.println(k + " " + i );
					break;
				}

			}

			return hasFound();
		}

		private boolean hasFound() {
			return !(i == -1 || j == -1 || k == -1);
		}

		public void refresh() {
			i = j = k = -1;
		}
	}
}
