package com.loggar.java.effective;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * return empty collection not null.
 * @author loggar.lee
 *
 */
public class _15_ReturnEmptyCollection {
	class Cheese {
		int stock = 0;
		
		int getStock() { return this.stock; }
	}
	
	List<Cheese> getSomeList() {
		Cheese c = new Cheese();
		int c_stock = c.getStock();
		
		if(c_stock < 1) {
			return Collections.emptyList();
		}
		
		return new ArrayList<Cheese>(c_stock);
	}
}
