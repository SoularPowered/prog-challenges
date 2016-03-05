/****************************************************************************
File:          eulers.js
Author:        Shawn S Hillyer
Description:   Project Euler Challenge #2
               By considering the terms in the Fibonacci sequence whose values
               do not exceed four million, find the sum of the even-valued terms
****************************************************************************/

// Constants
var MAX_VAL = 4000000;

// Set up an array to is memoization
var fibValues = new Array();
fibValues.push(0);
fibValues.push(1);
fibValues.push(2);

// Returns the nth fibonnaci sequence; fibs[] stores any calculated fibonnaci numbers so far
function fibonacci(n, fibs) {
  if (n == 0)
    return fibs[0];
  if (n == 1)
    return fibs[1];
  if (n == 2)
    return fibs[2];
  else {
    if (fibs[n]) {
      return fibs[n];
    }
    else {
      fibs[n] = fibonacci(n-1, fibs) + fibonacci(n-2, fibs);
      return fibs[n];
    }
  }
}

// Debug purposes
//for (let i = 0; i < 10; i++) {
//  console.log('Fib #' + i + ': ' + fibonacci(i, fibValues));
//}

// Sums the even fibonacci numbers from 1st fibonacci up to and including max fibonacci
function sumEvenFibs(max) {
  var result = 0, sum = 0;
  for (var i = 1; result <= max; i++) {
    result = fibonacci(i, fibValues);
    if (result % 2 == 0 && result <= max)
      sum += result;
  }
  return result;
}

console.log('Sum is ' + sumEvenFibs(MAX_VAL));