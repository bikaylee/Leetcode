// 487. Max Consecutive Ones II

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int count = 0, prevCount = -1;
        int max = 0;
        
        for(int n:nums) {
            if(n == 1) {
                count++;
            } else {
                // consective zeros 
                max = Math.max(max, prevCount>0 ? prevCount+count+1: count);
                prevCount = count;
                count = 0;
            }
        }
        
        return Math.max(max, count+prevCount+1);
    }
}