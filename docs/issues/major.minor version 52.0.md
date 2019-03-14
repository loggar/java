# errors when running class

## Unsupported major.minor version 52.0

jvm lib version issue.

The issue is because of Java version mismatch. Referring to the [Wikipedia Java Class Reference](https://en.wikipedia.org/wiki/Java_class_file):

classes compiled with above version of the runtime


1. project facets > java > runtime version check - build the project again in new setting
2. or upgrade/downgrade issued libraries.

### Java version match

* Java SE 12 = 56 (0x38 hex)
* Java SE 11 = 55 (0x37 hex)
* Java SE 10 = 54
* Java SE 9 = 53
* Java SE 8 = 52
* Java SE 7 = 51
* Java SE 6.0 = 50
* Java SE 5.0 = 49
* JDK 1.4 = 48
