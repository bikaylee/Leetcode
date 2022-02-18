//approach: 
//two pointer: head and tail
//tail will point to the length meaning null first
//then if head equals val then head val will be replaced by tail-1 val, and tail will decrease
var removeElement = function (nums, val) {

    let head = 0;
    let tail = nums.length;

    while (head < tail) {
        if (nums[head] === val) {
            nums[head] = nums[tail - 1];
            tail--;     //this is essential to help move the ptr downwards, even if head and tail were to hit the val
        } else {
            head++;
        }
    }

    return tail;

};