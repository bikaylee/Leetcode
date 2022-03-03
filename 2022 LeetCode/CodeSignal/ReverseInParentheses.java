package CodeSignal;

public class ReverseInParentheses {
    String solution(String inputString) {

        char[] arr = inputString.toCharArray();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(')
                stack.add(i + 1);
            else if (arr[i] == ')')
                reverse(arr, stack.pop(), i);
        }

        StringBuilder ans = new StringBuilder();
        for (char c : arr) {
            if (c == '(' || c == ')')
                continue;
            ans.append(c);
        }
        return ans.toString();
    }

    void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

}
