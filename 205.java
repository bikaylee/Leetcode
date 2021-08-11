class Solution {
    // - Set character in s to be key and character in t to be values in the hash
    // map
    // - check if either eitehr character from the string has been used in the map
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            // if c1 is already been replaced by c2 and does not match current pair
            if ((map.containsKey(c1) && map.get(c1) != c2) ||
            // if c1 is not been replaced by c2, but c2 has been taken for some other c1
                    (!map.containsKey(c1) && map.containsValue(c2)))
                return false;
            map.put(c1, c2);
        }
        return true;
    }
}