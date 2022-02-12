package CodeSignal;

public class CheckPalindrome {
    boolean solution(String inputString) {
        for (int i = 0, j = inputString.length() - 1; i < j; i++, j--) {
            if (inputString.charAt(i) != inputString.charAt(j))
                return false;
        }
        return true;
    }

}
