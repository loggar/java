package com.loggar.functional.interfaces;

public class Trade {
	String status;
	String issuer;
	int quantity;

	public Trade(String status, String issuer, int quantity) {
		super();
		this.status = status;
		this.issuer = issuer;
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public String getIssuer() {
		return issuer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
