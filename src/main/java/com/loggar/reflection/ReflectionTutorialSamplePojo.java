package com.loggar.reflection;

public class ReflectionTutorialSamplePojo {
	public String name;
	protected String webAddress;
	public String email;
	protected int zip;

	public ReflectionTutorialSamplePojo() {
		name = "Sample.com";
		webAddress = "http://sample.com";
		email = "test@sample.com";
	}

	// ==========================================================
	// Create a Setters and Getters for all variables
	// ==========================================================

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	protected String getWebAddress() {
		return webAddress;
	}

	protected void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	protected int getZip() {
		return zip;
	}

	protected void setZip(int zip) {
		this.zip = zip;
	}

	public void thisIsSampleReflection() {
		System.out.println("- Hey This is Sample's Refection API tutorials. More than 400 Tutorials on Sample.com");
	}

	// ==========================================================
	// Create a String description of a Sample credentials
	// ==========================================================

	public String toString() {
		String result = "Name: " + getName() + "\n";
		result += "WebAddress: " + getWebAddress() + "\n";
		result += "email: " + getEmail() + "\n";
		result += "zip: " + getZip() + "\n";
		return result;
	}

	public static void main(String[] args) {

		// Create and print a SamplePOJO object ...
		ReflectionTutorialSamplePojo sample = new ReflectionTutorialSamplePojo();
		sample.setName("Sample.com");
		sample.setWebAddress("http://sample.com");
		sample.setEmail("test@sample.com");
		sample.setZip(95124);
		System.out.println(sample);
	}
}
