package com.loggar.pattern.template_method;

public class TemplateTest {
	public static void main(String[] args) {
		Template t = new SampleTemplate();
		t.t_insert();
		t.t_update();
		t.t_delete();
	}
}
