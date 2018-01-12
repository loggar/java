package com.loggar.statements;

import java.io.Serializable;

/**
 * A transient data member is not serialized when the class is serialized.
 * It is not part of the persistent state of an object.
 *
 */
public class TransientSample implements Serializable {
	/**
	 * generated serialVersionUID
	 */
	private static final long serialVersionUID = 3952970988710051115L;

	private String firstName;
	private transient String middleName;
	private String lastName;

	public TransientSample(String fName, String mName, String lName) {
		this.firstName = fName;
		this.middleName = mName;
		this.lastName = lName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TransientSample [firstName=").append(firstName).append(", lastName=").append(lastName)
				.append("]");
		builder.append(", middleName(transient)=").append(middleName);
		return builder.toString();
	}
	
}
