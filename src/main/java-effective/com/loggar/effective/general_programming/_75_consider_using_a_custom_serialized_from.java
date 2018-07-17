package com.loggar.effective.general_programming;

public class _75_consider_using_a_custom_serialized_from {
	/**
	 * Last name. Must be non-null.
	 * 
	 * @serial
	 */
	private String lastName;
	/**
	 * First name. Must be non-null.
	 * 
	 * @serial
	 */
	private String firstName;
	/**
	 * Middle name, or null if there is none.
	 * 
	 * @serial
	 */
	private String middleName;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("_75_consider_using_a_custom_serialized_from [lastName=").append(lastName).append(", firstName=")
				.append(firstName).append(", middleName=").append(middleName).append("]");
		return builder.toString();
	}
}
