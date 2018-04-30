var MyJavaClass = Java.type('com.loggar.scriptengines.js.MyJavaClass');

// call the static method
var greetingResult = MyJavaClass.sayHello('John Doe');
print(greetingResult);

// create a new intance of MyJavaClass
var myClass = new MyJavaClass();
var calcResult = myClass.add(1, 2);
print(calcResult);