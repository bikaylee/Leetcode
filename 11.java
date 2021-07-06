// 11. Container With Most Water

class Solution {
    public int maxArea(int[] height) {
        int area = 0, i = 0, j = height.length - 1;

        while (i < j) {
            area = Math.max(area, Math.min(height[i], height[j]) * (j - i));
            if (height[j] < height[i])
                j--;
            else
                i++;
        }
        return area;
    }
}