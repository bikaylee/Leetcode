
//since this problem depends on freq and value, concept is populating a array with value based on its //frequency. if freq is 2 and value is 6, then need to populate the array with [6,6].
//[freq, value] ==> [nums[2*i], nums[2*i+1]]
//input: array of int
//output: arry of int --> based on the freq, populated with values
//brute force: 
//since, looking at the pattern, we see that 2*i+1 always ends at the last index, that's when we //can stop the loop
//have a for loop inside the while loop, to populate the new array with the value, based on its //frequency

// var decompressRLElist = function(nums) {
//     let i = 0;
//     let arr = [];
//     while(2*i+1 <= nums.length-1){
//         let freq = nums[2*i];
        
//         for(let j = 0; j < freq; j++){
//             arr.push(nums[2*i+1]);
//         }
        
//         i++;
//     }
//     return arr;
// };


//much faster this way, as since we can see the pattern is working with two array elements at a time
var decompressRLElist = function(nums) {
    let i = 0;
    let arr = [];
    while(i <= nums.length){
        for(let j = 0; j < nums[i]; j++){
            arr.push(nums[i+1]);
        }
        
        i= i+2;
    }
    return arr;
};
