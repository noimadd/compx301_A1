# Symbolic long multiplication and addition

- Damion Sklenars-Clare
- 1638052

## Instructions for use
1. Compile: javac StrMath.java
2. Run: java StrMath


## AI usage overview
AI was used throughout development to assist with research, debugging, and verifcation rather than to directly write code for me. I would propose
ideas and approaches using AI to evaluate my decisions and suggest alternatives. This allowed me to make informed decisions throughout the 
design and development process without going down unnecessary rabbit holes.

### Examples
- Researching and comparing approaches e.g. array vs hashmap for lookup tables
- Debugging a small handful of bugs such as a carry bug in StrAdd that was caused by me only checking the initial sum and not also the one that contained the new calculation with the previous carry
- Verifying my code against the specifications to ensure that I had everything

A good example of the debugging usage was when StrAdd was returning 9999 + 11 = 9900. Where after extended attempts to solve this myself, AI identified that when adding the carry to the current sum
the resulting carry from that operation was not checked