// 785. Is Graph Bipartite?

class Solution {
    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int[] color = new int[n];

        // Use DFS to traverse all nodes in the graph by using its neighbors

        // First, make a color list to store all (visited and its colored neighbors)
        // nodes with corresponding coloring
        // Start with the one color and make all of its neighbors the opposite color
        // If any of the neighbors has been colored,
        // if neighbor has not been colored means not be visited nor a neighbor of a
        // visited node,
        // color this neighbor to be the opposite color of current node,
        // put this neighbor in the stack for its neighbor iterations.
        // if neighbor and current node color collide,
        // Graph is NOT bipartite.

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0) {
                Stack<Integer> stack = new Stack();
                stack.add(i);
                color[i] = 1;

                while (!stack.empty()) {
                    Integer node = stack.pop();

                    for (int neighbor : graph[node]) {
                        if (color[neighbor] == 0) {
                            stack.push(neighbor);
                            color[neighbor] = -color[node];
                        } else if (color[neighbor] == color[node]) {
                            return false;
                        }
                    }
                }

            }
        }

        return true;
    }
}