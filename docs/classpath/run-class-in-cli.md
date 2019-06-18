# Run java classes in console

## issue 1

```
Error: Could not find or load main class com.loggar.io.console.ConsoleInputSystemConsole
```

Solve: `-cp`: the classpath option

```
C:\Users\webnl\Documents\_workspace_java\loggar_java\target (master)
$ java com.loggar.io.console.ConsoleInputSystemConsole
Error: Could not find or load main class com.loggar.io.console.ConsoleInputSystemConsole

C:\Users\webnl\Documents\_workspace_java\loggar_java\target (master)
$ java -cp ./classes com.loggar.io.console.ConsoleInputSystemConsole
```