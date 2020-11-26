package com.loggar.resource.bundle;

import java.util.ListResourceBundle;

public class Example_es_ES extends ListResourceBundle {
	static final Object[][] contents = { { "count.one", "Uno" }, { "count.two", "Dos" }, { "count.three", "Tres" }, };

	@Override
	protected Object[][] getContents() {
		return contents;
	}

}
