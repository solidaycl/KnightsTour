# A Knights Tour

This is my solution to the Knights Tour problem.

#### Description: 
Place a knight on an 8x8 chess board.
Move the knight 63 more times so that the knight visits all the spaces on the board without visiting the same space twice. 

## Naive Solution

The Naive approach is a depth first search of each possible move while keeping track of spaces that the knight has visited. Here we list the number of attempts that the knight took to reach all 64 spaces without repeating.

A TIMEOUT occurs when the algorithm takes > 10,000,000 attempts to complete.

|0|1|2|3|4|5|6|7|
| --- | --- | --- | --- | --- | --- | --- | --- |
|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|
|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|
|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|
|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|
|TIMEOUT|TIMEOUT|633264|TIMEOUT|181476|TIMEOUT|TIMEOUT|TIMEOUT|
|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|
|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|
|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|TIMEOUT|

## Fast Solution

The Fast solution works by setting a priority to each space on the board. The priority is the number of possible moves to move into that space. The knight moves into spaces where priority is the highest (smallest number of possible moves). The knight marks this space as played then decrements the priority of all possible moves surrounding the knight. Here are the results for each of the starting positions, the shortest possible number of attempts for the algorithm to complete is 64.   


|0|1|2|3|4|5|6|7|
| --- | --- | --- | --- | --- | --- | --- | --- |
|64|64|64|64|64|64|64|64|
|64|64|64|64|64|64|64|64|
|64|64|64|64|64|64|64|64|
|64|64|64|64|64|64|64|64|
|64|64|117|64|64|64|64|64|
|64|64|64|64|64|64|64|64|
|64|64|64|64|64|64|64|64|
|64|64|74|64|64|64|64|64|

## Super Fast Solution

After looking at the fast solution results, we can see that the algorithm only had 2 start positions which did not solve in the shortest possible number of attempts. Notice how they are asymmetrical and this should be a symmetrical problem. This tells us that if one portion of board can be solved in the shortest possible attempts then theoretically the other side should too. 

The Super Fast Solution works like the Fast Solution, except that when the there are two possible moves with the same priority, the knight moves toward the nearest corner where it started. This way, the algorithm will attempt to fill the quadrant it started in first. Modifying the algorithm this way makes our results symmetrical and we are able to solve all start positions in the shortest possible number of moves.


|0|1|2|3|4|5|6|7|
| --- | --- | --- | --- | --- | --- | --- | --- |
|64|64|64|64|64|64|64|64|
|64|64|64|64|64|64|64|64|
|64|64|64|64|64|64|64|64|
|64|64|64|64|64|64|64|64|
|64|64|64|64|64|64|64|64|
|64|64|64|64|64|64|64|64|
|64|64|64|64|64|64|64|64|
|64|64|64|64|64|64|64|64|

