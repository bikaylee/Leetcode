// 17. Letter Combinations of a Phone Number

class Solution {

    private HashMap<Character, String> keypad = new HashMap<>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };
    private List<String> ans;
    private int index;
    private String digit;

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<String>();
        ans = new ArrayList<>();
        index = 0;
        digit = digits;
        backtrack(0, new StringBuilder());
        return ans;
    }

    private void backtrack(int index, StringBuilder com) {

        if (com.length() == digit.length()) {
            ans.add(com.toString());
            return;
        }

        String letters = this.keypad.get(this.digit.charAt(index));
        for (char num : letters.toCharArray()) {
            com.append(num);
            backtrack(index + 1, com);
            com.deleteCharAt(com.length() - 1);
        }

    }
}