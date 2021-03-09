//approach: 
//we have to make a new array to compare eaach values and return count
//just make a new sorted array and return the count
var heightChecker = function(heights) {

    let sortedArray = heights.slice().sort((a,b)=> {return a-b});
    let count = 0;
    
    for(let i = 0; i < heights.length; i++){
        
        if(sortedArray[i] != heights[i]){
            count++;
        }
    }
    
    return count;
};
