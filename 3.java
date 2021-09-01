// 3. Longest Substring Without Repeating Characters

class Solution {
    // s = "a a a a a b" 
    //      ^ ^
    //  start i
    
    
    // s = "a b c b d e f"
    //      ^ 
    //   start
    
    // s = "a b c b d e f", Map = {a=0, b=1, c=2}
    //      ^     ^
    //    start   i  
    // since map.contains(b), start = previous occurrence of b => start = 1
    // update:  max(i - start, longest)
    
    
    // To update 'start', 
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        int max = 0;
        for (int i = 0, start = -1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) 
                // previous occurrence of duplicate character
                start = Math.max(map.get(c), start);
        
            // +1 to avoid if s = s's longest substring (no duplicates)
            // or set start = -1, where its initial state should have no duplicates
            max = Math.max(max, i-start);
            map.put(c, i);
        }
        
        return max;
    }
}