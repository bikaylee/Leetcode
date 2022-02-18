//how long we go until we dont see the same repeated characters? that depends on the k value
//if we go above the k, without the repeated characters then we know, we need to move the window
//we store the characters count to use it to subtract with the length of window, in order to find 
//number of character that we can change within the window. 
//we use two pointer fast and slow
var characterReplacement = function(s, k) {
    
    let slow = 0;
    let maxLenSubArray = 0;
    let charHash = {};
    let repeatedCharsNum = 0;
    
    for(let fast = 0; fast < s.length; fast++){
        //store the chars in the hash, if never seen initialze it to 1 else increment char number by 1 each time
        charHash[s[fast]] = charHash[s[fast]] + 1 || 1;
        
        //then check for the most frequent character
        //this is needed to let us know the unrepeated characte in the window later
        repeatedCharsNum = Math.max(charHash[s[fast]], repeatedCharsNum);
        
        //this is tricky part
        //we subtract the length of the window - the most repeated characters
        //                (fast+1 - slow)      -      repeatedCharsNum      //+1 is for index as we start with 0
        //--> to find the character that is not repeated in the window
        //how do we know when to move the window? 
        //well, the unrepeated character that need to be changed are > k
        while((fast+1- slow) - repeatedCharsNum > k){
            charHash[s[slow]] -= 1;  //reduce from the left 
            slow++;
        }
        
        //update on the length of the window
        //(fast+1- slow) --> is the length of the window
        maxLenSubArray = Math.max(maxLenSubArray, (fast+1- slow))
        
    }
    return maxLenSubArray;
};

