// 438. Find All Anagrams in a String

class Solution {

    // 9-7-2021
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length())
            return new ArrayList<>();

        int[] sFreq = new int[26];
        int[] pFreq = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
            sFreq[s.charAt(i) - 'a']++;
        }

        int start = 0;
        List<Integer> ans = new LinkedList<>();
        for (int i = p.length(); i < s.length(); i++) {
            if (Arrays.equals(sFreq, pFreq))
                ans.add(start);

            // System.out.println();
            // for (int x:sFreq)
            // System.out.print(x + " ");
            sFreq[s.charAt(start) - 'a']--;
            sFreq[s.charAt(i) - 'a']++;
            start++;
        }

        if (Arrays.equals(sFreq, pFreq))
            ans.add(start);

        return ans;
    }

    public List<Integer> findAnagrams(String s, String p) {

        if (p.length() > s.length())
            return new ArrayList<>();

        int start = 0, end = p.length() - 1;
        List<Integer> ans = new ArrayList<>();

        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : p.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = start; i < end; i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

        while (end < s.length()) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);

            if (map.equals(freq))
                ans.add(start);

            char c = s.charAt(start);
            if (map.get(c) > 1)
                map.put(c, map.get(c) - 1);
            else
                map.remove(c);

            start++;
            end++;
        }

        return ans;
    }

    // Instead of hashtable, use constant array
    public List<Integer> findAnagramsSolution(String s, String p) {
        int ns = s.length(), np = p.length();
        if (ns < np)
            return new ArrayList();

        int[] pCount = new int[26];
        int[] sCount = new int[26];
        // build reference array using string p
        for (char ch : p.toCharArray()) {
            pCount[(int) (ch - 'a')]++;
        }

        List<Integer> output = new ArrayList();
        // sliding window on the string s
        for (int i = 0; i < ns; ++i) {
            // add one more letter
            // on the right side of the window
            sCount[(int) (s.charAt(i) - 'a')]++;
            // remove one letter
            // from the left side of the window
            if (i >= np) {
                sCount[(int) (s.charAt(i - np) - 'a')]--;
            }
            // compare array in the sliding window
            // with the reference array
            if (Arrays.equals(pCount, sCount)) {
                output.add(i - np + 1);
            }
        }
        return output;
    }

}
