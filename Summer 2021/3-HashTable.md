August 3, 2021

### Week 3 - Hash Table

| No. | Problems                                                                                                   | Diff | Day | Previous | Finished |
| --- | ---------------------------------------------------------------------------------------------------------- | ---- | --- | -------- | -------- |
| 1   | [692. Top K Frequent Words](#692-Top-K-Frequent-Words)                                                     | 🟠   | Tue | &check;  | &check;  |
| 2   | [**554. Brick Wall**](#554-Brick-Wall)                                                                     | 🟠   | Tue |          | &check;  |
| 3   | [**205. Isomorphic Strings**](#205-Isomorphic-Strings)                                                     | 🟢   | Tue | &check;  | &check;  |
| 4   | [**560. Subarray Sum Equals K**](#560-Subarray-Sum-Equals-K)                                               | 🟠   | Tue |          | &check;  |
| 5   | [1396. Design Underground System](#1396-Design-Underground-System)                                         | 🟠   | Tue | &check;  | &check;  |
|     |                                                                                                            |      |     |          |          |
| 6   | [**202. Happy Number**](#202-Happy-Number)                                                                 | 🟢   | Wed | &check;  | &check;  |
| 7   | [**264. Ugly Number II**](#264-Ugly-Number-II)                                                             | 🟠   | Wed |          | &check;  |
| 8   | [771. Jewels and Stones](#771-Jewels-and-Stones)                                                           | 🟢   | Wed | &check;  | &check;  |
| 9   | [**3. Longest Substring Without Repeating Characters**](#3-Longest-Substring-Without-Repeating-Characters) | 🟠   | Wed |          | &check;  |
| 10  | [380. Insert Delete GetRandom O(1)](<#380-Insert-Delete-GetRandom-O(1)>)                                   | 🟠   | Wed |          |          |

**TODO:**

- **554. Brick Wall**
- **205. Isomorphic Strings**
- **560. Subarray Sum Equals K**
- **202. Happy Number**
- **264. Ugly Number II** (add approach)
- **3. Longest Substring Without Repeating Characters** (add approach)

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

Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

#### Approach

- Keep a cummulative sum and store it in the hashmap where key is sum and value is the frequency of encountering this sum
- For example, k = `7` and arr = `[3,4,7,2,-3,1,4,2]`
  - First, put `(sum = 0, freq = 1)` at the beginning, since first occurrence of `sum = 0` is outside of the iteration
  - Add every element from input array to `sum`, then whenever `sum-k` is found in the hashmap, then we know that there is a continuous subarray at `sum = k`
    - If `sum = 7`, `k = 7` -> `map.get(0) = 1`, then `ans++`
    - If `sum = 14`, `k = 7`, and `map.get(7) = 2`, then `ans+= 2`
  ```java
  // Time: O(n)
  // Space: O(n)
  public int subarraySum(int[] nums, int k) {
      int ans = 0, sum = 0;
      HashMap<Integer, Integer> map = new HashMap<>();
      map.put(sum, 1);
      for (int num: nums) {
          sum += num;
          ans += map.containsKey(sum-k) ? map.get(sum-k):0;
          map.put(sum, map.getOrDefault(sum, 0)+1);
      }
      return ans;
  }
  ```

<br>

### [1396. Design Underground System](https://leetcode.com/problems/design-underground-system/)

An underground railway system is keeping track of customer travel times between different stations. They are using this data to calculate the average time it takes to travel from one station to another.

#### Approach

- Use one hashmap to record all checkin customer. Once a customer checked out, use another hashmap to store all station-to-station time where the value is a pair(time sum, the number of records).

  ```java
  class UndergroundSystem {

      private HashMap<Pair<String, String>, Pair<Integer, Integer>> record;
      private HashMap<Integer, Pair<String, Integer>> in;

      public UndergroundSystem() {
          this.record = new HashMap<>();
          this.in = new HashMap<>();
      }

      public void checkIn(int id, String stationName, int t) {
          this.in.put(id, new Pair(stationName, t));
      }

      public void checkOut(int id, String stationName, int t) {
          Pair<String, Integer> customer = this.in.get(id);
          Pair<String, String> stations = new Pair(customer.getKey(), stationName);

          int diff = t-customer.getValue();

          Pair<Integer, Integer> time = new Pair(diff, 1);
          if (this.record.containsKey(stations)){
              time = this.record.get(stations);
              int count = time.getValue();
              int sum = time.getKey();
              time = new Pair(sum+diff, count+1);
          }

          this.record.put(stations, time);
      }

      public double getAverageTime(String startStation, String endStation) {
          double sum = 0.0;
          Pair<String, String> stations = new Pair(startStation, endStation);

          if (this.record.containsKey(stations)) {
              Pair<Integer, Integer> time = this.record.get(stations);
              sum = (double) time.getKey() / time.getValue();
          }
          return sum;
      }
  }
  ```

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

Input: jewels = `"aA"`, stones = `"aAAbbbb"`  
Output: 3

#### Approach

- Use hash set to store all jewels

  ```java
  // Time: O(J.length+S.length)
  // Space: O(J.length)
  public int numJewelsInStones(String jewels, String stones) {
      HashSet<Character> jewel = new HashSet<>();

      for (char c: jewels.toCharArray())
          jewel.add(c);

      int count = 0;
      for (char c: stones.toCharArray())
          count += jewel.contains(c) ? 1:0;

      return count;
  }
  ```

<br>

### [3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

Input: s = `"abcabcbb"`  
Output: 3

#### Approach

- TO BE added
  ```java
  // Time: O(n)
  // Space: O(n)
  public int lengthOfLongestSubstring(String s) {
      HashMap<Character, Integer> map = new HashMap<>();
      int longest = 0;
      for (int i = 0, start = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          if (map.containsKey(c))
              start = Math.max(map.get(c), start);
          longest = Math.max(longest, i - start+1);
          map.put(c, i+1);
      }
      return longest;
  }
  ```

<br>

### [380. Insert Delete GetRandom O(1)](https://leetcode.com/problems/insert-delete-getrandom-o1/)

#### Approach

<br>
```
