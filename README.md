# linear-equations-calculator
 A medium-complex Java program, that is designed and built for the purpose of Solving a System of Linear Equations. 
 

## Code and Implementation Description

The way this program works is as followed: 

Suppose that you are given a linear equation and you are required to find all the unknown x values as
follow:

![image](https://user-images.githubusercontent.com/74715900/219931443-360a6a07-a7d3-4476-8d9b-79c8cbb35747.png)

A system of linear equations with m equations and n unknowns if and only if n=m is expressed as follows,

![image](https://user-images.githubusercontent.com/74715900/219931455-bfcc966e-b0ab-4cd3-aed4-56359b404279.png)

The above system is represented in matrix form as Ax= b, as follows,

![image](https://user-images.githubusercontent.com/74715900/219931468-eb735462-e7ee-4ec3-9814-4b33ed843b05.png)

To find the unknown variables x the following steps are being accomplished:

1. Convert the linear equation to the matrix format:

![image](https://user-images.githubusercontent.com/74715900/219931502-f42d3964-782c-4d41-863d-96e7e9dd796c.png)

The system takes TWO dimensional array _Matrix A_ and a single dimensional array _Vector X_, and another single dimensional array _Vector b_
