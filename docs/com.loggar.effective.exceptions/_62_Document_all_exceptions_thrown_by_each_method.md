# Item 62: Document all exceptions thrown by each method

A description of the exceptions thrown by a method is an important part of the documentation required to use the method properly. Therefore, it is critically important that you take the time to carefully document all of the exceptions thrown by each method.

Always declare checked exceptions individually, and document precisely the conditions under which each one is thrown using the Javadoc @throws tag.

It is particularly important that methods in interfaces document the unchecked exceptions they may throw. This documentation forms a part of the interface’s general contract and enables common behavior among multiple implementations of the interface.

Use the Javadoc @throws tag to document each unchecked exception that a method can throw, but do not use the throws keyword to include unchecked exceptions in the method declaration.

If an exception is thrown by many methods in a class for the same reason, it is acceptable to document the exception in the class’s documentation comment rather than documenting it individually for each method. A common example is NullPointerException. It is fine for a class’s documentation comment to say, “All methods in this class throw a NullPointerException if a null object reference is passed in any parameter,” or words to that effect.

In summary, document every exception that can be thrown by each method that you write. This is true for unchecked as well as checked exceptions, and for abstract as well as concrete methods. Provide individual throws clauses for each checked exception and do not provide throws clauses for unchecked exceptions. If you fail to document the exceptions that your methods can throw, it will be difficult or impossible for others to make effective use of your classes and interfaces.


Reference: Effective Java 2nd Edition by Joshua Bloch