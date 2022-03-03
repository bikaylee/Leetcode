package CodeSignal;

public class ArrayChange {
    int solution(int[] inputArray) {
        int moves = 0;
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] <= inputArray[i - 1]) {
                int n = inputArray[i - 1] - inputArray[i] + 1;
                moves += n;
                inputArray[i] += n;
            }
        }

        return moves;
    }

}
