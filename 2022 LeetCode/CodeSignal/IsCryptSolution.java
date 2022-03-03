package CodeSignal;

public class IsCryptSolution {
    boolean solution(String[] crypt, char[][] solution) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char[] s : solution)
            map.put(s[0], s[1] - '0');

        int[] ans = new int[3];
        for (int i = 0; i < 3; i++) {
            String s = crypt[i];
            if (s.length() > 1 && map.get(s.charAt(0)) == 0)
                return false;
            for (int j = 0; j < s.length(); j++)
                ans[i] = ans[i] * 10 + map.get(s.charAt(j));
        }
        // for (int a:ans)
        // System.out.println(a);
        return ans[0] + ans[1] == ans[2];
    }
}
