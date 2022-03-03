package CodeSignal;

public class ShapeArea {
    int solution(int n) {
        if (n == 1)
            return 1;
        n--;
        return 4 * n + solution(n);
    }
}
