class Solution {
    public int majorityElement(int[] nums) {

        Arrays.sort(nums);
        return nums[nums.length / 2];

        // HashMap<Integer, Integer> map = new HashMap<>();

        // int majority = 0;
        // int count = nums.length/2;
        // for(int num: nums) {
        // map.put(num, map.getOrDefault(num, 0)+1);
        // if(map.get(num) > count)
        // majority = num;
        // }

        // return majority;
    }
}
