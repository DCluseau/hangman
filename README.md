# The hangman game

The goal of this exercise is to create a program that allows a user to play Hangman, that is, to guess a word by allowing them to suggest letters one by one, with a limited number of possible errors.
For this version, we consider the 10th error to result in a Game Over.

## First step
You will use a predefined list of words of your choice; choose simple words that aren't too long. At the start of the game, a random word will be chosen (and the user must not know which one). Then, a number of dashes equal to the number of letters in the word will be displayed.

## Second step
The user is asked to enter a letter. If the letter is in the word, it is revealed in its correct position(s) on our dashed display. If the entire word is revealed, the game is won.
If the letter is not in the word, the user is informed of the number of errors remaining before Game Over. If 10 errors are reached, a message is displayed to warn the user, the word is revealed, and the program stops.
This step must be repeated until the user finds the word, or until they lose.

## Third step
After thoroughly testing our game, ensuring it works with a variety of words, and confirming its robustness, we can improve it:
On each turn, display the list of letters already suggested by the player that are not in the word.
