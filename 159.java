// 159. Longest Substring with At Most Two Distinct Characters

// Similar to 340. Longest Substring with At Most K Distinct Characters
class Solution {

    // store freq of distinct letter to array
    // if the distinct letter > 2
    // move the left pointer to decrease the number of distinct letters
    // lastly update the longest substring length
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] freq = new int[256];

        int longest = 0;
        int distinct = 0;

        for (int left = 0, right = 0; right < s.length(); right++) {
            if (freq[s.charAt(right)]++ == 0)
                distinct++;

            while (distinct > 2) {
                char leftChar = s.charAt(left++);
                freq[leftChar]--;
                if (freq[leftChar] == 0)
                    distinct--;
            }
            longest = Math.max(right - left + 1, longest);
        }

        return longest;
    }
}