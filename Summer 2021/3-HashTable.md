August 3, 2021

### Week 3 - Hash Table

| No. | Problems                                                                                               | Diff | Day | Previous | Finished |
| --- | ------------------------------------------------------------------------------------------------------ | ---- | --- | -------- | -------- |
| 1   | [692. Top K Frequent Words](#692-Top-K-Frequent-Words)                                                 | 🟠   | Tue | &check;  | &check;  |
| 2   | [**554. Brick Wall**](#554-Brick-Wall)                                                                 | 🟠   | Tue |          | &check;  |
| 3   | [**205. Isomorphic Strings**](#205-Isomorphic-Strings)                                                 | 🟢   | Tue | &check;  | &check;  |
| 4   | [**560. Subarray Sum Equals K**](#560-Subarray-Sum-Equals-K)                                           | 🟠   | Tue |          |          |
| 5   | [1396. Design Underground System](#1396-Design-Underground-System)                                     | 🟠   | Tue | &check;  |          |
|     |                                                                                                        |      |     |          |          |
| 1   | [**202. Happy Number**](#202-Happy-Number)                                                             | 🟢   | Wed | &check;  | &check;  |
| 2   | [**264. Ugly Number II**](#264-Ugly-Number-II)                                                         | 🟠   | Wed |          | &check;  |
| 3   | [771. Jewels and Stones](#771-Jewels-and-Stones)                                                       | 🟢   | Wed | &check;  |          |
| 4   | [3. Longest Substring Without Repeating Characters](#3-Longest-Substring-Without-Repeating-Characters) | 🟠   | Wed |          |          |
| 5   | [380. Insert Delete GetRandom O(1)](<#380-Insert-Delete-GetRandom-O(1)>)                               | 🟠   | Wed |          |          |

**TODO:**

- **554. Brick Wall**
- **205. Isomorphic Strings**
- **560. Subarray Sum Equals K**
- **202. Happy Number**
- **264. Ugly Number II**

<br>

## Tuesday

### [692. Top K Frequent Words](https://leetcode.com/problems/top-k-frequent-words/)

Input: `["i", "love", "leetcode", "i", "love", "coding"], k = 2`  
Output: `["i", "love"]`

#### Approach

- Use hash map to store frequency of all words. Then, use a priority queue to compare each frequency until k elements are added to the return list.

  ```java
  // Time: O(n log n)
  // Space: O(n)
  public List<String> topKFrequent(String[] words, int k) {
      HashMap<String, Integer> freq = new HashMap<>();

      for (String word: words)
          freq.put(word, freq.getOrDefault(word, 0)+1);

      PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> freq.get(s1) == freq.get(s2) ?
                                                      s1.compareTo(s2): freq.get(s2) - freq.get(s1));
      for (String word: freq.keySet())
          pq.add(word);

      List<String> ans = new ArrayList<String>();
      while (!pq.isEmpty() && k-- > 0)
          ans.add(pq.poll());

      return ans;
  }
  ```

<br>

### [554. Brick Wall](https://leetcode.com/problems/brick-wall/)

Given the 2D array wall that contains the information about the wall, return the minimum number of crossed bricks after drawing such a vertical line.

Input: wall = `[[1,2,2,1], [3,1,2], [1,3,2], [2,4], [3,1,2], [1,3,1,1]]`  
Output: `2`

#### Approach

Based on the input walls, each gap quantity in each row is

- Gap at column 1 is 3
- Gap at column 2 is 1
- Gap at column 3 is 3
- Gap at column 4 is 4
- Gap at column 5 is 2

- Gather the number of gaps between walls. The maximum gap between columns is the number of rows.

  ```java
  // Time: O(n)
  // Space: O(n)
  public int leastBricks(List<List<Integer>> wall) {
      HashMap<Integer, Integer> map = new HashMap<>();
      for (List < Integer > row: wall) {
          for (int col = 0, gapColumn = 0; col < row.size()-1; col++) {
              gapColumn += row.get(col);
              map.put(gapColumn, map.getOrDefault(gapColumn, 0)+1);
          }
      }

      int min = wall.size();
      for (int key: map.keySet())
          min = Math.min(min, wall.size() - map.get(key));

      return min;
  }
  ```

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

<br>

### [1396. Design Underground System](https://leetcode.com/problems/design-underground-system/)

<br>
<br>

## Wednesday

### [202. Happy Number](https://leetcode.com/problems/happy-number/)

A happy number is a number defined by the following process:

- Starting with any positive integer, replace the number by the sum of the squares of its digits.
- Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
- Those numbers for which this process ends in 1 are happy.

Input: `n = 19`  
Output: `true`  
Explanation:  
`1^2 + 9^2 = 82`  
`8^2 + 2^2 = 68`  
`6^2 + 8^2 = 100`  
`1^2 + 0^2 + 0^2 = 1`

#### Approach

- If a number has been visited, there's a cycle.
  ```java
  // Time: O(log n)
  // Space: O(log n)
  public boolean isHappy(int n) {
      Set<Integer> visited = new HashSet<>();
      while (n != 1 && !visited.contains(n)) {
          visited.add(n);
          int sum = 0;
          while (n > 0) {
              int d = n % 10;
              n = n / 10;
              sum += d * d;
          }
          n = sum;
      }
      return n == 1;
  }
  ```

<br>

### [264. Ugly Number II](https://leetcode.com/problems/ugly-number-ii/)

An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return the nth ugly number.

#### Approach

- TO BE ADDED

  ```java
  // Space: O(n)
  public int nthUglyNumber(int n) {
      int [] dp = new int[n];
      dp[0] = 1;
      int two = 2, three = 3, five = 5;
      for(int i = 1, x = 1, y = 1, z = 1; i < n; i++) {
          int min = Math.min(two, Math.min(three, five));
          dp[i] = min;
          if (min == two)
              two = dp[x++]*2;
          if (min == three)
              three = dp[y++]*3;
          if (min == five)
              five = dp[z++]*5;
      }

      return dp[n-1];
  }
  ```

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
