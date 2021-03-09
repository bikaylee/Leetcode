
//approach: 
//have two pointers, slow and fast
//fast keeps moving while slow only moves after the numbers within the slow and fast ptr range is >= s;
//since we are trying to find a minimum range, we try to subtract the value where slow ptr lies and move slow ptr forward
//in hopes of finding a smaller range that will give us the minimum small range for minimum subarray
var minSubArrayLen = function(s, nums) {
    
    let slow = 0;
    let minSubArray = Number.MAX_VALUE; //highest value possible
    let currSum = 0;
    
    
    for(let fast = 0; fast < nums.length; fast++){
        
        currSum += nums[fast];
        
        //this second while loop doesnt go n times, it only goes until the sum >=s, Therefore, its not O(n)^2
        //we keep reducing the value until we can no longer find the currSum to be >= s;
        //we subtract fast-slow+1 because we are trying to find the range and +1 is because for index representation
        //then we pop the slow ptr's value and move slow ptr forward
        while(currSum >= s){
            minSubArray = Math.min(minSubArray, fast-slow+1);
            currSum -= nums[slow];
            slow++;
        }
    }
    
    //we know that if minSubArray = max_value, the minSubArray did not change, meaning we did not find the min subArrayValue
    return minSubArray === Number.MAX_VALUE ? 0 : minSubArray;
};
