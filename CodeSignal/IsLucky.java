package CodeSignal;

public class IsLucky {
    boolean solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();

        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }

        int first = 0;
        int second = 0;

        int half = list.size() / 2;
        for (int i = 0; i < half; i++)
            first += list.get(i);

        for (int i = half; i < list.size(); i++)
            second += list.get(i);

        return first == second;
    }

}
