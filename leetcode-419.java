/* 
419. Battleships in a Board
Given an 2D board, count how many different battleships are in it. 
The battleships are represented with 'X's, empty slots are represented with '.'s. 
You may assume the following rules: 
*You receive a valid board, made of only battleships or empty slots.
*Battleships can only be placed horizontally or vertically. 
 In other words, they can only be made of the shape 1xN (1 row, N columns) 
 or Nx1 (N rows, 1 column), where N can be of any size.
*At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.

Example: 

X..X
...X
...X

bigg example:

  0123456789AB
0 x.......x.xx
1 x.....x.....
2 ...xxx.....x
3 ..x...xxxxx.
4 ..x.........
5 ..x.........
*/



public class Solution {
    public int countBattleships(char[][] board) {
		// Initialize a 2d boolean grid to mark out ships we have already counted.
		// Idea: upon encountering an x, check the table to see if it has already been visisted.
		// If not, figure out which way the ship goes (if any) and mark the corresponding nodes as visited as we go
		// "traversing" could be a subroutine
		int rows = board.length;
		int cols = board[0].length;
		int battleships = 0;
		
		// Mistakes: forgot 'new' keyword on line below
        boolean visited[][] = new boolean[rows][cols];
        
		
		for (boolean[] innerArr: visited) {
			Arrays.fill(innerArr, false);
		}
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (visited[i][j] == false) {
				    // visited = visit(visited, i, j);
				    visited[i][j] = true;
					if (board[i][j] == 'X') {
						++battleships;
						visited = traverse(board, visited, i, j);
					}
				}
			}
		}
		
		return battleships;
    }
	
	// Mistakes: forgot several of the type declarations in function header
	public boolean[][] visit(boolean[][] visited, int row, int col) {
		if (	row > visited.length - 1
			||  col > visited[0].length - 1
			||  row < 0
			||  col < 0
			) 
			
			return visited;
		else
			visited[row][col] = true;
			return visited;
	}
	
	// Mistake: Forgot return type (void) on line below
	public boolean[][] traverse(char[][] board, boolean[][] visited, int row, int col) {
		// As we travel across each row down to the next, we know we've already traversed ANY ship that started
		// from our left, and ANY ship that started above us. So we just need to see if there is an x to the 
		// right or below and then traverse iteratively marking those spots as 'visited'.
		// We can also mark anything adjacent to the right/below as visited so long as there is an X at the current
		// spot
		boolean verticalShip = false, horizontalShip = false, sizeOneShip = false;
		visited = visit(visited, row, col);
		
		// Case 1 - ship is vertical
		while (shipContinuesBelow(board, row, col) == true) {
			// nothing can be next to a vertical ship on either side, just visit them now
			visited = visit(visited, row, col+1);
			visited = visit(visited, row, col-1);
			
			// Move down to the next row and visit it - if dead end, visit handles out of bounds
			row = row + 1;
			visited = visit(visited, row, col);
		}
		
		// Case 2 - ship is horizontal
		while (shipContinuesRight(board, row, col) == true) {
			// nothing can be above/below a horizontal ship on either side, just visit them now
			visited = visit(visited, row-1, col); // redundant because we've already explored that row but... oh well?
			visited = visit(visited, row+1, col);
			
			// Move down to the next row and visit it - if dead end, visit handles out of bounds
			col = col + 1;
			visited = visit(visited, row, col);
		}
		
				// Case 0 - base case: ship is 1 unit wide:
		if (!shipContinuesBelow(board, row, col) && !shipContinuesRight(board, row, col) ) {
			visited = visit(visited, row, col+1);
			visited = visit(visited, row+1, col);
		}
		
		return visited;
	}

	public boolean shipContinuesBelow(char[][] board, int row, int col) {
		// If in last row, obviously ship cannot coninue below current pos
		// Otherwise we check the next row - this is safe because we know we're not in last row
		if (row == board.length -1 ) return false;
		else if (board[row+1][col] == 'X') return true;
		else return false;
	}
	
	public boolean shipContinuesRight(char[][] board, int row, int col) {
	    // If in last column, ship cannot be to the right
	    // Otherwise we check the next column
		if (col == board[0].length - 1) return false;
		else if (board[row][col+1] == 'X') return true;
		else return false;
	}
}