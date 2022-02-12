package CodeSignal;

public class AvoidObstacles {
    int solution(int[] inputArray) {

        int max = Integer.MIN_VALUE;
        for (int input : inputArray)
            max = Math.max(max, input);

        int min = 2;

        while (min < max) {
            int valid = 0;
            for (int n : inputArray) {
                if (n % min == 0)
                    break;
                else
                    valid++;
            }
            if (valid == inputArray.length)
                return min;
            min++;
        }

        return max + 1;
    }

}
