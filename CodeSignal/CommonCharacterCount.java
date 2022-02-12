package CodeSignal;

public class CommonCharacterCount {
    int solution(String s1, String s2) {
        int[] a = new int[26];

        // a=2, b=1, c=2

        for (char c : s1.toCharArray())
            a[c - 'a']++;

        // a--, common++ [a=1, b=1, c=2]
        // d
        // c--, common++ [a=1, b=1, c=1]
        // a--, common++ [a=0, b=1, c=1]

        int common = 0;
        for (char c : s2.toCharArray()) {
            if (a[c - 'a'] > 0) {
                common++;
                a[c - 'a']--;
            }
        }

        return common;
    }

}
