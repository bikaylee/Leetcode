// 340. Longest Substring with At Most K Distinct Characters

class Solution {
    
    // Keep a window that contains at most k distinct characters
    // if it's distinct characters is greater than k 
    //      remove the first character from window
    // else (less than or equal to k distinct characters) 
    //      update the max length of current window size
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) 
            return 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        int longest = 0;        
        for (int start = 0, end = 0; end < s.length(); end++) {
            char currChar = s.charAt(end);
            map.put(currChar, map.getOrDefault(currChar, 0)+1);
            
            // Use while loop to move left pointer
            while (map.size() > k) {
                char startChar = s.charAt(start);
                int occurence = map.getOrDefault(startChar, 0);
                if (occurence == 1)  
                    map.remove(startChar);
                else if(occurence > 1)
                    map.put(startChar, occurence-1);
                start++;
            }
            longest = Math.max(longest, end-start+1);
        }
        
        return longest;
    }
    
    
    // From Discussion
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int distinctChars = 0, i = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
            
            // only count at the first time and record in count 
            if (count[s.charAt(j)]++ == 0) 
                distinctChars++;
            
            // if number of distinct chars exceeds 
            // remove the left pointer char in count 
            if (distinctChars > k) {
                while (--count[s.charAt(i++)] > 0);
                distinctChars--;
            }
            
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}