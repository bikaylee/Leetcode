package CodeSignal;

public class FirstNotRepeatingCharacter {
    char solution(String s) {
        int[] map = new int[26];

        for (char c : s.toCharArray())
            map[c - 'a']++;

        for (char c : s.toCharArray()) {
            if (map[c - 'a'] == 1)
                return c;
        }

        return '_';
    }
}
