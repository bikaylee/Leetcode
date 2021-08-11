class Solution {

    // [[1,2,2,1],
    // [3,1,2],
    // [1,3,2],
    // [2,4],
    // [3,1,2],
    // [1,3,1,1]]

    // Based on the input walls, each gap quantity in each row is

    // - Gap at column 1 is 3
    // - Gap at column 2 is 1
    // - Gap at column 3 is 3
    // - Gap at column 4 is 4
    // - Gap at column 5 is 2

    // - Gather the number of gaps between walls. The maximum gap between columns is
    // the number of rows.

    // Time: O(n)
    // Space: O(n)
    public int leastBricks(List<List<Integer>> wall) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (List<Integer> row : wall) {
            for (int col = 0, gapColumn = 0; col < row.size() - 1; col++) {
                gapColumn += row.get(col);
                map.put(gapColumn, map.getOrDefault(gapColumn, 0) + 1);
            }
        }

        int min = wall.size();
        for (int key : map.keySet())
            min = Math.min(min, wall.size() - map.get(key));

        return min;
    }
}