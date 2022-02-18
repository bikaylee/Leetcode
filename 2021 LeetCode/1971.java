// 1971. Find if Path Exists in Graph

class Solution {
    /**
     * 1. Convert graph to adjacency list 
     * 2. Perform BFS
     *    2.1 using queue to store all available vertices, start with 'start'
     *    2.2 using boolean [] seen to store all visited vertices as going through all adjacent vertices of current vertex
     * 3. if a path is found, the vertex of 'end' should be seened when expand to all adjacent vertices
     * 
     * @param n
     * @param edges
     * @param start
     * @param end
     * @return boolean 
     */
    public boolean validPath(int n, int[][] edges, int start, int end) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            if (!adjList.containsKey(edge[0]))
                adjList.put(edge[0], new ArrayList<>());
            if (!adjList.containsKey(edge[1]))
                adjList.put(edge[1], new ArrayList<>());
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean[] seen = new boolean[n];
        seen[start] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int currVertex = queue.poll();
            List<Integer> adj = adjList.get(currVertex);
            for (int i = 0; adj != null && i < adj.size(); i++) {
                if (!seen[adj.get(i)]) {
                    queue.add(adj.get(i));
                    seen[adj.get(i)] = true;
                }
            }
        }
        return seen[end];
    }

}