package CodeSignal;

public class DepositProfit {

    // log_b (x) = y
    int solution_Log(int deposit, int rate, int threshold) {
        return (int) Math.ceil(Math.log((double) threshold / deposit) / Math.log(1 + (rate / 100.0)));
    }

    int solution(int deposit, int rate, int threshold) {
        int year = 0;

        double amount = (double) deposit;
        double r = rate / 100.0 + 1;

        while ((int) amount < threshold) {
            amount *= r;
            year++;
        }

        return year;
    }

}
