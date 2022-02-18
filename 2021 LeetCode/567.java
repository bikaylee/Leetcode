// 567. Permutation in String

class Solution {

    // Since order of does not matter, convert char freq of s1 to int[26]
    // if there's any contiguous substring has the same freq as s1's freq
    // then, there is substring of permutation in s2

    // always keep the two freq arr the same size and perform comparison
    // so sliding window can work as long as the distance between two pointers is
    // s1.length
    // as we shift the window to the right, always check if two freq arr equals

    public boolean checkInclusion(String s1, String s2) {

        // if s1.length > s2.length, there is no permutation of s1 in s2
        if (s1.length() > s2.length())
            return false;

        // Establish two frequency array for the characters in string
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        // Always keep arr2's total char freq size as arr1 (s1.length)
        // which means keep the window at size of s1
        for (int i = 0; i < s1.length(); i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }

        // When sliding the window, check if two freq char equals
        // If equals, it means there is a permutation of s1 in s2
        // else continue to move the window until the end of s2
        for (int i = 0, j = s1.length(); j < s2.length(); i++, j++) {
            if (Arrays.equals(arr1, arr2))
                return true;
            arr2[s2.charAt(i) - 'a']--;
            arr2[s2.charAt(j) - 'a']++;
        }
        return Arrays.equals(arr1, arr2);
    }
}