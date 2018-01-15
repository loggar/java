# Item 63: Include failure-capture information in detail messages

When a program fails due to an uncaught exception, the system automatically prints out the exception’s stack trace. The stack trace contains the exception’s string representation, the result of invoking its toString method. This typically consists of the exception’s class name followed by its detail message. Frequently this is the only information that programmers or field service personnel will have when investigating a software failure. If the failure is not easily reproducible, it may be difficult or impossible to get any more information. Therefore, it is critically important that the exception’s toString method return as much information as possible concerning the cause of the failure. In other words, the detail message of an exception should capture the failure for subsequent analysis.

To capture the failure, the detail message of an exception should contain the values of all parameters and fields that “contributed to the exception.” For example, the detail message of an IndexOutOfBoundsException should contain the lower bound, the upper bound, and the index value that failed to lie between the bounds.

The detail message of an exception should not be confused with a user-level error message, which must be intelligible to end users. Unlike a user-level error message, it is primarily for the benefit of programmers or field service personnel for use when analyzing a failure. Therefore, information content is far more important than intelligibility.

One way to ensure that exceptions contain adequate failure-capture information in their detail messages is to require this information in their constructors instead of a string detail message. The detail message can then be generated automatically to include the information. For example, instead of a String constructor, IndexOutOfBoundsException could have had a constructor that looks like this:
```
/**
* Construct an IndexOutOfBoundsException.
*
* @param lowerBound the lowest legal index value.
* @param upperBound the highest legal index value plus one.
* @param index the actual index value.
*/
public IndexOutOfBoundsException(int lowerBound, int upperBound,
int index) {
// Generate a detail message that captures the failure
super("Lower bound: " + lowerBound +
", Upper bound: " + upperBound +
", Index: " + index);
// Save failure information for programmatic access
this.lowerBound = lowerBound;
this.upperBound = upperBound;
this.index = index;
}
```
Unfortunately, the Java platform libraries do not make heavy use of this idiom, but it is highly recommended. It makes it easy for the programmer throwing an exception to capture the failure.

As suggested in Item 58, it may be appropriate for an exception to provide accessor methods for its failure-capture information (lowerBound, upperBound, and index in the above example). It is more important to provide such accessor methods on checked exceptions than on unchecked exceptions, because the failure- capture information could be useful in recovering from the failure. It is rare (although not inconceivable) that a programmer might want programmatic access to the details of an unchecked exception. Even for unchecked exceptions, however, it seems advisable to provide these accessors on general principle (Item 10).


Reference: Effective Java 2nd Edition by Joshua Bloch