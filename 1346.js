
//approach: 
//gotta check if the number's double is present in the loop or the number is the double of other number in the array
//naive approach : 
//maybe put the values in hash map and then loop to check if the double of the number exists
//but since hash takes more space, in case of double/repeated numbers, we can use set
//use set. 


//also, we need to go with the loop and check the value as we go along,
//DONT add the values and check later, this wont work
//as u iterate one by one, u check if it's double is present or its the double of any number present
//if not, u add it into the set.
var checkIfExist = function(arr) {
    
    let set = new Set();
    for(let i = 0; i < arr.length; i++){
        if(set.has(arr[i] * 2)) return true;
        else{
            if(arr[i] % 2 === 0 && set.has(arr[i]/2)) return true;
        }
        set.add(arr[i])
    }
    return false;
};
