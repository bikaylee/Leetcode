
// 509. Fibonacci Number

class Solution {

    // Enhanced DP without extra spaces
    public int fibMemorized(int n) {
        if (n <= 1)
            return n;

        int first = 0;
        int second = 1;
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = first + second;
            first = second;
            second = ans;
        }

        return ans;
    }

    // DP
    public int fibDP(int N) {
        if (N <= 1) {
            return N;
        }

        int[] cache = new int[N + 1];
        cache[1] = 1;
        for (int i = 2; i <= N; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }

        return cache[N];
    }

    // Recursion
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        return fib(N - 1) + fib(N - 2);
    }

}