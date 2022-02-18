//naive approach: 
//using space, hash
//since the numbers will always start from 1, 
//we are going to be working with the length of the array
//first we just store the numbers in the map, in the 1st iteration
//second iteration, we will start looping from 1 till the length of the list
//in which each iteration we will check if the numbers are in the map or not
//the nums not in the map are what the number are not in the list, so we append it to the new array and return it.
// var findDisappearedNumbers = function(nums) {
    
//     let itemsNotInArray = [];
    
//     let hash = new Map();
//     for(let i = 0; i < nums.length; i++){
//         hash.set(nums[i], true); 
//     }
    
//     //now we know the numbers are from 1 to n so we start the iteration from 1
//     //if the hash doesnt have the value we store it in the array;
//     for(let i = 1; i <= nums.length; i++){
//         if(!hash.has(i)){
//             itemsNotInArray.push(i);
//         }
//     }
    
//     return itemsNotInArray;
// };

//optimal approach: (we are subtracting the index's value with 1 or adding the index's value with 1)
//basically loop through each index and subtract the index's value - 1
//the result we get from subtracting with the index we are going to mark the result's index value, (we are marking with -ve value)
//the second loop we are going to be looping, 
//we will be checking to see if the values in each index's are marked or not
//if the value is not marked, we will be doing index + 1 and storing the result inside the array
var findDisappearedNumbers = function(nums) {
    
    //marking the values 
    for(let i = 0; i < nums.length; i++){
        let markIndex = Math.abs(nums[i]) - 1;  //need abs here, because some values might be negative so need proper subtraction 
        nums[markIndex] = Math.abs(nums[markIndex]) * -1; //we are doing abs because some values might repeated marker
    }
    
    let itemsNotInArray = [];
    //checking the marker and storing the values
    for(let i = 0; i < nums.length; i++){
        if(nums[i] > 0){
            itemsNotInArray.push(i+1);
        }
    }
    return itemsNotInArray;
}
