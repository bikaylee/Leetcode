var findMaxConsecutiveOnes = function(nums) {
    //if the element at a given index is 1, increase count
    //while increasing the count, also make sure to check in the max and update it
    //
    //if the element at a given index is 0, then reset the count
    //make sure the count > 0 to reset it, to minimize the double work.
    let count = 0;
    let max = 0;
    for(let i = 0; i < nums.length; i++){
        if(nums[i] === 1){
            count++;
            if(max < count){
                max = count;
            }
        }else{
            if(count > 0){
                count = 0;
            }
        }
    }
    return max;
};

