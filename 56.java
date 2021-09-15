
// 56. Merge Intervals

class Solution {

    // 9-15-2021
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int n = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[n][1] >= intervals[i][0])
                intervals[n][1] = Math.max(intervals[n][1], intervals[i][1]);
            else
                intervals[++n] = intervals[i];
        }

        int[][] ans = new int[n + 1][2];
        for (int i = 0; i <= n; i++)
            ans[i] = intervals[i];

        return ans;
    }

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        LinkedList<int[]> ans = new LinkedList<>();
        ans.add(intervals[0]);

        // Since all intervals are sorted by the start_i, there is no need to update the
        // entered intervals' start
        // compare the next start_i with the previous end_(i-1), if its inclusive from
        // the previous, update the end_(i-1)
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= ans.getLast()[1])
                ans.getLast()[1] = Math.max(ans.getLast()[1], intervals[i][1]);
            else
                ans.add(intervals[i]);
        }
        return ans.toArray(int[][]::new);
    }
}