package CodeSignal;

public class ArrayMatrixAdjacentDifference {
    int solution(int[] inputArray) {
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < inputArray.length; i++)
            max = Math.max(max, Math.abs(inputArray[i] - inputArray[i - 1]));
        return max;
    }

}
