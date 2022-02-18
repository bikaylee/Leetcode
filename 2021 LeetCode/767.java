class Solution {
    public String reorganizeString(String s) {
        // frequency map of all characters in s
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        // priority queue storing the decreasing order of characters based on their
        // frequency
        // all characters in priority queue should be unqiue
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (char c : map.keySet())
            pq.add(c);

        // start with an empty stringbuilder
        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
            // temp char holder for same as previous char
            // if ==, temp must be put back to the queue for the next append
            char temp = 0;
            if (ans.length() > 0) {
                if (pq.peek() == ans.charAt(ans.length() - 1))
                    temp = pq.poll();

                // if there is only one unique char left and same as previous
                // then, cannot make adjacent char different
                if (pq.isEmpty() && temp != 0)
                    return "";
            }

            char c = pq.poll();
            map.put(c, map.get(c) - 1);
            ans.append(c);

            if (temp != 0)
                pq.add(temp);

            if (map.get(c) > 0)
                pq.add(c);
        }
        return ans.toString();
    }
}