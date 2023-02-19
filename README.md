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

2. The system will then check if the matrix A is diagonally dominanta and Make the matrix diagonally dominant, if it is not. 

**Description:** A square matrix A is said to be diagonally dominant if the absolute value of its diagonal element in each row is greater than the sum of the absolute value of all other elements in the same row.

![image](https://user-images.githubusercontent.com/74715900/219931672-a4f8485c-243d-488b-bd69-f2ee7410e645.png)

**Hint:** The matrix A is not diagonally-dominant but becomes diagonally-dominant by exchanging the rows. In the example, we bring the row 4 to the first row and shifting all the other rows downward. Note that the vector b is also changed according to their corresponding rows in the matrix A. Therefore, the linear equation in the form of matrix will look like the followings:

![image](https://user-images.githubusercontent.com/74715900/219931741-0e40f336-9170-47a2-8df3-77fa8c5084b0.png)

3. Find the _x_ for each row. 
I have implemented the loop at this step and iteratively calculated the unknown variable _x_ until the Greatest Absolute Value of each unknown _x (Error)_ subtracted by the Greatest Absolute Value from the previous step is smaller than the _epsilon (0.005_. The initial vector _x (at iteration k=0)_ is given as _x-[0,0,0,0]_.

The definition of notations are as follows: 
![image](https://user-images.githubusercontent.com/74715900/219931902-abbd1ecb-1f61-4106-afe3-a5da8a13e25e.png)

