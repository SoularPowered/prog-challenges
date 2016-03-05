/****************************************************************************
File:          euler1.c
Author:        Shawn S Hillyer
Description:   Project Euler Challenge #1
               If we list all the natural numbers below 10 that are multiples of 
               3 or 5, we get 3, 5, 6, and 9. The sum of these multiples is 23
Usage:         Run program
****************************************************************************/

#include <stdio.h>

int sumMults(int a, int b, int max);

int main(int argc, char* argv[]) {
  
  printf("%d\n\n", sumMults(3, 5, 1000));

  return 0;
}


int sumMults(int a, int b, int max) {
  int sum = 0;
  int i;
  for (i = a; i < max; i += a)
    sum += i;
  for (i = b; i < max; i += b) {
    if (!(i % a == 0))
      sum += i;
  }
  return sum;
}