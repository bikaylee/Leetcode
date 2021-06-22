
//could use a hash map and store all the values in the 1st iteration {val:index}
//second could just subtract, target - nums[i] and map.get(target-nums[i]) != i makesure to see if the difference exists
//if it does exists, return [i, map.get(target-nums[i])]
//
//so, instead, it could be every iteration we can check if the target - arrNum[i] exists, 
//if it does, we can return (map.get(target-nums[i]), i)
//if not, we can keep putting the arrNum[i] key in map with the index value
var twoSum = function (nums, target) {
    let map = new Map();
    for (let i = 0; i < nums.length; i++) {

        if (map.has(target - nums[i])) {
            return [map.get(target - nums[i]), i];
        }
        map.set(nums[i], i); //keep inserting the value in the map
    }

    return [];
};