package CodeSignal;

public class CircleofNumbers {
    int solution(int n, int firstNumber) {
        int ans = firstNumber + n / 2;
        return ans % n;
    }
}
