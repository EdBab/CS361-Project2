UTEID: eab2982; dmd2479;
FIRSTNAME: Daniel; Eddie;
LASTNAME: Duncan; Babbe;
CSACCOUNT: dmduncan; babbe99;
EMAIL: daniel.duncan@utexas.edu; babbe2012@utexas.edu;

[Program 2]
[Description]
So, a lot of this is the same as our previous assignment, except for a few minor differences. The main method is now in CovertChannel.java
and that is where the SecureSystem is made along with the reading and writing from files. When a CovertChannel object is made, we send a boolean to the constructor that indicated whether
the vflag was set or not. If so, it will log the instructions needed for the covertchannel to work. Also going to the constructor is the name of the inputfile so I can create the appropriate 
output filename. We read the input in line by line and then we access that string character by character and create a new Binary String representation of that character with the Integer.toBinaryString() method.
Then, we access that binary string bit by bit, determine if it is a 1 or 0, and then take the appropriate action to ensure Hal pushes that bit to Lyle below him. PrintWriters are used for both the log file and .out file. 
The .out file is identical to the input file and the log file shows which steps are needed to ensure the bit is passed over the channel.  
The program can be compiled and ran from the terminal as the directions specified and desired.

[Finish]
We have completely finished the assignment.

[Test Cases]
I am using one of the CS lab machines on the third floor and my cpu is running at 1600 Mhz
[Test 1]
Children Of Dune 870,083 bytes 1150 bits/ms
test case is in ChildrenOfDune.txt
[Test 2]
R.A.SALVATORE -THE HUNTER'S BLADES TRILOGY	659,577 bytes 1114 bits/ms
test case is in HunterBlade.txt

[Test 3]
Test 3,466,144 bytes  1206 bits/ms
test case is in Test.txt
