class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;

        int[] topFreq = new int[7];
        int[] botFreq = new int[7];
        int topMax = 0;
        int botMax = 0;

        for (int i = 0; i < n; i++) {
            topFreq[tops[i]]++;
            botFreq[bottoms[i]]++;

            if (topFreq[tops[i]] > topFreq[topMax])
                topMax = tops[i];
            if (botFreq[bottoms[i]] > botFreq[botMax])
                botMax = bottoms[i];
        }

        if (topFreq[topMax] == topFreq[botMax] && topFreq[botMax] < botFreq[botMax])
            topMax = botMax;
        else if (botFreq[botMax] == botFreq[topMax] && botFreq[topMax] < botFreq[topMax])
            botMax = topMax;

        int topRotations = getRotations(tops, bottoms, n, topMax);
        int botRotations = getRotations(bottoms, tops, n, botMax);

        if (topRotations == -1 && botRotations == -1)
            return -1;

        return Math.min(topRotations, botRotations);
    }

    private int getRotations(int[] original, int[] compared, int n, int maxFreqElement) {
        int rotations = 0;
        for (int i = 0; i < n; i++) {
            if (original[i] != maxFreqElement) {
                if (compared[i] == maxFreqElement)
                    rotations++;
                else {
                    rotations = -1;
                    break;
                }
            }
        }
        return rotations;
    }
}