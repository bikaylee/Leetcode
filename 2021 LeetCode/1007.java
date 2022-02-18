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

    /*
     * Return min number of rotations if one could make all elements in A or B equal
     * to x. Else return -1.
     */
    public int check(int x, int[] A, int[] B, int n) {

        // how many rotations should be done
        // to have all elements in A equal to x
        // and to have all elements in B equal to x
        int rotations_a = 0, rotations_b = 0;

        for (int i = 0; i < n; i++) {
            // rotations coudn't be done
            if (A[i] != x && B[i] != x)
                return -1;
            // A[i] != x and B[i] == x
            else if (A[i] != x)
                rotations_a++;
            // A[i] == x and B[i] != x
            else if (B[i] != x)
                rotations_b++;
        }
        // min number of rotations to have all
        // elements equal to x in A or B
        return Math.min(rotations_a, rotations_b);
    }

    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        int rotations = check(A[0], B, A, n);

        // If one could make all elements in A or B equal to A[0]
        if (rotations != -1 || A[0] == B[0])
            return rotations;

        // If one could make all elements in A or B equal to B[0]
        return check(B[0], B, A, n);
    }
}