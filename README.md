NOTE: THIS REPOSITORY HAS NOW BEEN ARCHIVED.
# SkraBBKle

## Overview
A text-based Java board game inspired by Scrabble, originally developed as a coursework assignment for my MSc in Computer Science. Designed to demonstrate core Object-Oriented Programming (OOP) principles—such as encapsulation, polymorphism, and inheritance—this project features a configurable board size (S x S) and a functional Computer opponent. Not quite finished yet. Very much a work-in-progress and nostalgic look at my past work...

## Example Output
Below is an example of the game log and board state during a match. The board dynamically updates to show tiles, multipliers, and score tracking.

```text
OPEN GAME: The computer's tiles:
OPEN GAME: [E1], [U1], [D2], [I1], [_3], [I1], [P3]
It's the computer's turn!
The move is:    Word: UPItIED at position 8g
Human player score:    7
Computer player score: 91

    a  b  c  d  e  f  g  h  i  j  k  l  m  n  o  p 

 1  . {12 .  . (2) .  .  . {3} .  .  . (2) .  . {8}  1
 2  .  . {2} .  .  . (3) .  .  . (3) .  .  . {2} .   2
 3  .  .  . {2} .  .  . (2) . (2) .  .  . {2} .  .   3
 4  . (2) .  . {2} .  .  . (2) .  .  . {2} .  . (2)  4
 5  .  .  .  .  . {2} .  .  .  .  . {0} .  .  .  .   5
 6  .  . (3) .  .  . (3)D2  .  . (3) .  .  . (3) .   6
 7  .  .  . (2) .  .  . I1  . (2) .  .  . (2) .  .   7
 8 (3){-3 .  . (2) . U1 N1 P3 I1 t3 I1 E1 D2  . {-2  8
 9  .  .  . (2) .  .  . T1  . (2) .  .  . (2) .  .   9
10  .  . (3) .  .  . (3) .  .  . (3) .  .  . (3) .  10
11  .  .  .  .  . {2} .  .  .  .  . {2} .  .  .  .  11
12  . (2) .  . {-1 .  .  . (0) .  .  . {-1 .  . (2) 12
13  .  .  . {2} .  .  . (2) . (9) .  .  . {2} .  .  13
14  .  . {2} .  .  . (3) .  .  . (3) .  .  . {2} .  14
15  . {9} .  . (2) .  .  . {3} .  .  . (2) .  . {16 15
16  .  .  .  .  .  .  .  . (3) .  .  .  .  .  .  .  16

    a  b  c  d  e  f  g  h  i  j  k  l  m  n  o  p
```
The goal is to populate the board with a grid of tiles to form words from a pre-defined word list.

## Gameplay Features
* **Board Size:** Configurable between 11x11 and 26x26.
* **Players:** Human vs Computer.
* **Mechanics:**
    * Standard Scrabble-like scoring with premium letter and word squares.
    * 7-tile rack, refilled from a bag.
    * First move is always by the human player.
    * Input validation against a provided dictionary (`wordlist.txt`).

## How to Run
1.  **Clone the repository.**
2.  **Compile the Java files:** `javac -d bin src/main/java/pij/main/*.java`
3.  **Run the Main class:** `java -cp bin:src/main/resources pij.main.Main`


## Controls
* **Loading:** Choose between a default board or load a custom board file.
* **Moves:** Enter moves in the format `WORD,POSITION` (e.g., `HELLO,h8`).
* **Wildcards:** Lowercase letters represent wildcards (score of 5).

Not yet finished. Very much a work-in-progress and nostalgic look at my past work.

ENJOY !
