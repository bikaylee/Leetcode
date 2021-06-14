// 977. Squares of a Sorted Array


class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int p1 = 0, p2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= 0) {
                p1 = i-1;
                p2 = i;
                break;
            }
        }
        
        //System.out.println(p1 + " " + p2);
        
        
        if(p1 < 0) {
            for(int i = 0; i < nums.length; i++) {
                nums[i] *= nums[i];
            }
            return nums;
        }  else {
            int [] res = new int[nums.length];
            
            int i = 0;
            if(p1 == p2) {
                p1 = nums.length-1;
                while(p1 >= 0) {
                    res[i++]  =  nums[p1] * nums[p1];
                    p1--;
                }
            }else {
                while(p1 >= 0 && p2 < nums.length){
                    if((nums[p1]*-1) <= nums[p2]) {
                        res[i++] = nums[p1] *nums[p1]; 
                        p1--;
                    } else {
                        res[i++] = nums[p2] *nums[p2];
                        p2++;
                    }
                }

                while(p1 >= 0) {
                    res[i++] = nums[p1] * nums[p1];
                    p1--;
                } 

                while(p2 < nums.length) {
                    res[i++] = nums[p2] * nums[p2];
                    p2++;
                }
            }
            
            return res;
        }
        
    }
}