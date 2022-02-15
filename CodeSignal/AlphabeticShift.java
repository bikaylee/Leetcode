package CodeSignal;

public class AlphabeticShift {
    String solution(String inputString) {
        StringBuilder ans = new StringBuilder();

        for (char c : inputString.toCharArray()) {
            if (c == 'z')
                c = 'a';
            else
                c++;

            ans.append(c);
        }

        return ans.toString();
    }

}
