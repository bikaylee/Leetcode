// 994. Rotting Oranges

class Solution {
    // [[2,1,1],                2
    //  [1,1,0],     ->       /   \
    //  [0,1,1]]             1     1
    //                      / \   / \
    //  diagonal:          0    1    1   
    //                      \  / \   /
    //                       1     0
    //                        \   /
    //                          1
    // Time elapsed at each level
    //
    // Mark every rotten oranges into a queue and expand to its adjacent cells
    // Start with the first rotten orange in the queue
    //      make all of its valid adj fresh oranges rotten and add to queue
    
    public int orangesRotting(int[][] grid) {
        // top, down, left, right
        final int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int rows = grid.length, cols = grid[0].length;
        
        int freshOranges = 0;
        int minute = -1;
        
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1)
                    freshOranges++;
                else if (grid[r][c] == 2)
                    queue.add(new Pair(r, c));
            }
        }
        
        if (freshOranges == 0) return 0;
                
        
        
        while (!queue.isEmpty()) {
            int n = queue.size();
            minute++;
            while (n-- > 0) {
                Pair<Integer, Integer> orange = queue.poll();
                int r = orange.getKey();
                int c = orange.getValue();                    
                for (int[] d: dir) {
                    int newr = r + d[0];
                    int newc = c + d[1];
                    if (newr >= 0 && newr < rows && newc >= 0 && newc < cols && grid[newr][newc] == 1) {
                        grid[newr][newc] = 2;
                        freshOranges--;
                        queue.add(new Pair(newr, newc));
                    }
                }
            }
        }
        return freshOranges == 0 ? minute:-1;
    }
}