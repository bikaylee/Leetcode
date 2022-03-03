package CodeSignal;

public class SortbyHeight {
    int[] solution(int[] a) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int x : a) {
            if (x != -1)
                q.add(x);
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != -1) {
                a[i] = q.poll();
            }
        }

        return a;
    }

}
