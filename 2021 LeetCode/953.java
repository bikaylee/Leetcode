//953. Verifying an Alien Dictionary
class Solution {

    // Brute Force (Faster)
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (j >= words[i + 1].length())
                    return false;
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    if (order.indexOf(words[i].charAt(j)) > order.indexOf(words[i + 1].charAt(j)))
                        return false;
                    else
                        break;
                }
            }
        }
        return true;
    }

    // Hash Table
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            int j = 0;
            while (j < words[i].length() && j < words[i + 1].length()) {
                if (map.get(words[i].charAt(j)) < map.get(words[i + 1].charAt(j)))
                    break;
                else if (map.get(words[i].charAt(j)) > map.get(words[i + 1].charAt(j)))
                    return false;
                j++;
            }
            if (words[i + 1].length() == j && words[i].length() > j)
                return false;
        }
        return true;
    }

}