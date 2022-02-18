// 1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        // Since input arrays might not be in order, sort them first
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        // Since 2 <= h, w <= 10^9, which is greater than integer
        long maxH = horizontalCuts[0];
        long maxW = verticalCuts[0];

        // get the max interval in horizontalCuts and verticalCuts
        for (int i = 1; i < horizontalCuts.length; i++)
            maxH = Math.max(horizontalCuts[i] - horizontalCuts[i - 1], maxH);

        for (int i = 1; i < verticalCuts.length; i++)
            maxW = Math.max(verticalCuts[i] - verticalCuts[i - 1], maxW);

        maxH = Math.max(maxH, h - horizontalCuts[horizontalCuts.length - 1]);
        maxW = Math.max(maxW, w - verticalCuts[verticalCuts.length - 1]);

        return (int) ((maxH * maxW) % 1000000007);
    }
}