//approach
//since its sorted we know that the position of all the elements, if duplicate
//using two pointer
//slow-> moves 1X
//fast-> moves 2X
//when slow and fast are equal, the fast keeps moving one step ahead, till they are not equal no more
//after slow and fast are not equal, we know fast has come to a spot where, there's no repition
//after that, we move slow by one place and change the value of slow to be value of fast
//just moving the items in the back
var removeDuplicates = function (nums) {

    let slow = 0;

    //we keep moving fast until we see that slow and fast are equal
    for (let fast = 1; fast < nums.length; fast++) {
        if (nums[slow] != nums[fast]) {
            slow++;
            nums[slow] = nums[fast];
        }
    }
    return slow + 1; //returning the length of the array
};