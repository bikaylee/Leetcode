// 463. Island Perimeter

class Solution {

    // Since there is only one island
    // only one pass of left and up can find all 1's
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        // looking for the first 1
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                    // -2 because the one before has to -1 also, as well as the current one
                    // up neighbor
                    if (i > 0 && grid[i - 1][j] == 1)
                        perimeter -= 2;
                    // left neighbor
                    if (j > 0 && grid[i][j - 1] == 1)
                        perimeter -= 2;
                }
            }
        }

        return perimeter;
    }

}