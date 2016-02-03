## java-util

Utility programs:

#### DiffDate.java 
Difference between two dates

#### NoUTF8Char.java 
  - first decode and then delete the "dirty" characters (unknown char, signed like � ) inside the no_UTF8.txt file
  - [From Wikipedia](https://en.wikipedia.org/wiki/Specials_(Unicode_block)):
The replacement character � (often a black diamond with a white question mark) is a symbol found in the Unicode standard at codepoint U+FFFD in the Specials table. It is used to indicate problems when a system is unable to render a stream of data to a correct symbol.

#### ReadWriteFile.java
- read the 3 lines (id, name & surname, email, address) from the address book and save the data into a list of strings
- add another 2 data lines to the address book
- write the new address book into a new file
