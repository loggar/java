# Interfaces Method References

In a lambda expression, when we are calling an already existing method of an existing class or super class, method and class references come in handy. These are new utility features introduced in Java 8 in order to represent lambdas even more concisely and succinctly. Method references are shortcuts for calling existing methods. For example, take a class that has already a method that adds up two integers:

```
public class AddableTest {
  // Add given two integers
  private int addThemUp(int i1, int i2){
    return i1+i2;
}
```

Because the method of adding the integers already exists, there’s no point of creating a lambda expression doing exactly the same. Hence, we refer to this existing method via a method reference (using double colon ::), when create a lambda for IAddable implementation:

```
public class AddableTest {
  // Lambda expression using existing method
  IAddable addableViaMethodReference = this::addThemUp;

  // Add given two integers
  private int addThemUp(int i1, int i2){
    return i1+i2;
  }
}
```

Notice the this::addThemUp lambda expression in the code above. The this refers to an instance of the AddableTest class while the bit after the double colon is the call to pre-existing method. Also, take a note that the method reference doesn’t add the braces () at the end. Should you have another class that implements desired functionality via a static method, you can simply use its method in a lambda expression by using this feature of method references. See the example given below:

```
// Class that provides the functionality via it's static method
public class AddableUtil {
  public static int addThemUp(int i1, int i2){
    return i1+i2;
  }
}

// Test class
public class AddableTest {
  // Lambda expression using static method on a separate class
  IAddable addableViaMethodReference = AddableUtil::addThemUp;
  ...
}
```

We can also use a constructor reference by simply calling the class’s constructor as Employee::new or Trade::new.