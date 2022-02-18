package CodeSignal;

public class FirstDuplicate {
    int solution(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int a : arr) {
            if (set.contains(a))
                return a;
            set.add(a);
        }

        return -1;
    }

}
