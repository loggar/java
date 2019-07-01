## Junit 5

https://junit.org/junit5/docs/current/user-guide/

## Dependencies

Maven

`pom.xml`

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.1.0</version>
    <scope>test</scope>
</dependency>
    <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.1.0</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.junit.vintage</groupId>
    <artifactId>junit-vintage-engine</artifactId>
    <version>5.1.0</version>
    <scope>test</scope>
    </dependency>
<dependency>
    <groupId>org.junit.platform</groupId>
    <artifactId>junit-platform-launcher</artifactId>
    <version>1.1.0</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.junit.platform</groupId>
    <artifactId>junit-platform-runner</artifactId>
    <version>1.1.0</version>
    <scope>test</scope>
</dependency>
```

Gradle

`build.gradle`

```gradle
testCompile group: 'org.junit.jupiter', name: 'junit-jupiter-api', version: '$version'
```

```gradle
buildscript {
    repositories {
        mavenCentral()
        // The following is only necessary if you want to use SNAPSHOT releases.
        // maven { url 'https://oss.sonatype.org/content/repositories/snapshots' }
    }
    dependencies {
        classpath 'org.junit.platform:junit-platform-gradle-plugin:1.0.0'
    }
}

repositories {
    mavenCentral()
}

apply plugin: 'java'
apply plugin: 'eclipse'
apply plugin: 'org.junit.platform.gradle.plugin'

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.0.0")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:5.0.0")
    // to run JUnit 3/4 tests:
    testImplementation("junit:junit:4.12")
    testRuntime("org.junit.vintage:junit-vintage-engine:4.12.0")
}
```

After letting gradle set up your project can then execute your JUnit 5 tests through the terminal:

```
gradle junitPlatformTest
```

If you are using Eclipse it is best to install the Buildship tooling. Then you can start your tests via Run as  Gradle Test. The result of the test execution will be displayed in the Console view.

```
Run > Run As > Gradle Test
```

## An anatomy of unit test

### Before methods

You could note two methods annotated respectively with `@BeforeAll` and `@AfterAll`. What do they do? First method corresponds to Before methods. There are two of them:

- `@BeforeAll`: the static method that will be executed once before all @Test method in the current class.
- `@BeforeEach`: the method that will be executed before each @Test method in the current class.

These methods are handy to setup unit test environment (for example, to create instances).

### After methods

As there are before methods, there are After methods. There is also a couple of them:

- `@AfterAll`: the static method will be executed once after all @Test methods in the current class.
- `@AfterEach`: the method that will be executed after each @Test method in the current class.

## Using standard Assertions API

Assertions API is a collection of utility methods that support asserting conditions in tests. There are numerous available methods, however we would focus on most important of them.

### Assert not null

When we need to assert, that actual object is not null, we can use this method:

```java
assertNotNull(Object obj);
```

If object is not null, the method passes, if not - fails.

### Assert Equals

This group includes many methods, so I would not provide your all overloaded versions, but would focus a general signature:

```java
assertEquals(expected_value, actual_value, optional_message);
```

These methods have two required arguments and one optional argument:

- expected_value = the result, we want to receive
- actual_value = the tested value
- optional_ message = String message, that would be displayed to STDOUT if method is failed.

Values can be of primitive types: int, double, float, long, short, boolean, char, byte, as well Strings and Objects. To this group, we can add these test methods:

- assertArrayEquals - check that expected and actual arrays are equal. Arrays are of primitive types
- AssertFalse and AssertTrue - check that supplied boolean condition is false or true respectively
- assertIterableEquals - same as assertArrayEquals, but for Iterables (e.g. List, Set etc)

As I mentioned, there are many overloaded methods in this section, so it worth to explore official documentation for concrete signatures.

### Assert throws

This is an innovation of JUnit5. Consider, that you have a method that throws an exception:

```java
Car findCarById(String id) throws FailedProviderException;
```

This method retrieves an individual Car from an underlaying database by its ID, and throws FailedProviderException when there is a problem with database. In other words, we wrap in an interface possible data source exceptions (like SQLException or respected for NoSQL databases) and achieve its independence from the implementation.

How do we test that exception is thrown? Before, in JUnit4 we used annotations:

```java
@Test(expected = FailedProviderException.class)
void exceptionThrownTest() throws Exception{
    Car result = repository.findCarById("non-existing-id");
}
```

Btw, same idea is used in TestNG. In JUnit5 was introduced assertThrows method. Take a look, how we would deal with same situation:

```java
@Test
void exceptionThrownTest(){
    Assertions.assertThrows(FailedProviderException.class, ()->{
        Car result = repository.findCarById("non-existing-id");
    });
}
```

This method signature has two components:

1. Expected exception to be thrown
2. Lambda expression of `Executable`, that contains a code snippet, that potentially throws the exception.

### Assert timeout

When we need to assert, that test is finished in a defined timeout, we can use this method:

```java
assertTimeout(Duration timeout, Executable executable)
```

The idea is same as with assertThrows method, but there we specify timeout. Second argument is a same Executable lambda expression. Third optional component is a String message. Let consider an example:

```java
@Test
void in3secondsTest(){
   Assertions.assertTimeout(Duration.ofSeconds(3), ()->{
      //some code
   });
}
```

### fail

Finally, what if we need to fail test? Just use `Assertions.fail()` method. Again, there are several of them:

- fail (String message) = Fails a test with the given failure message.
- fail (String message, Throwable cause) = Fails a test with the given failure message as well as the underlying cause.
- fail (Throwable cause) = Fails a test with the given underlying cause.

## Creating test suites

If you have several unit tests and you want to execute them in one load, you can create a test suite.

This approach allows you to run tests spread into multiple test classes and different packages.

Suppose, that we have tests TestA, TestB, TestC, that divided into three packages: net.mednikov.teststutorial.groupA, net.mednikov.teststutorial.groupA, net.mednikov.teststutorial.groupC respectively. We can write the test suite to combine them:

```java
@RunWith(JUnitPlatform.class)
@SelectPackages({net.mednikov.teststutorial.groupA, net.mednikov.teststutorial.groupB, net.mednikov.teststutorial.groupC})
public class TestSuite(){}
```
