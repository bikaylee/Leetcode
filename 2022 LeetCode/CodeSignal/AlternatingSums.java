package CodeSignal;

public class AlternatingSums {
    int[] solution(int[] a) {
        int[] sum = new int[2];

        for (int i = 0; i < a.length; i++)
            sum[i % 2] += a[i];

        return sum;
    }

}
