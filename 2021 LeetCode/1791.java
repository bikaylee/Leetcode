//1791. Find Center of Star Graph

class Solution {
    // Since all edges should contains the center node and at least 3 nodes = 2
    // edges
    public int findCenter(int[][] edges) {
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1])
            return edges[0][0];
        return edges[0][1];
    }

    // HashSet
    public int findCenterHash(int[][] edges) {
        HashSet<Integer> visitedVertex = new HashSet<>();

        for (int[] edge : edges) {
            if (visitedVertex.contains(edge[0]))
                return edge[0];
            if (visitedVertex.contains(edge[1]))
                return edge[1];
            visitedVertex.add(edge[0]);
            visitedVertex.add(edge[1]);
        }

        return -1;
    }
}