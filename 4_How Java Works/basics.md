
JDK : java development kit 

JVM : Java virtual Machine
JRE : Java runtime environment

JRE provide extra library of Application 

----------------------------------------------

JDK contains -> JRE contains -> JVM 

------------------------------------------------

JVM : we have multiples resources 

Heap memory : Objects/instance variables go in Heap memory.

Stack memory : Method stacks are created in Stack memory. All the local variables of method will be in this method stack

There exist also main stack, which contain reference of all objects.

* we can call static variable directly like className.VariableName.


* For every class in java file, JVM create seaparate class file.  These class file are also called bytecode, and these run on JVM.


file.java -> compiler -> file.class -> JVM(run byteCode)

bytecode run on JVM. Java is platform independent, everywhere JVM exist, we can run the java file.
--- That's why java is called plaform independent. ----

(Machine should support JVM)

------------------------------------------



