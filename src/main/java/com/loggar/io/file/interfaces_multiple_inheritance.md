# Interfaces and Multiple Inheritance

Multiple inheritance is not new to Java. Java has provided multiple inheritance of types since its inception. If we have an object hierarchy implementing various interfaces, there are a few rules help us understand which implementation is applied to the child class. The fundamental rule is that the closest concrete implementation to the subclass wins the inherited behavior over others. The immediate concrete type has the precedence over any others. Take, for example, the following class hierarchy.

```
// Person interface with a concrete implementation of name
interface Person{
  default String getName(){
    return "Person";
  }
}
// Faculty interface extending Person but with its own name implementation
interface Faculty extends Person{
  default public String getName(){
    return "Faculty";
  }
}
```

So, both Person and Faculty interfaces provide default implementation for name. However, note that Faculty extends Person but overrides the behavior to provide its own implementation. For any class that implements both these interfaces, the name is inherited from Faculty as it is the closest subtype to the child class. So, if I have a Student subclass implementing Faculty (and Person), the Student’s getName() method prints the Faculty’s name:

```
// The Student inherits Faculty's name rather than Person
class Student implements Faculty, Person{ .. }

// the getName() prints Faculty
private void test() {
  String name = new Student().getName();
  System.out.println("Name is "+name);
}
output: Name is Faculty
```

However, there’s one important point to note. What happens if our Faculty class does not extend Person at all? In this case, Student class inherits name from both implementations, thus making the compiler moan. To make our compiler happy, in this case, we must provide the concrete implementation by ourselves. However, if you wish to inherit one of the super type’s behaviors, you can do so explicitly, as we see in the code snippet below.

```
interface Person{ .. }

// Notice that the faculty is NOT implementing Person
interface Faculty { .. }

// As there's a conflict, out Student class must explicitly declare whose name it's going to inherit!
class Student implements Faculty, Person{
  @Override
  public String getName() {
    return Person.super.getName();
  }
}
```

There’s a special syntax to obtain the method from a super interface – using super-interface.super.method: Person.super.getName().