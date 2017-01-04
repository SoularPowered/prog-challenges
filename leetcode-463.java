/* 463. Island Perimeter
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. 
Grid cells are connected horizontally/vertically (not diagonally). 
The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). 
The island doesn't have "lakes" (water inside that isn't connected to the water around the island). 
One cell is a square with side length 1. 
The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
*/

public class Solution {
    public int islandPerimeter(int[][] grid) {
        int edges = 0;
		int height = grid.length, width = grid[0].length;
		
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) {
                    // Algorithm will only evaluate edges for the land pieces, simplifying the code
					
					// Check top edge
					if (i == 0) {
						// Top row - top edge must be a perimeter
						++edges;
					} else if (grid[i-1][j] == 0) {
						// otherwise it's only an edge if water to the north
						++edges;
					}
					
					// Check bottom edge
					if (i == (height - 1)) {
						// bottom row - bottom edge must be a perimeter
						++edges;
					} else if (grid[i+1][j] == 0) {
						// otherwise it's only an edge if water to the south
						++edges;
					}
					
					// check right edge
					if (j == (width - 1)) {
						// Right column - right edge must be perimeter
						++edges;
					} else if (grid[i][j+1] == 0) {
						// Water to the right
						++edges;
					}
					
					// check left edge
					if (j == 0) {
						// Left column - right edge must be perimeter
						++edges;
					} else if (grid[i][j-1] == 0) {
						// Water to the left
						++edges;
					}
                }
            }
        }
        return edges;
    }
}