package com.loggar.bundle.sample;

import java.util.ListResourceBundle;

public class Example_en_US extends ListResourceBundle {
	static final Object[][] contents = { { "count.one", "One" }, { "count.two", "Two" }, { "count.three", "Three" }, };

	@Override
	protected Object[][] getContents() {
		return contents;
	}

}
