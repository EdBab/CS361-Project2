UTEID: eab2982; dmd2479;
FIRSTNAME: Daniel; Eddie;
LASTNAME: Duncan; Babbe;
CSACCOUNT: dmduncan; babbe99;
EMAIL: daniel.duncan@utexas.edu; babbe2012@utexas.edu;

[Program 2]
[Description]
So, a lot of this is the same as our previous assignment, except for a few minor differences. The main method is now in CovertChannel.java
and that is where the SecureSystem is made along with the reading and writing from files. When a CovertChannel object is made, I send a boolean to the constructor that indicated whether
the vflag was set or not. If so, it will log the instructions needed for the covertchannel to work. Also going to the constructor is the name of the inputfile so I can create the appropriate 
output filename. I read the input in line by line and then character by character I send it to the method charAsByte() which in turn send thats character bit by bit to sendBit(). There, depending on 
whether the bit is a 1 or 0, a series of instructions and calls to the ReferenceMonitor will take place that ensures a bit passes from Hal to Lyle. In the ReferenceMonitor there are now methods for create and destroy, and 
in SecureSubject.java there is now a run method to ensure Lyle's bit of computing takes place(storing of the bit, creating the byte and then printing said byte to the output file).

[Finish]
We have completely finished the assignment.

