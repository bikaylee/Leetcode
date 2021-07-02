// 200. Number of Islands

class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        if (grid.size() == 0){
            return 0;
        }
        
        int islands = 0;
        
        for (int r = 0; r < grid.size(); r++){
            for (int c = 0; c < grid[0].size(); c++){
                if (grid[r][c] == '1'){
                    islands++;
                    dfs_helper(r, c, grid);
                 
                }
                
            }
        }
        return islands;
    }
    
    void dfs_helper(int r, int c, vector<vector<char>>&grid){

        grid[r][c] = '0';
        
        int m = grid.size();
        int n = grid[0].size();
        
        if (r - 1 >= 0 && grid[r-1][c] == '1'){
            dfs_helper(r-1, c, grid);
        }
        if (r + 1 < m && grid[r+1][c] == '1'){
            dfs_helper(r+1, c, grid);
        }
        
        if (c - 1 >= 0 && grid[r][c-1] == '1'){
            dfs_helper(r, c-1, grid);
        }
        if (c + 1 < n && grid[r][c+1] == '1'){
            dfs_helper(r, c+1, grid);
        }
    }
    
};