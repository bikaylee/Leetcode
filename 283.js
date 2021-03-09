//approach: 
//have two pointers
//slow moves 1X
//fast moves 2X
//we will only move slow to next when it's index value is not zero
//while we keep moving fast
//like that we swap values
//we will swap values till fast reaches the end of the array
var moveZeroes = function(nums) {
    
    //edge case
    //if nums = null OR
    //if nums.length = one then return the array
    if(nums === null || nums.length === 1) return nums;
    
    let slow = 0;
    let fast = 1;
    
    while(fast < nums.length){
        //if slow index is 0 but fast index is not 0, then swap
        if(nums[slow] === 0 && nums[fast] !== 0){
            [nums[slow], nums[fast]] = [nums[fast], nums[slow]];
            slow++;
            fast++;
        }
        //if slow is 0 and fast is 0, we keep moving fast
        else if(nums[slow] === 0 && nums[fast] === 0) 
            fast++
        //when slow is not zero move both
        else{
            fast++;
            slow++;
        }
    }
};

