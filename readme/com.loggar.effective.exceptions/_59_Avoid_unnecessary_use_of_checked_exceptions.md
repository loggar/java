# Item 59: Avoid unnecessary use of checked exceptions

Checked exceptions are a wonderful feature of the Java programming language. Unlike return codes, they force the programmer to deal with exceptional conditions, greatly enhancing reliability. That said, overuse of checked exceptions can make an API far less pleasant to use. If a method throws one or more checked exceptions, the code that invokes the method must handle the exceptions in one or more catch blocks, or it must declare that it throws the exceptions and let them propagate outward. Either way, it places a nontrivial burden on the programmer.

The burden is justified if the exceptional condition cannot be prevented by proper use of the API and the programmer using the API can take some useful action once confronted with the exception. Unless both of these conditions hold, an unchecked exception is more appropriate.
Is this the best that can be done?
```
} catch(TheCheckedException e) {
throw new AssertionError(); // Can't happen!
}
```
How about this?
```
} catch(TheCheckedException e) {
e.printStackTrace(); // Oh well, we lose.
System.exit(1);
}
```
If the programmer using the API can do no better, an unchecked exception would be more appropriate. One example of an exception that fails this test is CloneNotSupportedException. It is thrown by Object.clone, which should be invoked only on objects that implement Cloneable (Item 11). In practice, the catch block almost always has the character of an assertion failure. The checked nature of the exception provides no benefit to the programmer, but it requires effort and complicates programs.

The additional burden on the programmer caused by a checked exception is substantially higher if it is the sole checked exception thrown by a method. If there are others, the method must already appear in a try block, and this exception merely requires another catch block. If a method throws a single checked exception, this exception alone is responsible for the fact that the method must appear in a try block. Under these circumstances, it pays to ask yourself whether there isn’t some way to avoid the checked exception.

One technique for turning a checked exception into an unchecked exception is to break the method that throws the exception into two methods, the first of which returns a boolean that indicates whether the exception would be thrown. This API refactoring transforms the calling sequence from this:
```
// Invocation with checked exception
try {
obj.action(args);
} catch(TheCheckedException e) {
// Handle exceptional condition
...
}
```
to this:
```
// Invocation with state-testing method and unchecked exception
if (obj.actionPermitted(args)) {
obj.action(args);
} else {
// Handle exceptional condition
...
}
```
This refactoring is not always appropriate, but where it is appropriate, it can make an API more pleasant to use. While the latter calling sequence is no prettier than the former, the resulting API is more flexible. In cases where the programmer knows the call will succeed or is content to let the thread terminate if the call fails, the refactoring also allows this simple calling sequence:
```
obj.action(args);
```
If you suspect that the simple calling sequence will be the norm, then this API refactoring may be appropriate. The API resulting from this refactoring is essentially identical to the state-testing method API in Item 57 and the same caveats apply: if an object is to be accessed concurrently without external synchronization or it is subject to externally induced state transitions, this refactoring is inappropriate, as the object’s state may change between the invocations of actionPermitted and action. If a separate actionPermitted method would, of necessity, duplicate the work of the action method, the refactoring may be ruled out by performance concerns.


Reference: Effective Java 2nd Edition by Joshua Bloch