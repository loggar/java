# Hamcrest

Hamcrest is not embedded in JUnit 4.12, instead you'll need to include the separate Hamcrest library on your classpath.

## Maven

```xml
<dependency>
    <groupId>org.hamcrest</groupId>
    <artifactId>hamcrest-library</artifactId>
    <version>1.3</version>
</dependency> 
```

In case you only need it for UnitTests you can use following dependency (works with JUnit5 as well):

```xml
<dependency>
    <groupId>org.hamcrest</groupId>
    <artifactId>hamcrest-junit</artifactId>
    <version>2.0.0.0</version>
S</dependency>
```
