// 485. Max Consecutive Ones

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int i = 0;
        for(int j = 0; j < nums.length; j++) {
            if(nums[j] == 1) {
                i++;
            } else {
                max = Math.max(max, i);
                i = 0;
            }
        }
        // if(nums.length >= 1 && nums[nums.length-1] == 1) 
        //     max = Math.max(max,i);
        return Math.max(max,i);
    }
}