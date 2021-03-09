//similar to repeated substring 424. Longest Repeating Character Replacement or not really LOL!

//approach: (sliding window)
//two pointer: fast and slow
//to find a length of a window it is: fast - slow + 1;
//we dont move slow until the zero variable > k 
var longestOnes = function(A, K) {
    let maxSubArray = 0;
    let zero = 0;
    let slow = 0;
    for(let fast = 0; fast < A.length; fast++){
        if(A[fast] === 0){
            zero++;
        }
        //keep moving slow ptr forward until the zero count is less than k
        while(zero > K){
            if(A[slow] === 0){
                zero--;
            }
            slow++;
        }
        //getting the total length of the subarray
        maxSubArray = Math.max(maxSubArray, fast-slow+1);
    }
    
    return maxSubArray;
};

//the implementation will also be similar to the question Consecutive 1 if flipped 0 1time
