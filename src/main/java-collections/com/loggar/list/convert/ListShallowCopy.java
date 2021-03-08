package com.loggar.list.convert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListShallowCopy {
	public static List<Integer> listShallowCopy1(List<Integer> srcList) {
		return new ArrayList<Integer>(srcList);
	}

	public static List<Integer> listShallowCopy2(List<Integer> srcList) {
		ArrayList<Integer> dstList = new ArrayList<Integer>(srcList.size());
		Collections.copy(dstList, srcList);

		return dstList;
	}
}
