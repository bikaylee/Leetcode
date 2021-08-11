class Solution {
    // - If a number has been visited, there's a cycle.

    // Time: O(log n)
    // Space: O(log n)
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        while (n != 1 && !visited.contains(n)) {
            visited.add(n);
            int sum = 0;
            while (n > 0) {
                int d = n % 10;
                n = n / 10;
                sum += d * d;
            }
            n = sum;
        }
        return n == 1;
    }
}
