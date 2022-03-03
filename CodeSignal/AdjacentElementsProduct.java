package CodeSignal;

public class AdjacentElementsProduct {
    int solution(int[] inputArray) {
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < inputArray.length; i++)
            max = Math.max(max, inputArray[i - 1] * inputArray[i]);

        return max;
    }

}
