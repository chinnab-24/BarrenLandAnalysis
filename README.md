# BarrenLandAnalysis

Synopsis:
There is a farm of 400m by 600m where coordinates of the field are from (0, 0) to (399, 599). A portion of the farm is barren, and all the barren land is in the form of rectangles. Due to these rectangles of barren land, the remaining area of fertile land is in no particular shape. An area of fertile land is defined as the largest area of land that is not covered by any of the rectangles of barren land. 

Input 
Input is from STDIN. Input is a set of rectangles that contain the barren land. These rectangles are defined in a string, which consists of four integers separated by single spaces, with no additional spaces in the string. The first two integers are the coordinates of the bottom left corner in the given rectangle, and the last two integers are the coordinates of the top right corner. 
Ex: {“48 192 351 207”, “48 392 351 407”, “120 52 135 547”, “260 52 275 547”}  

Output 
Output is printed to STDOUT. Output is all the fertile land area in square meters, sorted from smallest area to greatest, separated by a space. 
Ex: 22816 192608

Technology Stack Used: 
Java: 1.8.0_112 
JUnit 4.10

Prerequisites:
1. Install Java (Version 1.8.0_112 is used)
2. Download code from GIT repository into C drive (C:\BarrenLandAnalysis)

Getting Started:

To run the program from command prompt
1. Open command prompt
2. Type the following commands
	a. cd C:\BarrenLandAnalysis
	b. java -jar runMe.jar
3. Give the input to test the output. 
4. Repeat the command : "java -jar runMe.jar" to test the application multiple times

To run the program from eclipse
1. Open eclipse and point the workspace to C:\BarrenLandAnalysis\BarrenLandAnalysis
2. Open BarrenLandAnalysis.java, right click and select "run as: java application" option 
3. Enter the required input to test the output.

Running the tests:

To run the automated unit test cases
1. Open eclipse and point the workspace to C:\BarrenLandAnalysis\BarrenLandAnalysis
2. Open BarrenLandTestRunner.java, right click and select "run as: java application" option  
3. Alternatively, if you want to see the tests in JUnit view, Open TestBarrenLand.java, right click and select "run as: java JUnit Test" option 

At a high level, below are the test cases written:

testEmptyInput - This test case is to check an empty input
Given Input: {“”}
Expected Output: "240000"
Test Result: PASS

testZeroInput - This test case is to check a single point input
Given Input: {“0 0 0 0”}
Expected Output: "239999"
Test Result: PASS

testEmptyOutput - This test case is to check if the entire area is defined a barren land
Given Input: {“0 0 399 599”}
Expected Output: 
Test Result: PASS

testString1 - This test case is to check a horizontal slice of the area
Given Input: {“0 292 399 307”}
Expected Output: "116800 116800"
Test Result: PASS

testString2 - This test case is to check 2 divided
Given Input: {“48 192 351 207”, “48 392 351 407”, “120 52 135 547”, “260 52 275 547”}
Expected Output: "22816 192608"
Test Result: PASS

testError - This test case is to check if an invalid input is given (a non integer input)
Given Input: Error
Expected Output: Should throw an "Exception"
Test Result: PASS

testErrorArrayOutofBounds - This test case is to check if the input is out of the given area
Given Input: {699 699 699 699}
Expected Output: Should throw an "ArrayIndexOutOfBoundsException"
Test Result: PASS

testSTDIN - This test case is to check the input to be taken from the console

 
