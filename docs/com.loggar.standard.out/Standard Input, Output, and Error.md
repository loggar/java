# Standard Input, Output, and Error

## How to redirect output

you can separate the standard output and standard error streams, even though they are both printed out together to the terminal by default. You can also redirect one stream to another.

```
// Redirect standard output to file.txt. Will OVERWRITE output.txt if exists
java MyProgram > output.txt

// Append stdout to file, instead of overwriting
java MyProgram >> output.txt

// Redirect standard error to err.txt
java MyProgram 2> output.txt

// Redirect output to file, and then stderr to stdout. Both will write to file
java MyProgram > output.txt 2>&1

// In Linux, you can redirect all output to /dev/null if you don't want it at all
java MyProgram > /dev/null 2>&1
```

It is also possible to pipe the output of your program directly in to another program. This is done using the pipe character instead of the angle bracket.

```
// Redirect standard output to input another program
java MyProgram | grep "keyword"
```

## How to redirect input

By default, standard input comes from the keyboard. You can instead pass a file as the input. It will pass along the file and the program won't know the difference that it came from a file instead of from the keyboard.

```
// Feed file.txt to MyProgram as standard input
java MyProgram < input.txt
```

Another option is to use the output of another program as the input. This is called piping and is the same example we saw just a moment ago when redirecting output through a pipe, except output program is on the receiving end this time.

```
// Pass stdout of another process as stdin to your program.
cat data_file.txt | java MyProgram
```
