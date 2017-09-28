# CircleMaster

<a href="https://imgur.com/c1VLtLT"><img src="https://i.imgur.com/c1VLtLT.png" title="source: imgur.com" /></a>

## Overview
This project was completed as part of a Data Structures and Algorithms class. My prompt was to write a program that draws 20 circles
with random size and location. If any circles overlap, they are to be filled with cyan. Otherwise, they are filled with black. See my 
powerpoint presentation for an in-depth look at my application and the classes it features.

To run the program, open command-line and, from the root directory, type in: java -jar build\libs\CircleMaster-1.0.jar [# of circles] [width of window] [height of window]

For a frame with 20 circles, width = 500, and height = 600: java -jar build\libs\CircleMaster-1.0.jar 20 500 600

## Additional Features

Three additional features can be found in the options menu:

1. "Draw New Circles" - randomly generates new circles on the JPanel.
2. "Open Documentation" - opens the application's associated JavaDoc documentation 
3. "Open Coverage Report" - opens the application's associated JacocoTestReport. Jacoco anaylzes the project's code coverage given by the 
JUnit tests.
