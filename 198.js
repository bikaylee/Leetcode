var rob = function(nums) {
    if(nums.length === 0) return 0;
    if(nums.length === 1) return nums[0];
    if(nums.length < 3) return Math.max(nums[0], nums[1]);
    
    let arr = new Array(nums.length + 1);

    
    arr[0] = 0;
    arr[1] = nums[0];
    arr[2] = nums[1];
    let max = Math.max(arr[1], arr[2]);
    
    for(let i = 3; i <= nums.length; i++){
        arr[i] = Math.max(arr[i-2]+nums[i-1], nums[i-1] + arr[i-3]);
        max = Math.max(max, arr[i]);
    }

    return max;
};
