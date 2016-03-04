/****************************************************************************
File:          atbash.c
Author:        Shawn S Hillyer
Description:   AtBash Cipher for Arabic Alphabet A-Z
Reference:     https://en.wikipedia.org/wiki/Atbash
Usage:         Provide a string as a commandline argument and program will
               convert to its atbash cipher
Ex input:      atbash wizard
Note:          Need to test, coded blind using windows notepad!
****************************************************************************/

#include <stdio.h>
#include <ctype.h>
#include <string.h>

char convertLetter(char ch);

int main( int argc, char *argv[] ) {
  int BUFFER_SIZE = 100;

  if (argc != 2) {
    printf("usage: %s <word to encode>\n\n", argv[0] ); 
    return 1;
  }

/* How to validate the length of argv[1] isn't too long? Does this work?
  
    int buffer_size = strlen(argv[0];
    char word[buffer_size];
    char newWord[buffer_size};
*/

  else {
    int i = 0;
    char lttr = 0;
    /* Copy the argument into word and make space for newWord*/
    char word[BUFFER_SIZE];
    char newWord[BUFFER_SIZE];
    strcpy(word, argv[1]);

    /* convert word one letter at a time until we reach null terminator */
    while (word[i] != 0) {
      /* Get next letter and convert to cipher */
      lttr = word[i];
      if (isalpha(lttr)) {
        lttr = convertLetter(lttr);      
      }

      /* Copy each letter into the newWord */
      newWord[i++] = lttr;
    }
    newWord[i] = 0;
    
    printf("Converted \'%s\' to \'%s\'\n", argv[1], newWord);
  }

  return 0;  
}

char convertLetter(char ch) {
  /* Set the ascii offset to get 'A' and 'a' to equal 0 */
  int offset;

  if ( isupper(ch) ) {
    offset = 'A'; // 65
  }
  else {
    offset = 'a'; // 97
  }

  ch -= offset;
  ch = 25 - ch + offset;
  return ch;
}