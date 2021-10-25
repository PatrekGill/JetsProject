# Jets Project

## Description
A Java console application that lets one "manage" an airfield with jets & pilots. Demonstrates practice of Object Oriented Programming.

## Operation
Download the project and build and run it. When the application starts it will parse information from the `jets.txt` & `pilot_names.txt` to initialize the program with some starter info. `JetsApplication.java` is the location of the only main method and where the program starts. The primary logic is located in the `AirfieldMainMenu.java`.

You'll be presented with a main menu that has several options. Of note is the `Save jets to file` option. It allows you to enter a custom filename to save the current airfield's jet information in the same format that is in `jets.txt`. The file will save in the root directory of the project (same as `jets.txt` & `pilot_names.txt`).

## Technologies Used
Java 1.8, MAC OS, Eclipse IDE, Bash Terminal, and git

## What I Learned
- A bit more about how packages can be used to organize Java projects.
- How to create a file and write lines with the Scanner to it.
- How one can use custom parameter types with abstract classes.

## What I Could Do Better
- **Better Abstraction**: I feel as though I didn't manage it as well as I could have specifically on the menu system (albeit I have limited OO experience to base this on). Even with planning, my desire to reuse assets seems to lead to maybe more classes then I think are appropriate and a heavy reliance on abstract classes in particular rather then interfaces. Perhaps a better package structure can help make this seem less unruly.