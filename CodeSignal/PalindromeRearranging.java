package CodeSignal;

public class PalindromeRearranging {
    boolean solution(String inputString) {
        int[] arr = new int[26];

        int count = 0;
        for (char c : inputString.toCharArray())
            arr[c - 'a']++;

        for (int a : arr) {
            if (a % 2 != 0)
                count++;
            if (count > 1)
                return false;
        }

        return true;
    }
}
