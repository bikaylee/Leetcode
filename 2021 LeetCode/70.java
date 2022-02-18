class Solution {
    
    //           _____Climbing Stairs
    //         _|4  
    //       _|3    
    //     _|2  
    // ___|1   

    // n = 1: {1}
    // n = 2: {1, 1} {2}
    
    // n = 3: 
    // ---- can be derived from (n-2) 
    // when at 2, we can take 1 step to get 3 
    //      -> {1, 2} 
    // ---- can be derived from (n-1)
    // when at 1, we can take either 1 step or 2 steps to get 3 
    //      -> {1, 1, 1}, {2, 1} 
    
    // The solution to the sub-problem is using previous 
    // calculated steps from n-1 and n-2, because we can only 
    // take 1 or 2 steps up. It implies that from n, taking 1 
    // step back plus taking 2 steps back can output the number of ways at n.
    
    public int climbStairs(int n) {
        if (n == 1)  return 1;
        int first = 1; 
        int second = 2;
        
        for (int i = 3; i <= n; i++) {
            int third = first+second;
            first = second;
            second = third;
        }        
        return second;
    }
}