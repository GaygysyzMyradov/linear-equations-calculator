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

2. The system will then check if the matrix A is diagonally dominant and Make the matrix diagonally dominant, if it is not. 

**Description:** A square matrix A is said to be diagonally dominant if the absolute value of its diagonal element in each row is greater than the sum of the absolute value of all other elements in the same row.

![image](https://user-images.githubusercontent.com/74715900/219931672-a4f8485c-243d-488b-bd69-f2ee7410e645.png)

**Hint:** The matrix A is not diagonally-dominant but becomes diagonally-dominant by exchanging the rows. In the example, we bring the row 4 to the first row and shifting all the other rows downward. Note that the vector b is also changed according to their corresponding rows in the matrix A. Therefore, the linear equation in the form of matrix will look like the followings:

![image](https://user-images.githubusercontent.com/74715900/219931741-0e40f336-9170-47a2-8df3-77fa8c5084b0.png)

3. Find the _x_ for each row. 
I have implemented the loop at this step and iteratively calculated the unknown variable _x_ until the Greatest Absolute Value of each unknown _x (Error)_ subtracted by the Greatest Absolute Value from the previous step is smaller than the _epsilon (0.005_. The initial vector _x (at iteration k=0)_ is given as _x-[0,0,0,0]_.

The definition of notations are as follows: 

![image](https://user-images.githubusercontent.com/74715900/219931902-abbd1ecb-1f61-4106-afe3-a5da8a13e25e.png)

The variable _X𝑟 (x for each row)_ at each iteration _k_, is written in terms of other variables as follows:

![image](https://user-images.githubusercontent.com/74715900/219931984-b6135971-4d32-43fe-bf1a-ba9ea868cc0b.png)

Where _i_ and _j_ is the index of row and column at each iteration.

The initial vector x is given as _x= [0, 0, 0, 0]_=> _𝑥1 = 0, 𝑥2 = 0, 𝑥3 = 0, 𝑥4 = 0._

Formula for calculating the unknown x:

![image](https://user-images.githubusercontent.com/74715900/219932009-81163cdc-5f1e-40a6-bef9-e7e66ad5a863.png)

General formula:

![image](https://user-images.githubusercontent.com/74715900/219932017-43c92ec4-355e-40cb-9825-c6069e05601c.png)

**Example:**

When _k=0_:

![image](https://user-images.githubusercontent.com/74715900/219932030-1d46ce1d-070a-4902-a765-098afe8fde52.png)

The error is greater than the tolerance. Therefore, the iterations continue with k=1. Continuing the iteration produces the results as shown in table below.

![image](https://user-images.githubusercontent.com/74715900/219932050-d373271a-9c60-4cc7-a00b-fc4f4727d96f.png)

The pseudocode of the algorithm is as follows:

![image](https://user-images.githubusercontent.com/74715900/219932058-ec4f0fc3-6c92-42cb-b226-de24cdb7e66d.png)

***
## Build Instructions

1. Make sure you have successfully installed the Latest Version of Java JDK. You may download it [_here_](https://www.oracle.com/my/java/technologies/downloads/).
2. Download the Repo source code files. 
3. If you have completed the above steps correctly, then you should be able to run it successfully. 

***

**[NOTE]**

All the comments and the explaination of the Methods and the Classes has been added to the source code. 

***

## _Demo_
- Getting Dimensions (Success):
- 
![image](https://user-images.githubusercontent.com/74715900/219932523-20ae7da2-755a-4472-afe8-548d8bf1cb36.png)

- Getting Dimensions (Unsuccessful):
- 
![image](https://user-images.githubusercontent.com/74715900/219932527-1611e1b4-148d-4d8a-9d0b-002423c90d1f.png)

- Getting Elements of Matrix, A and Vector B:
- 
![image](https://user-images.githubusercontent.com/74715900/219932530-5dbc9617-ab83-42dd-837d-3af129e4c4c5.png)

- Checking Diagonal Dominance (Diagonally Dominant):
- 
![image](https://user-images.githubusercontent.com/74715900/219932534-d3d49e78-fc30-4023-9b22-2bd1e5ceacbc.png)

- Checking Diagonal Dominance (Not Diagonally Dominant & Dominance is Possible):
- 
![image](https://user-images.githubusercontent.com/74715900/219932536-bd1c6029-94a2-4878-954f-0c3e960ae1e3.png)

- Checking Diagonal Dominance (Not Diagonally Dominant & Dominance is Impossible):
- 
![image](https://user-images.githubusercontent.com/74715900/219932541-dc1a5aca-8c5d-49c2-8eb1-4904f95dbac6.png)


***

If you have suggestions, please feel free to contribute, looking forward to practice and learn more. Thanks!

