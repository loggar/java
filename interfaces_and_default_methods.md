# Functional Interfaces and Default Methods

The journey of a Java library begins with a simple interface. Over time, these libraries are expected to evolve and grow in functionality. However, pre-Java 8 interfaces are untouchable! Once they are defined and declared, they are practically written in stone. For obvious reasons, backward compatibility being the biggest one, they cannot be changed after the fact. While it’s great that lambdas have been added to the language, there’s no point of having them if they cannot be used with existing APIs. In order to add support to absorb lambdas into our libraries, the interfaces needed to evolve. That is, we need to be able to add additional functionality to an already published API. The dilemma is how to embrace lambdas to create or enhance the APIs without losing backward compatibility? This requirement pushed Java designers to come up with yet another elegant feature – providing virtual extension methods or simply default methods to the interfaces. This means we can create concrete methods in our interfaces going forward. The virtual methods allow us to add newer functionality too. The collections API is one such example, where bringing lambdas into the equation has overhauled and enhanced the APIs. Let us walk through a simple example to demonstrate the default method functionality. Let’s assume that every component is said to have a name and creation date when instantiated. However, should the implementation doesn’t provide concrete implementation for the name and creation date, they would be inherited from the interface by default. For out example, the IComponent interface defines a set of default methods as shown below:

```
@FunctionalInterface
public interface IComponent {

  // Functional method - note we must have one of these functional methods only
  public void init();

  // default method - note the keyword default
  default String getComponentName(){
    return "DEFAULT NAME";
  }
  // default method - note the keyword default
  default Date getCreationDate(){
    return new Date();
  }
}
```

As you can see from the snippet above, the interfaces now have an implementation rather than just being abstract. The methods are prefixed with a keyword default to indicate them as the default methods.