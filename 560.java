class Solution {
    // - Keep a cummulative sum and store it in the hashmap where key is sum and
    // value is the frequency of encountering this sum

    // - For example, k = `7` and arr = `[3,4,7,2,-3,1,4,2]`
    // - First, put `(sum = 0, freq = 1)` at the beginning, since first occurrence
    // of `sum = 0` is outside of the iteration
    // - Add every element from input array to `sum`, then whenever `sum-k` is found
    // in the hashmap, then we know that there is a continuous subarray at `sum = k`

    // -- If `sum = 7`, `k = 7` -> `map.get(0) = 1`, then `ans++`
    // -- If `sum = 14`, `k = 7`, and `map.get(7) = 2`, then `ans+= 2`

    // Time: O(n)
    // Space: O(n)
    public int subarraySum(int[] nums, int k) {
        int ans = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(sum, 1);
        for (int num : nums) {
            sum += num;
            ans += map.containsKey(sum - k) ? map.get(sum - k) : 0;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

}