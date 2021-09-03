// 695. Max Area of Island

class Solution {
    
    // Similar to 200. Number of Islands
    
    // Whenever encounter an island(1),
    // perform a dfs to find all adjacent 1's to count the area
    // * Flip all visited 1's to 0 to prevent infinite loops 
    // Account for a max area and compare with new area found 
    
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length; // n,m is at least 1
        
        int max = 0;
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                if (grid[r][c] == 1) 
                    max = Math.max(max, getArea(grid, r, c));
        return max;
    }
    
    // When performing dfs, watch out for boundary check and flipping
    private int getArea(int[][] grid, int r, int c) {
        
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
            return 0;
        
        if (grid[r][c] == 0) return 0;
        
        grid[r][c] = 0;
        return 1 + getArea(grid, r+1, c) 
                 + getArea(grid, r-1, c) 
                 + getArea(grid, r, c+1) 
                 + getArea(grid, r, c-1); 
    }
}