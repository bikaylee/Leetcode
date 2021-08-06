August 2, 2021

### Week 3 - Heap (Priority Queue)

| No. | Problems                                                                         | Diff | Day | Previous | Finished |
| --- | -------------------------------------------------------------------------------- | ---- | --- | -------- | -------- |
| 1   | [**373. Find K Pairs with Smallest Sums**](#373-Find-K-Pairs-with-Smallest-Sums) | 🟠   | Mon |          | &check;  |
| 2   | [**973. K Closest Points to Origin**](#973-K-Closest-Points-to-Origin)           | 🟠   | Mon | &check;  | &check;  |
| 3   | [347. Top K Frequent Elements](#347-Top-K-Frequent-Elements)                     | 🟠   | Mon |          | &check;  |
| 4   | [703. Kth Largest Element in a Stream](#703-Kth-Largest-Element-in-a-Stream)     | 🟢   | Mon |          | &check;  |
| 5   | [1046. Last Stone Weight](#1046-Last-Stone-Weight)                               | 🟢   | Mon |          | &check;  |

**TODO:**

- **373. Find K Pairs with Smallest Sums**
- **973. K Closest Points to Origin**
- **347. Top K Frequent Elements** Similar to 973. K Closet Points to Origin
- 703. Kth Largest Element in a Stream
- Haven't add all problems to main list

<br>

## Monday

### [373. Find K Pairs with Smallest Sums](https://leetcode.com/problems/find-k-pairs-with-smallest-sums/)

Define a pair (u, v) which consists of one element from the first array and one element from the second array.  
Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.

Input: nums1 = `[1,7,11]`, nums2 = `[2,4,6]`, k = 4  
Output: `[[1,2],[1,4],[1,6]],[7,2]`  
Explanation: The first 4 pairs are returned from the sequence: `[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]`

#### Approach

- Define a priority queue, where each pair has to be

  - `[a0, b0], [a1, b1]`: `a` is the index of A and `b` is the index of B
    - `A[a0] + B[b0]` > `A[a1] + B[b1]`
  - Trace:
    - PQ initial state: `[[1, 2], [7, 2], [11, 2]]`
    - return list: deque PQ of `[1, 2]` must be the smallest (index of `(0,0)`)
    - Expand the index in B array: PQ = `[[1, 4], [7, 2], [11, 2]]`
    - return list: deque PQ of `[1, 4]` (index of `(0, 1)`)
    - Expand the index in B array: PQ = `[[1, 6], [7, 2], [11, 2]]`
    - return list: deque PQ of `[1, 6]` (index of `(0, 2)`)
    - Since `2` is the last index in B, do not add new pair to array
    - return list: deque PQ of `[7, 2]` (index of `(1, 0)`)
    - Expand the index in B array: PQ = `[[7, 4], [11, 2]]`

- the number of pairs in priority will always be <= N (size of A), so it will only compare in `log n` for `n` pairs

  ```java
  // Time: O(n log n)
  // Space: O(n)
  public List<List<Integer>> kSmallestPairs(int[] A, int[] B, int k) {

      // Edge Case: either array is empty or k is 0
      if (A == null || B == null || A.length == 0 || B.length == 0 || k <= 0) {
          return new ArrayList<>();
      }

      final int N = A.length;
      final int M = B.length;

      // Set up priority queue that only need to memorized the index in array A and B
      Queue<int []> pq = new PriorityQueue<>((a, b) -> A[a[0]] + B[a[1]] - A[b[0]] - B[b[1]]);

      // Initialize each pair to all element in A and first element in B
      // In the first time, (0th element in A, 0th element in B) must be the smallest pair
      // Then, push new elements of first in queue's A element index and B element index +1
      // to compare the (ith element in A, j+1 th element in B) which will always deque the sub-optimal pair
      for (int i = 0; i < N; i++) {
          pq.add(new int[]{i, 0});
      }

      List<List<Integer>> ans = new ArrayList<>();
      for (int i = 0; i < k && !pq.isEmpty(); i++) {
          int[] p = pq.poll();
          ans.add(Arrays.asList(A[p[0]], B[p[1]]));
          if (p[1] + 1 < M) {
              pq.add(new int[]{p[0], p[1]+1});
          }
      }
      return ans;
  }
  ```

<br>

### [973. K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/)

Given an array of points where `points[i] = [x_i, y_i]` represents a point on the **X-Y** plane and an integer `k`, return the `k` closest points to the origin `(0, 0)`.

**Input:** `points = [[1,3],[-2,2]]`, k = 1  
**Output:** `[[-2,2]]`  
**Explanation:**  
The distance between (1, 3) and the origin is sqrt(10).  
The distance between (-2, 2) and the origin is sqrt(8).  
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.  
We only want the closest k = 1 points from the origin, so the answer is just `[[-2,2]]`.

#### Approach

- Use the max heap to do the sorting of distance of each points, `(p1, p2)` where `((p2_x)^2 + (p2_y)^2) < ((p1_x)^2 + (p1_y)^2)`

  - represent in lambda express: `(p2_x)^2 + (p2_y)^2 - ((p1_x)^2 + (p1_y)^2)`
  - `(p1, p2) -> (p2_x)^2 + (p2_y)^2 - (p1_x)^2 - (p1_y)^2`

- To keep the sorting in `log k`, when the number of points in queue has reaches `k`, deque the biggest
- Put points into return array in reversed order

  ```java
  // Time: O(n log k)
  // Space: O(k)
  public int[][] kClosest(int[][] points, int k) {
      int [][] ans = new int[k][2];
      Queue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
      for (int [] point:points) {
          pq.add(point);
          if (pq.size() > k)
              pq.poll();
      }
      while (k > 0)
          ans[--k] = pq.poll();
      return ans;
  }
  ```

<br>

### [347. Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Input: nums = `[1,1,1,2,2,3]`, `k = 2`  
Output: `[1,2]`

#### Approach

- Same idea as [**973. K Closest Points to Origin**](#973-K-Closest-Points-to-Origin)

  ```java
  // Time: O(n log k)
  // Space: O(n)
  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> freq = new HashMap<>();
    for (int n : nums)
      freq.put(n, freq.getOrDefault(n, 0)+1);

    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));
    for (int n : freq.keySet()) {
        pq.add(n);
        if (pq.size() > k) {
          pq.poll();
        }
    }
    int [] elements = new int[k];
    while (k > 0) {
      elements[--k] = pq.poll();
    }
    return elements;
  }
  ```

<br>

### [703. Kth Largest Element in a Stream](https://leetcode.com/problems/kth-largest-element-in-a-stream/)

Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

**Only keep k elements in the stream**

#### Approach

- Maintain a min heap so that its first element is the kth largest
- Deque the smallest element when queue size is greater than or equal to k, then add the new element to always maintain k elements in queue

  ```java
  class KthLargest {
    // k = 3
    // Input:   4, 5, 8, 2
    // Sorted:  2 4 5 8
    // add(3):  2 3 4 5 8           -> 4
    // add(5):  2 3 4 5 5 8         -> 5
    // add(10): 2 3 4 5 5 8 10      -> 5
    // add(9):  2 3 4 5 5 8 9 10    -> 8
    // add(4):  2 3 4 4 5 5 8 9 10  -> 8

    private final int k;
    private PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>(k);
        this.k = k;
        for (int num: nums) {
            this.add(num);
        }
    }

    // Time: O(k log k)
    // Space: O(k)
    public int add(int n) {
        // System.out.println(q.toString());
        if (this.pq.size() < this.k) {
            this.pq.add(val);
        } else if (this.pq.peek() < val) {
            this.pq.poll();
            this.pq.add(val);
        }
        return this.pq.peek();
    }
  }
  ```

<br>

### [1046. Last Stone Weight](https://leetcode.com/problems/last-stone-weight/)

Each turn, we choose the two heaviest stones and smash them together. Suppose the stones have weights x and y with `x <= y`. The result of this smash is:

- If `x == y`, both stones are totally destroyed;
- If `x != y`, the stone of weight x is totally destroyed, and the stone of weight `y` has new weight `y-x`.

Input: `[2,7,4,1,8,1]`  
Output: `1`

**Bucket Sort** can be applied

#### Approach

- Put all elements into a max heap and deque the first two elements in the max heap to do the comparison

  ```java
  // Time: O(n log n)
  // Space: O(n)
  public int lastStoneWeight(int[] stones) {
      PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
      for (int stone: stones)
          pq.add(stone);

      while (pq.size() >= 2) {
          int y = pq.poll(), x = pq.poll();
          if (x != y)
              pq.add(y-x);
      }

      return pq.isEmpty() ? 0:pq.poll();
  }
  ```

<br>
