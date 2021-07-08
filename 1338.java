// 1338. Reduce Array Size to The Half

class Solution {
    public int minSetSize(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap();
        for (int n : arr)
            map.put(n, map.getOrDefault(n, 0) + 1);

        List<Integer> freq = new ArrayList<>(map.values());
        Collections.sort(freq);

        int ans = 0;
        for (int i = freq.size() - 1, n = 0; i >= 0 && n < arr.length / 2; i--) {
            n += freq.get(i);
            ans++;
        }

        return ans;
    }

    public int minSetSizeSlow(int[] arr) {

        // PriorityQueue<Pair<Integer,Integer>> pq = new
        // PriorityQueue<Pair<Integer,Integer>>((a,b) -> (b.getValue() - a.getValue()));

        HashMap<Integer, Integer> map = new HashMap();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // pq.add(new Pair <Integer,Integer> (entry.getKey(), entry.getValue()));
            pq.add(entry.getValue());
        }

        // System.out.println(map.toString());
        // System.out.println(pq.size());

        int n = 0, ans = 0;
        while (n < arr.length / 2 && !pq.isEmpty()) {
            n += pq.poll();
            ans++;
        }

        return ans;
    }
}