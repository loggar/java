# Item 57: Use exceptions only for exceptional conditions

Someday, if you are unlucky, you may stumble across a piece of code that looks something like this:
```
// Horrible abuse of exceptions. Don't ever do this!
try {
int i = 0;
while(true)
range[i++].climb();
} catch(ArrayIndexOutOfBoundsException e) {
}
```
What does this code do? It’s not at all obvious from inspection, and that’s reason enough not to use it (Item 55). It turns out to be a horribly ill-conceived idiom for looping through the elements of an array. The infinite loop terminates by throwing, catching, and ignoring an ArrayIndexOutOfBoundsException when it attempts to access the first array element outside the bounds of the array. It’s supposed to be equivalent to the standard idiom for looping through an array, which is instantly recognizable to any Java programmer:
```
for (Mountain m : range)
m.climb();
```
There are three things wrong with this reasoning:

• Because exceptions are designed for exceptional circumstances, there is little incentive for JVM implementors to make them as fast as explicit tests.

• Placing code inside a try-catch block inhibits certain optimizations that modern JVM implementations might otherwise perform.

• The standard idiom for looping through an array doesn’t necessarily result in redundant checks. Modern JVM implementations optimize them away.

In fact, the exception-based idiom is far slower than the standard one on modern JVM implementations. On my machine, the exception-based idiom is more than twice as slow as the standard one for arrays of one hundred elements.

The moral of this story is simple: exceptions are, as their name implies, to be used only for exceptional conditions; they should never be used for ordinary control flow.

This principle also has implications for API design. A well-designed API must not force its clients to use exceptions for ordinary control flow. A class with a “state-dependent” method that can be invoked only under certain unpredictable conditions should generally have a separate “state-testing” method indicating whether it is appropriate to invoke the state-dependent method. For example, the Iterator interface has the state-dependent method next and the corresponding state-testing method hasNext. This enables the standard idiom for iterating over a collection with a traditional for loop (as well as the for-each loop, where the has-
Next method is used internally):
```
for (Iterator<Foo> i = collection.iterator(); i.hasNext(); ) {
Foo foo = i.next();
...
}
```
If Iterator lacked the hasNext method, clients would be forced to do this instead:
```
// Do not use this hideous code for iteration over a collection!
try {
Iterator<Foo> i = collection.iterator();
while(true) {
Foo foo = i.next();
...
}
} catch (NoSuchElementException e) {
}
```
An alternative to providing a separate state-testing method is to have the statedependent method return a distinguished value such as null if it is invoked with the object in an inappropriate state. This technique would not be appropriate for Iterator, as null is a legitimate return value for the next method.

In summary, exceptions are designed for use in exceptional conditions. Don’t use them for ordinary control flow, and don’t write APIs that force others to do so.


Reference: Effective Java 2nd Edition by Joshua Bloch