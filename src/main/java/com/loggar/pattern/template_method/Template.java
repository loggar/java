package com.loggar.pattern.template_method;

public abstract class Template {
	protected String connection;

	public void setConnection(String driver) {
		this.connection = "CONNECTION";
		System.out.println("CONNECTION from " + driver);
	}

	protected void clear() {
		System.out.println(this.connection + " clear");
		this.connection = null;
	}

	protected abstract void insert();

	protected abstract void update();

	protected abstract void delete();

	protected void t_insert() {
		setConnection("DRIVER");
		insert();
		clear();
	}

	protected void t_update() {
		setConnection("DRIVER");
		update();
		clear();
	}

	protected void t_delete() {
		setConnection("DRIVER");
		delete();
		clear();
	}

}
