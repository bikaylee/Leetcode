August 3, 2021

### Week 3 - Hash Table

| No. | Problems                                                                                               | Diff | Day | Previous | Finished |
| --- | ------------------------------------------------------------------------------------------------------ | ---- | --- | -------- | -------- |
| 1   | [692. Top K Frequent Words](#692-Top-K-Frequent-Words)                                                 | 🟠   | Tue | &check;  | &check;  |
| 2   | [**554. Brick Wall**](#554-Brick-Wall)                                                                 | 🟠   | Tue |          | &check;  |
| 3   | [**205. Isomorphic Strings**](#205-Isomorphic-Strings)                                                 | 🟢   | Tue | &check;  | &check;  |
| 4   | [560. Subarray Sum Equals K](#560-Subarray-Sum-Equals-K)                                               | 🟠   | Tue |          |          |
| 5   | [1396. Design Underground System](#1396-Design-Underground-System)                                     | 🟠   | Tue | &check;  |          |
|     |                                                                                                        |      |     |          |          |
| 1   | [202. Happy Number](#202-Happy-Number)                                                                 | 🟢   | Wed | &check;  |          |
| 2   | [264. Ugly Number II](#264-Ugly-Number-II)                                                             | 🟠   | Wed |          |          |
| 3   | [771. Jewels and Stones](#771-Jewels-and-Stones)                                                       | 🟢   | Wed | &check;  |          |
| 4   | [3. Longest Substring Without Repeating Characters](#3-Longest-Substring-Without-Repeating-Characters) | 🟠   | Wed |          |          |
| 5   | [380. Insert Delete GetRandom O(1)](<#380-Insert-Delete-GetRandom-O(1)>)                               | 🟠   | Wed |          |          |

**TODO:**

-

<br>

## Tuesday

### [692. Top K Frequent Words](https://leetcode.com/problems/top-k-frequent-words/)

#### Approach

<br>

### [554. Brick Wall](https://leetcode.com/problems/brick-wall/)

#### Approach

<br>

### [205. Isomorphic Strings](https://leetcode.com/problems/isomorphic-strings/)

Given two strings `s` and `t`, determine if they are isomorphic.  
Two strings `s` and `t` are isomorphic if the characters in `s` can be replaced to get `t`.

Input: s = `"egg"`, t = `"add"`  
Output: `true`

#### Approach

- Set character in s to be key and character in t to be values in the hash map
  - check if either eitehr character from the string has been used in the map
  ```java
  public boolean isIsomorphic(String s, String t) {
      HashMap<Character, Character> map = new HashMap<>();
      for (int i = 0; i < s.length(); i++) {
          char c1 = s.charAt(i);
          char c2 = t.charAt(i);
              // if c1 is already been replaced by c2 and does not match current pair
          if( (map.containsKey(c1) && map.get(c1) != c2) ||
              // if c1 is not been replaced by c2, but c2 has been taken for some other c1
              (!map.containsKey(c1) && map.containsValue(c2)))
              return false;
          map.put(c1, c2);
      }
      return true;
  }
  ```

<br>

### [560. Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)

#### Approach

<br>

### [1396. Design Underground System](https://leetcode.com/problems/design-underground-system/)

#### Approach

<br>
<br>

## Wednesday

### [202. Happy Number](https://leetcode.com/problems/happy-number/)

#### Approach

<br>

### [264. Ugly Number II](https://leetcode.com/problems/ugly-number-ii/)

#### Approach

<br>

### [771. Jewels and Stones](https://leetcode.com/problems/jewels-and-stones/)

#### Approach

<br>

### [3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

#### Approach

<br>

### [380. Insert Delete GetRandom O(1)](https://leetcode.com/problems/insert-delete-getrandom-o1/)

#### Approach

<br>
```
