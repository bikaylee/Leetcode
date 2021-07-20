// 49. Group Anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList();
        Map<String, List<String>> map = new HashMap();

        for (String s : strs) {
            char temp[] = s.toCharArray();
            Arrays.sort(temp);
            String sorted = String.valueOf(temp);
            if (!map.containsKey(sorted))
                map.put(sorted, new ArrayList<String>());
            map.get(sorted).add(s);
        }

        return new ArrayList<>(map.values());
    }
}


// Approach 2:
// Categorize by Count Intuition
// Two strings are anagrams if and only if their character counts (respective number of occurrences of each character) are the same.

// Algorithm
// We can transform each string \text{s}s into a character count, 
// \text{count}count, consisting of 26 non-negative integers representing 
// the number of \text{a}a's, \text{b}b's, \text{c}c's, etc. We use these counts as the basis for our hash map.

// In Java, the hashable representation of our count will be a string delimited with '#' characters. For example, abbccc will be #1#2#3#0#0#0...#0 where there are 26 entries total. In python, the representation will be a tuple of the counts. For example, abbccc

// will be (1, 2, 3, 0, 0, ..., 0), where again there are 26 entries total.