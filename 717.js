//The idea is to move onto the next number if you've hit a zero, and 
//skip an additional number if you've hit a 1 since they'd be a "two bit" number.
//Within the for loop, you know if you ever successfully land on the last digit which is always going //to be a zero, it'll be a "one bit" character, 
//otherwise if you skip it, it does NOT exist.
var isOneBitCharacter = function(bits) {
    
    let i = 0;
    for(; i < bits.length; i++){
        //if the i is still in the range the value is one bit
        if(i === bits.length-1) return true;
        if(bits[i] === 0) continue;
        //case where bits[i] ===1
        i++;
    }
    
    return false;
};
