// 733. Flood Fill

class Solution {

    // Need to deal with boundaries
    // if any 4-directionally pixel is the same color, change to newColor

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        int cols = image[0].length;
        int color = image[sr][sc];

        HashSet<Pair<Integer, Integer>> visited = new HashSet<>();
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(sr, sc));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pos = queue.poll();
            int r = pos.getKey(), c = pos.getValue();
            /// if (r >= 0 && r < rows && c >= 0 && c < cols) {

            if (!visited.contains(pos) && image[r][c] == color) {
                image[r][c] = newColor;
                visited.add(pos);
                if (r > 0)
                    queue.add(new Pair(r - 1, c));
                if (r + 1 < rows)
                    queue.add(new Pair(r + 1, c));
                if (c + 1 < cols)
                    queue.add(new Pair(r, c + 1));
                if (c > 0)
                    queue.add(new Pair(r, c - 1));
            }
        }

        return image;
    }

}