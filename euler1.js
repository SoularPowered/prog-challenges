/* Author:           Shawn Hillyer 
 * Project Euler 1:  Multiples of 3 and 5
 * Description:      If we list all the natural numbers below 10 that are multiples of 
 *                   3 or 5, we get 3, 5, 6, and 9. The sum of these multiples is 23
 *
 * Goal:             Find the sum of all the multiples of 3 or 5 below 1000.
 */

// BRUTE FORCE
var MULT_A = 3;
var MULT_B = 5;
var MAX = 1000;

function bruteForce(size) {
  var sum = 0;
  for (var i = 3; i < size; i++) {
    if (i % (MULT_A * MULT_B) == 0 || i % MULT_A == 0 || i % MULT_B == 0)
      sum += i;
  }
  return sum;
}

console.log(bruteForce(MAX));

function elegant(size) {
  var sum = 0;
  for (var i = MULT_A; i < size; i += MULT_A)
    sum += i;
  for (i = MULT_B; i < size; i += MULT_B) {
    if (!(i % MULT_A == 0))
      sum += i;
  }
  return sum;
}

console.log(elegant(MAX));