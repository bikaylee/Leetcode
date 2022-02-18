// 1295. Find Numbers with Even Number of Digits

class Solution {
    public int findNumbers(int[] nums) {
        int count = 0; 
        for(int n: nums) {
            int d = 1;
            while(n >= 10) {
                n /= 10; 
                d++;
                //System.out.println(d);
            }
            if(d%2==0) count++;
        }
        return count;
    }
}