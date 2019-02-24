**This project is split into 2 modules**

**numbers**

This module contains the src code for the numbers conversion program.

The Module is built using gradle to allow the use of junit 5 as a 3rd party library.

When running the main class NumbersConverter you can either pass the configuration file on the command line as the only arg or provide no args and you will be presented with a File Chooser popup.

**sql**

This module contains the sql portion of the technical test.
The answers can be found under the answers directory and are sql files

A docker directory contains the Dockerfile for creating a test mysql container that contains some test data entries. 
**Note that this Dockerfile has only been tested using Docker for windows utilizing Docker for Windows through HyperV