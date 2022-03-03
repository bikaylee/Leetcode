package CodeSignal;

public class AddBorder {
    String[] solution(String[] picture) {
        int len = picture[0].length() + 2;

        StringBuilder border = new StringBuilder();
        for (int i = 0; i < len; i++)
            border.append('*');

        String[] ans = new String[picture.length + 2];
        for (int i = 1; i < ans.length - 1; i++)
            ans[i] = "*" + picture[i - 1] + "*";
        ans[0] = border.toString();
        ans[ans.length - 1] = ans[0];

        return ans;
    }

}
