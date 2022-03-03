package CodeSignal;

public class AreSimilar {
    boolean solution(int[] a, int[] b) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                map.put(a[i], map.getOrDefault(a[i], 0) + 1);
                map.put(b[i], map.getOrDefault(b[i], 0) + 1);

                if (map.get(a[i]) > 2 || map.get(b[i]) > 2)
                    return false;
            }
        }

        return map.size() == 2 || map.size() == 0;
    }

}
