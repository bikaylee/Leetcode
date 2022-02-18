
var shortestToChar = function(s, c) {
    //reword: given string and a character. I need to find if the 'c' appears in the string. 
    //          will need to keep the closest number of steps need to get from the current index to the 'c'
    //given: string 's' and character 'c'
    //return: integer array ==> will need to record all the closest steps to get to 'c'
    //edge case and constraint: since it is guaranteed that 'c' appears in 's' at least once  and 's'.length >= 1
    //                                  --> if s.length === 1 return [0] 
    
    //approach: 
    //take in consideration of two arrays, one will store the steps going from left -> right
    //                                     second will store the steps going from right -> left
    //will have a variable that will be initialized to -1
    //as i move across the string, i'll check if current pointer is == c
    // if it is i will keep my index = c
    // then subtract the pointer - index   ----> from right to left it will be index - pointer
    //then one last loop to only store the minimum value
    
    if(s.length === 1) return [0];
    
    let index = -1;
    let ltr = [];
    let rtl = [];
    
    //first pass to go left to right
    for(let i = 0; i < s.length; i++){
        if(s[i] === c) index = i;
        
        if(index !== -1) ltr[i] = i- index;     //if index is -1..keep storing big number
        else ltr[i] = s.length+1;
    }
    
    index = -1;
    
    //second pass to go right to left
    for(let i = s.length-1; i >=0; i--){
        if(s[i] === c) index = i;
        
        if(index !== -1) rtl[i] = index - i;
        else rtl[i] = s.length+1;
    }
    
    //third pass to check the minimum and store it in the ltr arrray
    for(let i = 0; i < s.length; i++){
        ltr[i] = Math.min(ltr[i] , rtl[i]);
    }
    
    
    return ltr;
};
