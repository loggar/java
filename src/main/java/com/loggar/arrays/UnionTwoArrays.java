package com.loggar.arrays;

import java.util.Arrays;

public class UnionTwoArrays {
	public static void main(String[] args) {
		int[] A = { 4, 11, 2, 1, 3, 3, 5, 7 };
		int[] B = { 5, 2, 3, 15, 1, 0, 9 };
		System.out.println("Integer Array A: " + Arrays.toString(A));
		System.out.println("Integer Array B: " + Arrays.toString(B));

		System.out.println("Union: " + Arrays.toString(findUnion(A, B)));
	}

	/* Union of multiple arrays */
	public static int[] findUnion(int[]... arrays) {
		int maxSize = 0;
		int counter = 0;

		for (int[] array : arrays)
			maxSize += array.length;
		int[] temp = new int[maxSize];

		for (int[] array : arrays)
			for (int i : array)
				if (!findDuplicated(temp, counter, i))
					temp[counter++] = i;

		int[] result = new int[counter];
		for (int i = 0; i < counter; i++)
			result[i] = temp[i];

		return result;
	}

	public static boolean findDuplicated(int[] array, int counter, int value) {
		for (int i = 0; i < counter; i++)
			if (array[i] == value)
				return true;
		return false;
	}
}
