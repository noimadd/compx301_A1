# Symbolic long multiplication and addition

You are to write a java class called StrMath.java that supports three public methods: StrAdd(), StrMult() and StrFact() which carry out arithmetic operations of addition, multiplication and factorial, respectively, on unsigned integers (i.e. whole numbers) given as string arguments.  All arithmetic is to be done symbolically, operating on strings without using any java arithmetic operations.  The algorithms of long addition and long multiplication are to be used, and factorial should make use of your StrMult() function.

## Specification

1. public static String StrAdd(String a, String b); checks that a and b are strings matching [0-9]+ and returns a string equivalent to what would come back from Integer.toString(Integer.parseInt(a) + Integer.parseInt(b)) without a maximum integer restriction


2. public static String StrMult(String a, String b); checks that a and b are strings matching [0-9]+ and returns a string equivalent to Integer.toString(Integer.parseInt(a) * Integer.parseInt(b)) but without a maximum integer restriction


3. public static String StrFact(String a); checks a is a string matching [0-9]+ and returns a string equivalent to the factorial of Integer.parseInt(a) if maxint did not exist.


4. All results and intermediate results must be java strings, and no java arithmetic operators can be used on the arguments or any part of the arguments. Thus, in principle, there should be no chance of an overlow limiting the maximum result


5. StrAdd must follow the long addition method


6. StrMult must follow the long multiplication method


7. private methods to add two single digits, possibly also adding a carry-in, are probably useful, and can accept chars or strings for the digits, but must still return a String


8. private methods to multiply two single digits, possibly adding a carry-in, are also probably useful, and can accept chars or strings for the digits, but must still return a String


9. private lookup tables of any sort **(e.g. arrays, hashing, etc)** might be useful for quickly finding the sum or product of two digits


10. a successor and/or predecessor method for a single digit can be included if useful, provided it accepts a string or char and returns a String and does not use java arithmetic operations on an int holding any part of the value of the argument.


11. shortcuts for things like adding 0 to anything or multiplying anything by 0 or 1 **(rather than carrying out the long operations)** are encouraged, and a method to trim off leading 0's may also be useful to avoid unnecessary operations.


12. the class file should have useful header documentation that includes a description of what the class does, and includes the name(s) of the author(s) and the date of last modification


13. every public method should have comments describing its function, inputs and outputs, basic algorithm, and any limitations or errors.  private methods should generally have some comment about what they do to support future maintenance/modification


14. a test file will be made available via Moodle


15. before submission, make sure your code compiles and runs on a linux machine in the R Block labs.


### Submission

Submit a compressed folder containing your class src code **(no compiled code)** and a README.txt file with instructions on how to use your code and any other information you want the marker to know about.  You may include your own test program in the folder **(not required)**, but make sure instructions for use and any expectations are outlined in your README.  Most importantly, make sure you include the author/student name and ID number in the header documentation of each class code **(only expecting one class)**, and in the README.  If AI is used, include a statement or two as to how and to what extent.  Incorporating AI does not affect your mark, but students are encouraged to do as much as they can without it so as to maximise the learning experience.  

Your folder name should be your student ID number!!