package org.anveshgadde.multidimensionalarrays;

public class MultiDimeArr {

	public static void main(String[] args) {

		int[][] numArray = { { 1, 2, 3 }, { 74, 215, 12536 } };

		int[][] secArray = { { 11, 25, 44 }, { 3, 2, 1 } };

		int[][] resArray = new int[3][3];

		for (int i = 0; i < numArray.length + 1; i++) {
			for (int j = 0; j < secArray.length + 1; j++) {
				resArray[i][j] = numArray[i][j] + secArray[i][j];

				System.out.println(resArray[i][j] + " array element values!");
			}
			System.out.println(System.getProperty("line.separator"));
		}

	}

}