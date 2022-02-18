var duplicateZeros = function(arr) {
    //loop through the array
    //if at ith index is 0, then
    //just use splice to add the 0 at that index, 
    //then shift the i by 1, cuz we know it will, shift the whole array length by 1
    //then delete the last element, because adding an element will increase the size 
    //so avoid overflow of the actual array size, use splice again to delete the last element.
    
    //splice(index, 0 to replace, what element u wanna replace by) --> to replace
    //splice(index, how many element to remove) --> to remove.
    for(let i = 0; i < arr.length; i++){
        if(arr[i] === 0){
            arr.splice(i, 0, 0);
            i++;
            arr.splice(arr.length-1, 1);
        }
    }
}


/*var duplicateZeros = function(arr) {
    //loop through the array
    //if at ith index is 0, then
    //just use splice to add the 0 at that index, 
    //then shift the i by 1, cuz we know it will, shift the whole array length by 1
    //then delete the last element, because adding an element will increase the size 
    //so avoid overflow of the actual array size, use splice again to delete the last element.
    
    //splice(index, 0 to replace, what element u wanna replace by) --> to replace
    //splice(index, how many element to remove) --> to remove.
    for(let i = 0; i < arr.length; i++){
        if(arr[i] === 0){
            arr.splice(i, 0, 0);
            i++;
            arr.pop();//arr.splice(arr.length-1, 1); //co
        }
    }
}
*/

