package CodeSignal;

public class EvenDigitsOnly {
    boolean solution(int n) {
        while (n > 0) {
            int digit = n % 10;
            if (digit % 2 != 0)
                return false;
            n /= 10;
        }

        return true;
    }
}
